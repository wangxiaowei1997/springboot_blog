package com.zzus.blog.bean.dto;

import lombok.Data;

/**
 * @author wang wei
 * 2019/9/5 10:01
 */
@Data
public class ArticleDetailDTO {

    //文章编码
    private String articleNo;
    //作者userId
    private int author;
    //作者昵称
    private String authorName;

    //文章正文
    private String articleText;

    //文章当前状态
    private String status;
    //文章当前状态名称
    private String statusName;

    //点赞数量
    private int like;
    //收藏数量
    private int favorite;
}
