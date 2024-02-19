package nuc.edu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserClient
 * @Date: 2024/2/19
 * @Time: 15:52
 * @Description:添加自定义描述
 */
@FeignClient("userservice")
public interface UserClient {
    @PostMapping("user/status/{statu}")
    void changestu(@RequestParam List<Long> ids,@PathVariable byte statu);
}
