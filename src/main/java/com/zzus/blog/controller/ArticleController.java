package com.zzus.blog.controller;

import com.zzus.blog.bean.dto.ArticleDetailDTO;
import com.zzus.blog.bean.dto.RespDTO;
import com.zzus.blog.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wang wei
 * 2019/9/5 10:00
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    ArticleService articleService;

    @RequestMapping("/getArticleDetail")
    public RespDTO<ArticleDetailDTO> getArticleDetail(@RequestParam(value = "articleNo") String articleNo) {

       return articleService.getArticleDetail("SN777901",1);
    }
}
