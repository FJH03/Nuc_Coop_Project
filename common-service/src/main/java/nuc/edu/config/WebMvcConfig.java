package nuc.edu.config;

import lombok.extern.slf4j.Slf4j;
import nuc.edu.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: WebMvcConfig
 * @Date: 2023/12/5
 * @Time: 14:50
 * @Description:添加自定义描述
 */
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始进行静态资源映射...");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/plugins/");
        registry.addResourceHandler("/styles/**").addResourceLocations("classpath:/styles/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] path = new String[] {
                "/js/**",
                "/backend/page/login.html",
                "/images/**",
                "/backend/js/**",
                "/plugins/**",
                "/styles/**",
                "/front/page/login.html",
                "/front/js/**"
        };
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns(path);
    }
}
