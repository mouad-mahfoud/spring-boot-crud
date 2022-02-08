package com.demo.app.ws.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedMethods("POST", "GET", "PUT", "DELETE")
            .allowedOrigins("http://localhost:4200")
            .allowedHeaders("*");
        ;
    }
}
