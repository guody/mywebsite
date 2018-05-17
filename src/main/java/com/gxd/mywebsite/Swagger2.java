/**
 * FileName: Swagger2
 * Author:   guody
 * Date:     2018/5/7 18:12
 * Description: swagger配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gxd.mywebsite;

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
 * 〈swagger配置类〉
 *
 * @author guody
 * @create 2018/5/7
 * @since 1.0.0
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gxd.mywebsite.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("个人website APIs")
                .description("Spring Boot中使用Swagger2构建RESTful APIs")
                .termsOfServiceUrl("")
                .contact("Guo Xiaodi")
                .version("1.0")
                .build();
    }

}