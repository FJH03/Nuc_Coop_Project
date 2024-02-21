package nuc.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.common.R;
import nuc.edu.pojo.Admin;
import nuc.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public R<Admin> login(@RequestBody Admin admin) {
        log.info("admin = {}", admin);
        return R.success(adminService.login(admin));
    }

    @PostMapping("logout")
    public R<String> logout(HttpServletRequest req) {
        log.info("正在执行登出操作。");
        req.removeAttribute("admin");
        return R.success("管理员登出成功！");
    }
}
