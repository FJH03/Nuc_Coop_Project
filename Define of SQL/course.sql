use zwf_course_db;
DROP table if exists course;
create table course (
                        id bigint primary key auto_increment comment '课程表主键',
                        coursename varchar(15) not null comment '课程名称',
                        content text comment '课程内容',
                        course_type tinyint not null comment '课程性质(0必修，1选修)',
                        create_time DATE not null comment '创建时间',
                        update_time DATE not null comment '修改时间'
) comment = '课程表';

insert into zwf_course_db.course value (null, '高等数学', '理工必修课', 1, '2024-02-24', '2024-02-25');
insert into zwf_course_db.course value (null, '线性代数', '理工必修课', 1, '2024-02-24', '2024-02-25');
insert into zwf_course_db.course value (null, '大学物理', '理工必修课', 1, '2024-02-24', '2024-02-25');
insert into zwf_course_db.course value (null, '习近平思想与概论', '工科必修课', 1, '2024-02-24', '2024-02-25');
insert into zwf_course_db.course value (null, '马克思主义原理', '工科必修课', 1, '2024-02-24', '2024-02-25');
insert into zwf_course_db.course value (null, '改革开放史', '选修课', 0, '2024-02-24', '2024-02-25');
insert into zwf_course_db.course value (null, '大学生职业发展规划', '选修课', 0, '2024-02-24', '2024-02-25');