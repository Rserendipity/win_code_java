package com.cjj.forum.modle.vo;

import com.cjj.forum.modle.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVo implements Serializable {
    public UserVo(User user) {
        this.id = user.getId();
        this.account = user.getAccount();
        this.nickname = user.getNickname();
        this.phonenumber = user.getPhonenumber();
        this.email = user.getEmail();
        this.avatarurl = user.getAvatarurl();
        this.articlecount = user.getArticlecount();
        this.remark = user.getRemark();
        this.role = user.getRole();
        this.state = user.getState();
        this.createtime = user.getCreatetime();
    }

    private Integer id;

    private String account;

    private String nickname;

    private String phonenumber;

    private String email;

    private String avatarurl;

    private Integer articlecount;

    private String remark;

    private String role;

    private Integer state;

    private Date createtime;

}
