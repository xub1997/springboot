package com.xub.es.dao;

import com.xub.es.entity.ArticlePO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-28 14:59
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Repository
public interface ArticleRepository extends ElasticsearchRepository<ArticlePO,Integer> {
}
