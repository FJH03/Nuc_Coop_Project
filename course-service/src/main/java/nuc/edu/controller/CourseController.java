package nuc.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.common.R;
import nuc.edu.pojo.Course;
import nuc.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @Operation(summary = "根据课程id返回课程实体")
    @GetMapping("/{id}")
    public R<Object> selectByCourseId(@Parameter(name = "id", description = "课程id") @PathVariable Long id) {
        Course course = courseService.getById(id);
        return R.success(course);
    }

    @Operation(summary = "创建课程")
    @PostMapping("/create")
    public R<String> create(@Parameter(name = "course", description = "课程实体") Course course) {
        courseService.add(course);
        return R.success("创建成功！");
    }

    @Operation(summary = "修改课程")
    @PutMapping
    public R<String> modify(@Parameter(name = "course", description = "课程实体") @RequestBody Course course) {
        log.info("course = {}", course);
        courseService.updateCourseById(course);
        return R.success("修改成功！");
    }


    @Operation(summary = "课程页的分页查询")
    @GetMapping("page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
        return R.success(courseService.page(page, pageSize, name));
    }

    @Operation(summary = "根据id删除课程")
    @DeleteMapping("{id}")
    public R<String> delete(@Parameter(name = "id", description = "课程id") @PathVariable Long id) {
        courseService.removeById(id);
        return R.success("删除成功！");
    }
}
