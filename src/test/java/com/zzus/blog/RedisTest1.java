package com.zzus.blog;

import com.alibaba.fastjson.JSONObject;
import com.zzus.blog.bean.db.ArticleDetail;
import com.zzus.blog.bean.dto.ArticleDetailDTO;
import com.zzus.blog.bean.dto.RespDTO;
import com.zzus.blog.mapper.ArticleMapper;
import com.zzus.blog.mq.PaymentNotifySender;
import com.zzus.blog.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author wang wei
 * 2019/8/23 14:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class RedisTest1 {

    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    private PaymentNotifySender sender;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleService articleService;

    private String key = "username_admin";

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void test1(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("小宝宝","早上好！");
        String userStr = stringRedisTemplate.opsForValue().get("username_admin");
        System.out.println(userStr);
        stringRedisTemplate.opsForValue().set(key,jsonObject.toJSONString(),600, TimeUnit.SECONDS);

    }


    @Test
    public void test_sender() {
        sender.sender("支付订单号："+System.currentTimeMillis());
    }


    @Test
    public void testGetArticleDetail(){
        ArticleDetail articleDetail = articleMapper.getArticleDetail("sn5400");
        logger.info("{}",articleDetail);
    }

    @Test
    public void testInsertArticleDetail(){
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleNo("SN777901");
        articleDetail.setArticleText("kakakkkfw2fhhdhahdhajdad");
        articleDetail.setAuthor(1);
        articleDetail.setStatus("1");
        articleDetail.setFavorite(0);
        articleDetail.setLike(0);
        articleMapper.addArticleDetail(articleDetail);
    }

    @Test
    public void testUpdate(){
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticleNo("SN777901");
        articleDetail.setArticleText("李晓明");
        articleDetail.setAuthor(1);
        articleDetail.setStatus("1");
        articleDetail.setFavorite(0);
        articleDetail.setLike(0);
        articleMapper.updateArticle(articleDetail);
    }


    @Test
    public void testQuery(){
        RespDTO<ArticleDetailDTO> articleDetailDTORespDTO = articleService.getArticleDetail("SN777901",1);
        logger.info("{}",articleDetailDTORespDTO.getData());
    }



}
