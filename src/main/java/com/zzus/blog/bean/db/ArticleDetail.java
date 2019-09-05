package com.zzus.blog.bean.db;

import lombok.Data;

/**
 * @author wang wei
 * 2019/9/4 15:09
 */
@Data
public class ArticleDetail {

    //主键
    private int id;
    //文章编码
    private String articleNo;
    //作者userId
    private int author;
    //文章正文
    private String articleText;
    //文章当前状态
    private String status;
    //点赞数量
    private int like;
    //收藏数量
    private int favorite;

}
