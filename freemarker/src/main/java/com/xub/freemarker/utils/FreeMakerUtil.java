package com.xub.freemarker.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

/**
 * @author liqingxu
 * @desc aaaa.FreeMakerUtil
 * @date 2021/7/5 17:58
 */
public class FreeMakerUtil {

    private static volatile FreeMakerUtil instance;
    private static Configuration cfg;
    private static final String defaultEncoding = "UTF-8";

    private FreeMakerUtil() {
    }

    //做成单例模式
    public static FreeMakerUtil getInstance() {
        if (instance == null) {
            synchronized (FreeMakerUtil.class) {
                if (instance == null) {
                    cfg = new Configuration(Configuration.getVersion());
                    cfg.setClassForTemplateLoading(FreeMakerUtil.class, "");
                    cfg.setDefaultEncoding(defaultEncoding);
                    instance = new FreeMakerUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 获取模版
     *
     * @param templateName
     * @return
     * @throws IOException
     */
    private Template getTemplate(String templateName) throws IOException {
        return getTemplate(templateName, new File(this.getClass().getResource("/").getPath() + "/templates/"));
    }

    /**
     * 获取模版
     *
     * @param templateName
     * @return
     * @throws IOException
     */
    private Template getTemplate(String templateName, File dir) throws IOException {
        cfg.setDirectoryForTemplateLoading(dir);
        return cfg.getTemplate(templateName);
    }

    /**
     * 控制台输出
     *
     * @param map
     * @param templateName
     * @throws IOException
     * @throws TemplateException
     */
    public void print(Map<String, Object> map, String templateName) throws IOException, TemplateException {
        print(map, templateName, new PrintWriter(System.out));
    }

    /**
     * 控制台输出
     *
     * @param map
     * @param templateName
     * @throws IOException
     * @throws TemplateException
     */
    public void print(Map<String, Object> map, String templateName, Writer writer) throws IOException, TemplateException {
        getTemplate(templateName).process(map, writer);
    }

    /**
     * 输出到指定位置
     *
     * @param map
     * @param templateName
     * @param path
     * @throws IOException
     * @throws TemplateException
     */
    public void print2File(Map<String, Object> map, String templateName, String path) throws IOException, TemplateException {
        print2File(map, templateName, new File(path));
    }

    /**
     * 输出到指定位置
     *
     * @param map
     * @param dir
     * @param templateName
     * @param path
     * @throws IOException
     * @throws TemplateException
     */
    public void print2File(Map<String, Object> map, File dir, String templateName, String path) throws IOException, TemplateException {
        print2File(map, dir, templateName, new File(path));
    }

    /**
     * 输出到指定位置
     *
     * @param map
     * @param templateName
     * @param outPutFile
     * @throws IOException
     * @throws TemplateException
     */
    public void print2File(Map<String, Object> map, String templateName, File outPutFile) throws IOException, TemplateException {
        print2File(map, templateName, new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPutFile), defaultEncoding)));
    }

    /**
     * 输出到指定位置
     *
     * @param map
     * @param dir
     * @param templateName
     * @param outPutFile
     * @throws IOException
     * @throws TemplateException
     */
    public void print2File(Map<String, Object> map, File dir, String templateName, File outPutFile) throws IOException, TemplateException {
        print2File(map, dir, templateName, new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPutFile), defaultEncoding)));
    }

    /**
     * 输出到指定位置
     *
     * @param map
     * @param templateName
     * @param writer
     * @throws IOException
     * @throws TemplateException
     */
    public void print2File(Map<String, Object> map, String templateName, Writer writer) throws IOException, TemplateException {
        getTemplate(templateName).process(map, writer);
    }

    /**
     * 输出到指定位置
     *
     * @param map
     * @param dir
     * @param templateName
     * @param writer
     * @throws IOException
     * @throws TemplateException
     */
    public void print2File(Map<String, Object> map, File dir, String templateName, Writer writer) throws IOException, TemplateException {
        getTemplate(templateName, dir).process(map, writer);
    }


}
