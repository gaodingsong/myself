package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/6 15:54
 * @version:1.0
 */
@Configuration //必须存在
@EnableSwagger2 //必须存在
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }
  /*  @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("学生管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaomin.controller"))
                .paths(PathSelectors.any())
                .build();
    }*/
    /**
     * name:开发者姓名
     * url:开发者网址
     * email:开发者邮箱
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("高丁松", "https://www.cnblogs.com/gdss/", "15515625521@163.com");
        return new ApiInfoBuilder()
                .title("高丁松测试API接口")//标题
                .description("API接口的描述")//文档接口的描述
                .contact(contact)
                .version("1.1.0")//版本号

                .build();
    }
}
