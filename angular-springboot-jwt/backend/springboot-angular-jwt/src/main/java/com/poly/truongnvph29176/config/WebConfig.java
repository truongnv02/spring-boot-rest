package com.poly.truongnvph29176.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") //TODO Áp dụng cấu hình cho tất cả các endpoint
                        .allowedOrigins("http://localhost:4200") //TODO Tên miền ứng dụng
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // TODO cho phép tất cả các phương thức
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
