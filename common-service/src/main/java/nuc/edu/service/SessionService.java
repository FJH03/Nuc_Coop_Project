package nuc.edu.service;

import java.util.Map;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: SessionService
 * @Date: 2024/2/28
 * @Time: 11:16
 * @Description:添加自定义描述
 */
public interface SessionService {
    void createOrUpdateSession(String tag, Map<String, String> sessionData);
    String getSession(String tag, String sessionId);
    void removeSession(String tag, String sessionId);
}
