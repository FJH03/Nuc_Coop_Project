package nuc.edu.aop;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import nuc.edu.service.OperateLogService;
import nuc.edu.service.SessionService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import nuc.edu.pojo.OperateLog;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

import static nuc.edu.service.impl.SessionServiceImpl.ADMIN_SESSION;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: LogAspect
 * @Date: 2024/2/27
 * @Time: 14:53
 * @Description:添加自定义描述
 */
@Component
@Aspect
public class LogAspect {
    @Autowired
    OperateLogService operateLogService;
    @Autowired
    SessionService sessionService;

    @Around("@annotation(nuc.edu.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object adminid = sessionService.getSession(ADMIN_SESSION, "admin");

        String className = joinPoint.getTarget().getClass().getName();

        String methonName = joinPoint.getSignature().getName();

        Object args[] = joinPoint.getArgs();
        String methodParms = Arrays.toString(args);

        Long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        String returnValue = JSON.toJSONString(result);
        Long end = System.currentTimeMillis();

        Long costTime = end - begin;

        LocalDateTime now = LocalDateTime.now();

        OperateLog operateLog = new OperateLog( null,  adminid, now, className, methonName, methodParms, returnValue, costTime);

        operateLogService.save(operateLog);
        return result;
    }
}
