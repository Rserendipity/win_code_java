package com.cjj.forum.modle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    @TableId(type =  IdType.AUTO)
    private Integer id;

    private String account;

    private String nickname;

    private String password;

    private String salt;

    private String phonenumber;

    private String email;

    private String avatarurl;

    private Integer articlecount;

    private String remark;

    private String role;

    private Integer state;

    private Integer deletestate;

    private Date createtime;

    private Date updatetime;

//    private static final long serialVersionUID = 1L;
}
