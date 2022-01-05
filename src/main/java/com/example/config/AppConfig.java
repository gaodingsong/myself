package com.example.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:gaodingsong
 * @description:如果自己想去用java代码去配置tomcat的一些东西，例如端口，
 * @createTime:2021/12/30 11:04 上午
 * @version:1.0
 */
@Configuration
public class AppConfig {



    //springboot是如何注册web组件的（servlet）？

//    public ServletRegistrationBean servletRegistrationBean(){
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//        return servletRegistrationBean;
//    }
//
//    /**
//     * 方式1
//     * @return
//     */
//    @Bean
//    public TomcatServletWebServerFactory servletWebServerFactory(){
//        TomcatServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
//        servletWebServerFactory.setPort(80);
//        return servletWebServerFactory;
//    }

    /**
     * 方式2，自定义WebServerFactory配置对象,spring 推荐使用
     * @return
     */
//    @Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> webServerFactoryCustomizer(){
//        return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
//            @Override
//            public void customize(TomcatServletWebServerFactory factory) {
//                   factory.setPort(80);
//            }
//        };
//    }

}
