use admin;
DROP table if exists admin;
create table admin (
                       id bigint primary key auto_increment comment '管理员表主键',
                       username varchar(20) comment '用户名',
                       password varchar(20) comment '密码',
                       gender tinyint not null default 2 comment '性别,0女 1男 2保密',
                       email varchar(20) comment '邮箱地址',
                       phone varchar(15) not null comment '手机号',
                       create_time DATE not null comment '创建时间',
                       update_time DATE not null comment '修改时间'
) comment = '管理员信息表';