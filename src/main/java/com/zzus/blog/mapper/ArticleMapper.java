package com.zzus.blog.mapper;

import com.zzus.blog.bean.db.ArticleDetail;

/**
 * @author wang wei
 * 2019/9/4 15:39
 */
public interface ArticleMapper {

     ArticleDetail getArticleDetail(String articleNo);

     void addArticleDetail(ArticleDetail articleDetail);

     void updateArticle(ArticleDetail articleDetail);
}
