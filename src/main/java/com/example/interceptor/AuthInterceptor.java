package com.example.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


/**
 * Created with IntelliJ IDEA.
 * @author ranmenglong
 * @date 2020/09/09 13:42
 * @Description: 处理token拦截器
 *
 */

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter implements EnvironmentAware {

    private Environment environment;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        Enumeration<String> parameterNames = request.getParameterNames();

        String property = environment.getProperty("server.port");
        System.out.println("拦截器：{}"+property);
        return true;

    }


    private void returnJson(HttpServletResponse response, String result) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(result);
        } catch (IOException e) {
            log.error("returnJson e",e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


}
