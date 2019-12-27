package com.book.domain.utils;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "platform.*.controller" })
public class SpringfoxDocConfig {
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("platform.controller"))
                .paths(PathSelectors.any()).build()
                .genericModelSubstitutes(JsonResult.class)
                .useDefaultResponseMessages(false).enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("国内酒店产品系统接口文档").build();
    }
}
