// src/main/java/com/dulain/config/WebConfig.java
package com.dulain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5176")   // match whatever port Vite picked
                .allowedMethods("GET","POST","PUT","DELETE");
    }
}
