package com.zzus.blog.service;

import com.zzus.blog.bean.db.ArticleDetail;
import com.zzus.blog.bean.dto.ArticleDetailDTO;
import com.zzus.blog.bean.dto.RespDTO;
import com.zzus.blog.mapper.ArticleMapper;
import com.zzus.blog.utils.BeanCopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wang wei
 * 2019/9/5 11:36
 */
@Service
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    public RespDTO<ArticleDetailDTO> getArticleDetail(String articleNo,int userId){

        ArticleDetail articleDetail =  articleMapper.getArticleDetail(articleNo);
        ArticleDetailDTO articleDetailDTO = BeanCopyUtil.map(articleDetail,ArticleDetailDTO.class);
        articleDetailDTO.setAuthorName("王小微");
        articleDetailDTO.setStatusName("发布");

        return RespDTO.success(articleDetailDTO);
    }
}
