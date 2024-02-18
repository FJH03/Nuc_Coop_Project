package nuc.edu.client;

import nuc.edu.common.R;
import nuc.edu.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserClients
 * @Date: 2024/2/18
 * @Time: 10:31
 * @Description:添加自定义描述
 */
@FeignClient(value = "userservice")
public interface UserClient {
    @PostMapping("login")
    R<String> login(@RequestBody Map map0);

    @PostMapping("sendMsg")
    R<String> sendMsg(@RequestBody User user);
}
