use course;
DROP table if exists course;
create table course (
                        id bigint primary key auto_increment comment '课程表主键',
                        coursename varchar(15) not null comment '课程名称',
                        content text comment '课程内容',
                        course_type tinyint not null comment '课程性质(0必修，1选修)',
                        create_time DATE not null comment '创建时间',
                        update_time DATE not null comment '修改时间'
) comment = '课程表';

insert into course value (null, '高等数学', '理工必修课', 1, '2024-02-24', '2024-02-25');