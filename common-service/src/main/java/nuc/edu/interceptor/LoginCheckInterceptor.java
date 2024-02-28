package nuc.edu.interceptor;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.common.R;
import nuc.edu.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

import static nuc.edu.service.impl.SessionServiceImpl.ADMIN_SESSION;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: LoginInterceptor
 * @Date: 2024/2/28
 * @Time: 8:50
 * @Description:添加自定义描述
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws IOException {
        String url = req.getRequestURI();
        log.info("请求的URL:{}", url);

        Object admin = sessionService.getSession(ADMIN_SESSION,"admin");
        req.getSession().setAttribute("admin", admin);

        if (admin == null) {
            log.info("请求头为空，返回未登录");
            R<String> error = R.error("NOTLOGIN");
            String notlogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notlogin);
            return false;
        } else {
            log.info("请求登录的管理员ID = {}", admin);
            return true;
        }
    }
}
