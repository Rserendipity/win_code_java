create database if not exists forum;
use forum;

# 用户
create table user
(
    id           int primary key auto_increment,
    account      varchar(50) not null unique, -- 非空且唯一
    nickname     varchar(50),
    password     varchar(50) not null,        -- 加盐后的MD5值
    salt         varchar(50) not null,

    phoneNumber  char(11),
    email        varchar(50),
    avatarUrl    varchar(255),
    articleCount int,                         -- 发帖数量
    remark       text,
    role         varchar(10),                 -- USER / ADMIN 等后续可能扩展
    state        tinyint default 0,           -- 0：正常， 1：禁言
    deleteState  tinyint default 0,           -- 0：未删除，1：删除
    createTime   datetime,
    updateTime   datetime
);

# 种类
create table category
(
    id           int primary key auto_increment,
    name         varchar(100) not null unique,    -- 种类名
    articleCount int          not null default 0, -- 发帖数量
    sortCode     int          not null default 0, -- 排序代码

    state        tinyint               default 0, -- 0：正常， 1：禁用
    deleteState  tinyint               default 0, -- 0：未删除，1：删除
    createTime   datetime,
    updateTime   datetime
);

# 帖子表
create table article
(
    id          int primary key auto_increment,

    userId      int          not null,
    categoryId  int          not null,
    title       varchar(100) not null,
    content     text         not null,
    visitCount  int          not null default 0,
    replyCount  int          not null default 0,
    likeCount   int          not null default 0,


    state       tinyint               default 0, -- 0：正常， 1：禁用
    deleteState tinyint               default 0, -- 0：未删除，1：删除
    createTime  datetime,
    updateTime  datetime
);

create table article_reply
(
    id          int primary key auto_increment,

    userId      int  not null,     -- 发帖人
    articleId   int  not null,
    replyId     int  not null,
    replyUserId int  not null,
    content     text not null,
    likeCount   int  not null,

    state       tinyint default 0, -- 0：正常， 1：禁用
    deleteState tinyint default 0, -- 0：未删除，1：删除
    createTime  datetime,
    updateTime  datetime
);

create table message
(
    id            int primary key auto_increment,

    postUserId    int not null,
    receiveUserId int not null,
    content       text not null,

    state         tinyint default 0, -- 0：正常， 1：禁用
    deleteState   tinyint default 0, -- 0：未删除，1：删除
    createTime    datetime,
    updateTime    datetime
);
