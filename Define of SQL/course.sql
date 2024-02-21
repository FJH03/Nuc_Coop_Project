use course;
DROP table if exists course;
create table course (
                        id bigint primary key auto_increment comment '课程表主键',
                        coursename varchar(100) not null comment '课程名称',
                        content text not null comment '课程内容',
                        create_time DATE not null comment '创建时间',
                        update_time DATE not null comment '修改时间'
) comment = '课程表';