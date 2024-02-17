package Service.impl;

import Mapper.UserMapper;
import Service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pojo.User;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserServiceImpl
 * @Date: 2024/2/17
 * @Time: 11:18
 * @Description:添加自定义描述
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {}
