package com.reactivate.trading.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all paths
        registry.addMapping("/**")  // Allow all paths
                .allowedOrigins("http://172.30.1.168:4200")  // Angular frontend origin
                .allowedMethods("GET", "POST", "PUT", "PATCH","DELETE")  // Allowed HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow cookies if needed
    }
}
