package nuc.edu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nuc.edu.mapper.CourseMapper;
import nuc.edu.pojo.Course;
import nuc.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: CourseService
 * @Date: 2024/2/20
 * @Time: 19:30
 * @Description:添加自定义描述
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectAll() {
        List<Course> courses = courseMapper.selectList(null);
        return courses;
    }

    @Override
    public Course selectByCourseId(Long courseId) {
        Course course = courseMapper.selectById(courseId);
        return course;
    }

    @Override
    public void create(Course course) {
        if (course == null) {
            log.error("该课程无法创建");
        }
        course.setCreateTime(LocalDateTime.now());
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.insert(course);
    }

    @Override
    public void modify(Long courseId, String coursename, String content) {
        if (courseId == null || StringUtils.isEmpty(coursename)
                || StringUtils.isEmpty(content)) {
            log.error("修改课程内容错误");
        }
        Course updateCourse = new Course();
        updateCourse.setId(courseId);
        updateCourse.setCoursename(coursename);
        updateCourse.setContent(content);
        updateCourse.setUpdateTime(LocalDateTime.now());
        courseMapper.updateById(updateCourse);
    }

    @Override
    public void deleteByCourseId(Long courseId) {
        if (courseId == null || courseId <= 0) {
            log.error("参数错误");
        }
        Course course = courseMapper.selectById(courseId);
        if (course == null) {
            log.error("该课程不存在");
        }
        courseMapper.deleteById(courseId);
    }
}
