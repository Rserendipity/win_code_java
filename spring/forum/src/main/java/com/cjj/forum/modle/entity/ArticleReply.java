package com.cjj.forum.modle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName article_reply
 */
@TableName(value ="article_reply")
@Data
public class ArticleReply implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer articleid;

    private Integer replyid;

    private Integer replyuserid;

    private String content;

    private Integer likecount;

    private Integer state;

    private Integer deletestate;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}