package nuc.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nuc.edu.mapper.CourseMapper;
import nuc.edu.pojo.Course;
import nuc.edu.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    @Override
    public Page page(int page, int pageSize, String name) {
        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper<Course>()
                .like(StringUtils.isNotEmpty(name), Course::getCoursename, name)
                .orderByDesc(Course::getUpdateTime);

        //执行查询
        return this.page(pageInfo, lambdaQueryWrapper);
    }

    @Override
    public void updateCourseById(Course course) {
        course.setUpdateTime(LocalDateTime.now());
        this.updateById(course);
    }

    @Override
    public void add(Course course) {
        course.setCreateTime(LocalDateTime.now());
        course.setCreateTime(LocalDateTime.now());
        this.save(course);
    }

}
