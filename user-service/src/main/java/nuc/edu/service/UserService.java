package nuc.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import nuc.edu.pojo.User;

import java.util.List;
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

    void changestatue(List<Long> ids, byte status);

    Page page(int page, int pageSize, String name);
}
