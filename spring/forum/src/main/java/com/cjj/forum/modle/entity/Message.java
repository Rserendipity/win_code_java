package com.cjj.forum.modle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName message
 */
@TableName(value ="message")
@Data
public class Message implements Serializable {
    private Integer id;

    private Integer postuserid;

    private Integer receiveuserid;

    private String content;

    private Integer state;

    private Integer deletestate;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}