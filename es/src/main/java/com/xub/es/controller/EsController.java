package com.xub.es.controller;

import com.xub.es.entity.ArticlePO;
import com.xub.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-12-02 09:22
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@RestController
public class EsController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    public void save(ArticlePO userESPO) {
        articleService.save(userESPO);
    }

    @GetMapping("/article/{id}")
    public ArticlePO getById(@PathVariable("id") Integer id) {
        ArticlePO result = null;
        Optional<ArticlePO> optionalArticlePO = articleService.getById(id);
        if(optionalArticlePO.isPresent()){
            result = optionalArticlePO.get();
        }
        return result;
    }

    @PutMapping("/article/{id}")
    public void updateById(@PathVariable("id")Integer id, ArticlePO userESPO) {
        userESPO.setId(id);
        articleService.updateById(userESPO);
    }

    @DeleteMapping("/article/{id}")
    public void deleteById(@PathVariable("id")Integer id) {
        articleService.deleteById(id);
    }

    @GetMapping("/articles")
    public List<ArticlePO> getList() {
        return articleService.getList();
    }
}
