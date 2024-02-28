package nuc.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.common.R;
import nuc.edu.pojo.Admin;
import nuc.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042619-赵彦博
 * @ClassName: AdminController
 * @Date: 2024/2/19
 * @Time: 15:54
 * @Description:添加自定义描述
 */
@RestController
@Slf4j
@RequestMapping("admin")
@Tag(name = "管理员WEB访问接口")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Operation(summary = "管理员登陆")
    @PostMapping("login")
    public R<Admin> login(@RequestBody Admin admin) {
        log.info("admin = {}", admin);
        return R.success(adminService.login(admin));
    }

    @Operation(summary = "管理员登出")
    @PostMapping("logout")
    public R<String> logout() {
        log.info("正在执行登出操作。");
        adminService.logout();
        return R.success("管理员登出成功！");
    }
}
