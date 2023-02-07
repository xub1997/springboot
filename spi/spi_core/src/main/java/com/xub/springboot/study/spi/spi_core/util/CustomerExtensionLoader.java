package com.xub.springboot.study.spi.spi_core.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-08
 */
@Slf4j
@Component
public class CustomerExtensionLoader {


    @Autowired
    private SpringUtil springUtil;

    private static ConcurrentMap<Class<?>, Map<String, Object>> EXTENSION_LOADERS = new ConcurrentHashMap<>();
    private static final String SERVICES_DIRECTORY = "META-INF/spi/";

    public Map<String, Object> getExtensionLoader(Class<?> type, ClassLoader classLoader) {
        if (type == null) {
            throw new IllegalArgumentException("Extension type == null");
        }
        if (!type.isInterface()) {
            throw new IllegalArgumentException("Extension type (" + type + ") is not an interface!");
        }
        Map<String, Object> loader = EXTENSION_LOADERS.get(type);
        if (loader == null) {
            synchronized (CustomerExtensionLoader.class) {
                loader = EXTENSION_LOADERS.get(type);
                if (loader == null) {
                    EXTENSION_LOADERS.putIfAbsent(type, loadExtensionClass(type.getName(), classLoader));
                    loader = EXTENSION_LOADERS.get(type);
                }
            }
        }
        return loader;
    }

    public Map<String, Object> refresh(Class<?> type, ClassLoader classLoader) {
        Set<Class<?>> classes = EXTENSION_LOADERS.keySet();
        for (Class<?> aClass : classes) {
            Map<String, Object> loader = EXTENSION_LOADERS.get(aClass);
            Set<String> beanNames = loader.keySet();
            for (String beanName : beanNames) {
                Object object = loader.get(beanName);
                springUtil.removeBean(object.getClass().getSimpleName() + beanName, object.getClass());
            }

        }
        EXTENSION_LOADERS.clear();
        return getExtensionLoader(type, classLoader);
    }


    private Map<String, Object> loadExtensionClass(String type, ClassLoader classLoader) {
        Map<String, Object> extensionClasses = new HashMap<>();
        loadDirectory(extensionClasses, SERVICES_DIRECTORY, type, classLoader);
        return extensionClasses;
    }

    private void loadDirectory(Map<String, Object> extensionClasses, String dir, String type, ClassLoader classLoader) {
        String fileName = dir + type;
        try {
            Enumeration<URL> urls;
            if (classLoader == null) {
                classLoader = findClassLoader();
            }
            if (classLoader != null) {
                urls = classLoader.getResources(fileName);
            } else {
                urls = ClassLoader.getSystemResources(fileName);
            }
            if (urls != null) {
                while (urls.hasMoreElements()) {
                    URL resourcesURL = urls.nextElement();
                    loadResources(extensionClasses, classLoader, resourcesURL);
                }
            }
        } catch (Throwable t) {
            log.error("Exception occurred when loading extension class (interface: {}, description file: {}).", type, fileName, t);
        }
    }

    private void loadResources(Map<String, Object> extensionClasses, ClassLoader classLoader, URL resourceURL) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceURL.openStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    final int ci = line.indexOf('#');
                    if (ci >= 0) {
                        line = line.substring(0, ci);
                    }
                    line = line.trim();
                    if (line.length() > 0) {
                        try {
                            String name = null;
                            int i = line.indexOf('=');
                            if (i > 0) {
                                name = line.substring(0, i).trim();
                                line = line.substring(i + 1).trim();
                            }
                            if (line.length() > 0) {
                                loadClass(extensionClasses, resourceURL, Class.forName(line, true, classLoader), name);
                            }
                        } catch (Throwable t) {
                            throw new IllegalStateException("Failed to load extension class (class line: " + line + ") in " + resourceURL + ", cause: " + t.getMessage(), t);
                        }
                    }
                }
            }
        } catch (Throwable t) {
            log.error("Exception occurred when loading extension class (class file: {}) in {}", resourceURL, resourceURL, t);
        }
    }

    private static ClassLoader findClassLoader() {
        return DefaultListableBeanFactory.class.getClassLoader();
    }

    private void loadClass(Map<String, Object> extensionClasses, java.net.URL resourceURL, Class<?> clazz, String name) throws NoSuchMethodException {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalStateException("No such extension name for the class " + name + " in the config " + resourceURL);
        }
        saveInExtensionClass(extensionClasses, clazz, name);
    }

    private void saveInExtensionClass(Map<String, Object> extensionClasses, Class<?> clazz, String name) {
        Object o = extensionClasses.get(name);
        if (o == null) {
            Object bean = parseClassToSpringBean(name, clazz);
            extensionClasses.put(name, bean);
        }
    }

    private Object parseClassToSpringBean(String name, Class<?> obj) {
        String beanName = obj.getSimpleName().concat(name);
        springUtil.registerBean(beanName, obj);
        return springUtil.getBean(beanName);
    }

}
