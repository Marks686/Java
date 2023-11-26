package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-11-18
 * Time: 19:56
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/editor/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/reg.html")
                .excludePathPatterns("/blog_list.html")
                .excludePathPatterns("/blog_content.html")
                .excludePathPatterns("/art/detail")
                .excludePathPatterns("/user/getuserbyid")
                .excludePathPatterns("/art/listbypage")
                .excludePathPatterns("/art/incr-rcount")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/reg");
    }
}
