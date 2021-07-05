package com.xub.freemarker.controller;

import com.sun.deploy.net.HttpResponse;
import com.xub.freemarker.entity.Student;
import com.xub.freemarker.utils.FreeMakerUtil;
import freemarker.template.TemplateException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liqingxu
 * @desc GeneratorController
 * @date 2021/4/29 9:44
 */
@RestController
public class GeneratorController {

    @GetMapping("/freeMaker")
    public void test() {
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        httpServletResponse.setCharacterEncoding("utf-8");
        List<Student> list = new ArrayList<>();

        Student s1 = new Student();
        s1.setIdNo("No1");
        s1.setName("Tom");
        list.add(s1);

        Student s2 = new Student();
        s2.setIdNo("No2");
        s2.setName("David");
        list.add(s2);
        Map<String, Object> map = new HashMap<>();
        map.put("students", list);
        map.put("code", "测试");
        try {
            FreeMakerUtil.getInstance().print(map, "freemaker.ftl", httpServletResponse.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
