package nuc.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.anno.Log;
import nuc.edu.common.R;
import nuc.edu.pojo.Resume;
import nuc.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: ResumeController
 * @Date: 2024/2/29
 * @Time: 8:32
 * @Description:添加自定义描述
 */
@RestController
@Slf4j
@RequestMapping("resume")
@Tag(name = "企业信息WEB接口")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @Operation(summary = "根据id返回企业信息实体")
    @GetMapping("{id}")
    public R<Resume> selectByJobId(@Parameter(name = "id", description = "企业信息id") @PathVariable Long id) {
        Resume resume = resumeService.getById(id);
        return R.success(resume);
    }

    @Operation(summary = "创建企业信息")
    @Log
    @PostMapping
    public R<String> create(@Parameter(name = "resume", description = "企业信息实体") @RequestBody Resume resume) {
        log.info("resume = {}", resume);
        resumeService.add(resume);
        return R.success("创建成功！");
    }

    @Operation(summary = "修改企业信息")
    @Log
    @PutMapping
    public R<String> modify(@Parameter(name = "resume", description = "企业信息实体") @RequestBody Resume resume) {
        log.info("resume = {}", resume);
        resumeService.updateResumeById(resume);
        return R.success("修改成功！");
    }


    @Operation(summary = "企业信息页的分页查询")
    @GetMapping("page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
        return R.success(resumeService.page(page, pageSize, name));
    }

    @Operation(summary = "根据id删除企业信息")
    @Log
    @DeleteMapping
    public R<String> delete(@Parameter(name = "id", description = "企业信息id") Long id) {
        log.info("id = {}", id);
        resumeService.removeById(id);
        return R.success("删除成功！");
    }
}
