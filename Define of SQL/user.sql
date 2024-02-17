DROP table if exists user;
create table user (
                      id bigint primary key auto_increment comment '用户表主键',
                      username varchar(20) comment '用户名',
                      password varchar(20) comment '密码',
                      gender tinyint not null default 2 comment '性别,0女 1男 2保密',
                      email varchar(20) comment '邮箱地址',
                      avatar_url varchar(20) comment '头像',
                      phone varchar(15) not null comment '手机号',
                      status tinyint not null default 0 comment '状态0正常1禁言',
                      create_time DATE not null comment '创建时间',
                      update_time DATE not null comment '修改时间',
                      remark varchar(50) default '这个用户很懒，还没做自我介绍' comment '自我介绍',
                      type int comment '用户类型0老师，1学生'
) comment = '用户信息表';