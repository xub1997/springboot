package com.xub.es;


import com.xub.es.entity.ArticlePO;
import com.xub.es.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            ArticlePO articlePO = new ArticlePO();
            articlePO.setSmallType(i);
            articlePO.setBigType(i+1);
            articlePO.setTitle("测试标题"+i);
            articlePO.setContent("测试内容"+i);
            articleService.save(articlePO);
        }
    }

}
