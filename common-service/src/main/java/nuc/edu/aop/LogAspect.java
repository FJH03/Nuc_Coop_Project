package nuc.edu.aop;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import nuc.edu.service.OperateLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import nuc.edu.pojo.OperateLog;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: LogAspect
 * @Date: 2024/2/27
 * @Time: 14:53
 * @Description:添加自定义描述
 */
public class LogAspect {
    @Autowired
    HttpServletRequest req;

    @Autowired
    OperateLogService operateLogService;

    @Around("@annotation(nuc.edu.anno.Log)")
    public Object reccordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Long adminid = (Long) req.getSession().getAttribute("admin");

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

        OperateLog operateLog = new OperateLog( null,  null , now, className, methonName, methodParms, returnValue, costTime);

        operateLog.setOperateUser(adminid);

        operateLogService.save(operateLog);
        return result;
    }
}
