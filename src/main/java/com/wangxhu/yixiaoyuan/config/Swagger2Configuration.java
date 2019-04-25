package com.wangxhu.yixiaoyuan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: StormWangxhu
 * @Time: 2019-01-29 20:38
 * @Email: StormWangxhu@163.com
 * @Description: 文档框架配置类
 *
 * 有了这个配置后，省去大量写接口的麻烦，在本地的时候只需要访问：
 * http://localhost:8091/swagger-ui.html 便可以访问api文档
 *
 */



@EnableSwagger2  //表示开启swagger2
@Configuration
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(myApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wangxhu.yixiaoyuan.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo myApiInfo() {

        return new ApiInfoBuilder()
                .title("易校 接口文档")
                .version("v1.0")
                .build();

    }
}
