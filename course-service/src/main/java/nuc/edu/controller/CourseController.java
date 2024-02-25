package nuc.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.common.R;
import nuc.edu.pojo.Course;
import nuc.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: CourseController
 * @Date: 2024/2/20
 * @Time: 19:31
 * @Description:添加自定义描述
 */
@RestController
@Slf4j
@RequestMapping("course")
@Tag(name = "课程WEB接口")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Operation(summary = "查询所有")
    @GetMapping("/selectall")
    public R<Object> selectAll(HttpServletRequest request) {
        // TODO 1.获取当前用户
        // TODO 2.判断当前用户是否被封禁
        List<Course> courses = courseService.selectAll();
        return R.success(courses);
    }

    @Operation(summary = "根据课程id查询")
    @GetMapping("/selectbycourseId")
    public R<Object> selectByCourseId(HttpServletRequest request,
                                      @Parameter(name = "courseId", description = "courseId") @RequestParam("courseId") @NonNull Long courseId) {
        // TODO 1.获取当前用户
        // TODO 2.判断当前用户是否被封禁
        Course course = courseService.selectByCourseId(courseId);
        return R.success(course);
    }

    @Operation(summary = "创建课程")
    @PostMapping("/create")
    public R<Object> create(HttpServletRequest request,
                            @Parameter(name = "coursename", description = "coursename") @RequestParam("coursename") @NonNull String coursename,
                            @Parameter(name = "content", description = "content") @RequestParam("content") @NonNull String content) {
        // TODO 1.获取当前用户
        // TODO 2.判断当前用户是否是老师
        Course course = new Course();
        course.setCoursename(coursename);
        course.setContent(content);
        courseService.create(course);
        return R.success(course);
    }

    @Operation(summary = "修改课程")
    @PostMapping("/modify")
    public R<Object> modify(HttpServletRequest request,
                            @Parameter(name = "courseId", description = "courseId") @RequestParam("courseId") @NonNull Long courseId,
                            @Parameter(name = "coursename", description = "coursename") @RequestParam("coursename") @NonNull String coursename,
                            @Parameter(name = "content", description = "content") @RequestParam("content") @NonNull String content) {
        // TODO 1.获取当前用户
        // TODO 2.判断当前用户是否是老师
        Course course = courseService.selectByCourseId(courseId);
        if (course == null) {
            log.error("修改的课程不存在");
        }
        courseService.modify(courseId, coursename, content);
        log.info("修改成功");
        return R.success(null);
    }

    @Operation(summary = "删除课程课程")
    @PostMapping("/delete")
    public R<Object> deleteByCourseId(HttpServletRequest request,
                                      @Parameter(name = "courseId", description = "courseId") @RequestParam("courseId") @NonNull Long courseId) {
        // TODO 1.获取当前用户
        // TODO 2.判断当前用户是否是老师
        Course course = courseService.selectByCourseId(courseId);
        if (course == null) {
            return R.error("删除的课程不存在");
        }
        courseService.deleteByCourseId(courseId);
        return R.success(null);
    }

    @Operation(summary = "课程页的分页查询")
    @GetMapping("page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
        return R.success(courseService.page(page, pageSize, name));
    }
}
