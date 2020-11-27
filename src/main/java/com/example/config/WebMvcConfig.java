package com.example.config;

import com.example.interceptor.AuthInterceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/6 16:00
 * @version:1.0
 */
@Configuration
@SpringBootApplication
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
public class WebMvcConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    /**
     * 放行swagger
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(AuthorityInterceptor());
    }


    @Bean
    public AuthInterceptor AuthorityInterceptor() {
        return new AuthInterceptor();
    }
}
