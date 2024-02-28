package nuc.edu.service.impl;

import nuc.edu.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: SessionServiceImpl
 * @Date: 2024/2/28
 * @Time: 11:15
 * @Description:添加自定义描述
 */
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    StringRedisTemplate redisTemplate;

    public static final String ADMIN_SESSION = "ADMIN_SESSION";

    // 创建或更新会话信息
    public void createOrUpdateSession(String tag, Map<String, String> sessionData) {
        sessionData.forEach((k, v) -> {
            redisTemplate.opsForValue().set(tag + "_" + k, v, 30, TimeUnit.MINUTES);
        });
    }

    // 获取会话信息
    public String getSession(String tag, String sessionId) {
        return redisTemplate.opsForValue().get(tag + "_" + sessionId);
    }

    @Override
    public void removeSession(String tag, String sessionId) {
        redisTemplate.delete(tag + "_" + sessionId);
    }
}