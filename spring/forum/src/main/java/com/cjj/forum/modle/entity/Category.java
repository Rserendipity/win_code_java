package com.cjj.forum.modle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category implements Serializable {
    private Integer id;

    private String name;

    private Integer articlecount;

    private Integer sortcode;

    private Integer state;

    private Integer deletestate;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}