package nuc.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import nuc.edu.pojo.Course;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: CourseService
 * @Date: 2024/2/20
 * @Time: 19:30
 * @Description:添加自定义描述
 */
public interface CourseService extends IService<Course> {
    Page page(int page, int pageSize, String name);
    void updateCourseById(Course course);
    void add(Course course);
}
