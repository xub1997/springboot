package com.xub.es.service.impl;

import com.xub.es.dao.ArticleRepository;
import com.xub.es.entity.ArticlePO;
import com.xub.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-28 14:58
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void save(ArticlePO userESPO) {
        articleRepository.save(userESPO);
    }

    @Override
    public Optional<ArticlePO> getById(Integer id) throws RuntimeException {
        return articleRepository.findById(id);
    }

    @Override
    public void updateById(ArticlePO userESPO) {
        articleRepository.save(userESPO);
    }

    @Override
    public void deleteById(Integer id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<ArticlePO> getList() {
        return null;
    }
}
