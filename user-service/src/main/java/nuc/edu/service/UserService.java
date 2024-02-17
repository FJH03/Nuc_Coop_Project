package nuc.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import nuc.edu.pojo.User;

import java.util.Map;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserService
 * @Date: 2024/2/17
 * @Time: 11:18
 * @Description:添加自定义描述
 */
public interface UserService extends IService<User> {
    User login(Map map);

    boolean sendMsg(User user);
}
