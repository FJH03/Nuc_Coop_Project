use admin;
DROP table if exists admin;
create table admin (
                       id bigint primary key auto_increment comment '管理员表主键',
                       username varchar(20) comment '用户名',
                       password varchar(50) comment '密码',
                       gender tinyint not null default 2 comment '性别,0女 1男 2保密',
                       email varchar(20) comment '邮箱地址',
                       phone varchar(15) comment '手机号',
                       create_time DATE not null comment '创建时间',
                       update_time DATE not null comment '修改时间'
) comment = '管理员信息表';

insert admin (id, username, password, gender, email, phone, create_time, update_time) value (null, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 2, null, null, '2024-02-19', '2024-02-20');