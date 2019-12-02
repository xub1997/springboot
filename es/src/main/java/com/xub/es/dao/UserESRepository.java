package com.xub.es.dao;

import com.xub.es.entity.UserESPO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-28 14:59
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
public interface UserESRepository extends ElasticsearchRepository<UserESPO,String> {
}
