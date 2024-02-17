package Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserController
 * @Date: 2024/2/17
 * @Time: 11:17
 * @Description:添加自定义描述
 */
@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("login")
    public void login() {

    }
}
