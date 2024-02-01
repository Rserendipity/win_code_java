package com.cjj.forum.modle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer categoryid;

    private String title;

    private String content;

    private Integer visitcount;

    private Integer replycount;

    private Integer likecount;

    private Integer state;

    private Integer deletestate;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}