package nuc.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.mapper.UserMapper;
import nuc.edu.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nuc.edu.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import nuc.edu.pojo.User;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UserServiceImpl
 * @Date: 2024/2/17
 * @Time: 11:18
 * @Description:添加自定义描述
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Override
    public User login(Map map) {
        String phone = map.get("phone").toString();
        String code = map.get("verificationCode").toString();

        String matchcode = redisTemplate.opsForValue().get(phone);
        log.info("验证码为 = {}", matchcode);

        if (matchcode != null && matchcode.equals(code)) {
            LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper<User>()
                    .eq(User::getPhone, phone);
            User u = this.getOne(lambdaQueryWrapper);
            if (u == null) {
                u = new User();
                u.setPhone(phone);
                u.setCreateTime(LocalDateTime.now());
                u.setUpdateTime(LocalDateTime.now());
                this.save(u);
            }

            redisTemplate.delete(phone);
            return u;
        }

        return null;
    }

    @Override
    public boolean sendMsg(User user) {
        String phone = user.getPhone();

        if (StringUtils.isNotEmpty(phone)) {
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code = {}", code);

            //调用短信服务API(略)

            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return true;
        }

        return false;
    }

    @Override
    public Page page(int page, int pageSize, String name) {
        //构造分页构造器
        Page pageInfo = new Page(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .like(StringUtils.isNotEmpty(name), User::getUsername, name)
                .orderByDesc(User::getUpdateTime);

        //执行查询
        return this.page(pageInfo, lambdaQueryWrapper);
    }

    @Override
    public User getUserById(long id) {
        return this.getById(id);
    }

    @Override
    public void updateUserById(User user) {
        user.setUpdateTime(LocalDateTime.now());
        this.updateById(user);
    }
}
