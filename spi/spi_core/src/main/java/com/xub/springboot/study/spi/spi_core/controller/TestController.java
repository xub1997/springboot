package com.xub.springboot.study.spi.spi_core.controller;

import com.xub.springboot.study.spi.spi_core.util.CustomerExtensionLoader;
import com.xub.springboot.study.spi.spi_data.service.CustomerDubboService;
import com.xub.springboot.study.spi.spi_data.service.SpiService;
import com.xub.springboot.study.spi.spi_core.util.ClassLoaderUtil;
import com.xub.springboot.study.spi.spi_core.util.JarLoader;
import com.xub.springboot.study.spi.spi_core.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-07
 */
@RestController
public class TestController {

    @Autowired
    private SpringUtil springUtil;

    @Autowired
    private CustomerExtensionLoader customerExtensionLoader;

    private static final ConcurrentMap<String, SpiService> loadServices = new ConcurrentHashMap<>();

    private static final List<String> loadPaths = new CopyOnWriteArrayList<>();

    /**
     * 运行时注册bean
     */
    @GetMapping("/load")
    public void reload(@RequestParam("url") String url,
                       @RequestParam("clazzName") String clazzName) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoaderUtil.getClassLoader(url);
        Class<?> clazz = classLoader.loadClass(clazzName);
        springUtil.registerBean(clazz.getName(), clazz);
        System.out.println(springUtil.getBean(clazz.getName()));
    }

    /**
     * 运行时注册bean
     */
    @GetMapping("/spi")
    public void spi() {
        Iterator<SpiService> iterator = ServiceLoader.load(SpiService.class).iterator();
        while (iterator.hasNext()) {
            SpiService spiService = iterator.next();
            spiService.hello();
        }
    }

    /**
     * 指定路径加载
     */
    @GetMapping("/spiLoad")
    public void spiLoad(@RequestParam("path") String path) {

        ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
        JarLoader jarLoader = new JarLoader(new String[]{path});
        Thread.currentThread().setContextClassLoader(jarLoader);
        Iterator<SpiService> iterator = ServiceLoader.load(SpiService.class).iterator();
        while (iterator.hasNext()) {
            SpiService spiService = iterator.next();
            System.out.println(spiService.getClass().getName());
            spiService.hello();
        }
        jarLoader = null;
        Thread.currentThread().setContextClassLoader(oldClassLoader);
    }

    /**
     * 参考dubbo 实现spi
     */
    @GetMapping("/spiLoad/dubbo")
    public void customerSpi(@RequestParam("path") String path) {
        ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
        JarLoader jarLoader = new JarLoader(new String[]{path});
        Thread.currentThread().setContextClassLoader(jarLoader);
        Map<String, Object> objectMap = customerExtensionLoader.getExtensionLoader(CustomerDubboService.class, jarLoader);
        final Set<String> beanNames = objectMap.keySet();
        for (String beanName : beanNames) {
            CustomerDubboService customerDubboService = (CustomerDubboService) objectMap.get(beanName);
            customerDubboService.hello(customerDubboService.getClass().getSimpleName());
        }
        jarLoader = null;
        Thread.currentThread().setContextClassLoader(oldClassLoader);
    }


}
