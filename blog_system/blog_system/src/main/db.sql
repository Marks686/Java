--  这个文件主要写建库建表的语句.

create database if not exists java106_blog_system;
use java106_blog_system;

-- 删除旧表 重建新表
drop table if exists user;
drop table if exists blog;

-- 创建表
create table blog(
    blogId int primary key auto_increment,
    title varchar(128),
    content varchar(4096),
    postTime datetime,
    userId int
);

create table user(
    userId int primary key auto_increment,
    username varchar(20) unique, -- 要去用户名和别人不重复
    password varchar(20)
);

-- 构造测试数据
insert into blog values(1, '这是我的第一篇博客','从今天开始我要认真敲代码',now(),1);
insert into blog values(2, '这是我的第二篇博客','从昨天天开始我要认真敲代码',now(),1);
insert into blog values(3, '这是我的第三篇博客','从前天开始我要认真敲代码',now(),1);
