package nuc.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.common.R;
import nuc.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: AdminController
 * @Date: 2024/2/19
 * @Time: 15:54
 * @Description:添加自定义描述
 */
@RestController
@Slf4j
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("status/{statu}")
    public R<String> changestatus(@RequestParam List<Long> ids, @PathVariable byte statu) {
        log.info("ids = {}", ids);
        adminService.changestu(ids, statu);
        return R.success("成功操作！");
    }

    @GetMapping("page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
        return R.success(adminService.page(page, pageSize, name));
    }
}
