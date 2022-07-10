package com.mhjg.yose.comm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	/**
	 * Swagger 설정의 핵심이 되는 Bean
	 * 
	 * @return
	 */
    @Bean
    public Docket api() {    	
    	/* 
    	 * Swagger UI : http://localhost:8081/swagger-ui/index.html
    	 * 
    	 * useDefaultResponseMessages : Swagger에서 제공하는 기본 응답 코드
    	 * apis : API 스펙이 작성되어 있는 패키지
    	 * paths: apis에 포함되어 있는 API 중 특정 path 선택
    	 * apiInfo: Swagger UI로 노출할 정보
    	 */
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mhjg.yose"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Practice Swagger")
                .description("practice swagger config")
                .version("1.0")
                .build();
    }
}
