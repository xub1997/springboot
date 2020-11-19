package com.xub.es.service;

import com.xub.es.entity.ArticlePO;

import java.util.List;
import java.util.Optional;


/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-28 14:57
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
public interface ArticleService {

    void save(ArticlePO userESPO);

    Optional<ArticlePO> getById(Integer id) throws RuntimeException;

    void updateById(ArticlePO userESPO);

    void deleteById(Integer id);

    List<ArticlePO> getList();
}
