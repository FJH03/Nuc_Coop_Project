package nuc.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.anno.Log;
import nuc.edu.service.UserService;
import nuc.edu.common.R;
import nuc.edu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserController
 * @Date: 2024/2/17
 * @Time: 11:17
 * @Description:添加自定义描述(不要在该层使用AOP日志@Log注解,存在bug)
 */
@Slf4j
@RestController
@RequestMapping("user")
@Tag(name = "用户服务WEB访问接口")
public class UserController {
    @Autowired
    private UserService userService;
    @Operation(summary = "用户登陆")
    @PostMapping("login")
    public R<String> login(@RequestBody Map map) {
        log.info(map.toString());
        return R.success(userService.login(map));
    }

    @Operation(summary = "用户登出")
    @Log
    @PostMapping("logout")
    public R<String> logout() {
        log.info("正在执行登出操作。");
        userService.logout();
        return R.success("用户登出成功！");
    }

    @Operation(summary = "用户页的分页查询")
    @GetMapping("page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page = {}, pageSize = {}, name = {}", page, pageSize, name);
        return R.success(userService.page(page, pageSize, name));
    }

    @Operation(summary = "发送短信验证码")
    @PostMapping("sendMsg")
    public R<String> sendMsg(@RequestBody User user) {
        log.info("user = {}", user);

        if (userService.sendMsg(user)) {
            return R.success("短信发送成功！");
        }

        return R.error("短信发送失败！");
    }

    @Operation(summary = "更新用户数据")
    @PutMapping
    private R<String> updateUserById(@RequestBody User user) {
        log.info("user = {}", user);
        userService.updateUserById(user);
        return R.success("修改成功！");
    }

    @Operation(summary = "通过id获得用户实体")
    @GetMapping("{id}")
    public R<User> getUserById(@PathVariable long id) {
        log.info("id = {}", id);
        return R.success(userService.getUserById(id));
    }
}
