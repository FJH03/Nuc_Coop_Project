package nuc.edu.controller;

import lombok.extern.slf4j.Slf4j;
import nuc.edu.service.UserService;
import nuc.edu.common.utils.JwtUtil;
import nuc.edu.common.R;
import nuc.edu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserController
 * @Date: 2024/2/17
 * @Time: 11:17
 * @Description:添加自定义描述
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public R<String> login(@RequestBody Map map0) {
        log.info(map0.toString());
        User u = userService.login(map0);
        if (u != null) {
            Map<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(u.getId()));
            map.put("phone", u.getPhone());

            String str = JwtUtil.getToken(map);
            return R.success(str);
        } else {
            return R.error("用户名或密码错误");
        }
    }

    @PostMapping("sendMsg")
    public R<String> sendMsg(@RequestBody User user) {
        log.info("user = {}", user);

        if (userService.sendMsg(user)) {
            return R.success("短信发送成功！");
        }

        return R.error("短信发送失败！");
    }

    @PostMapping("status/{statu}")
    private void changestatus(@RequestParam List<Long> ids, @PathVariable byte statu) {
        log.info("管理员调用本服务，参数ids = {}, status={}", ids, statu);
        userService.changestatue(ids, statu);
    }
}
