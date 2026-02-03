package com.dantruong.my_mp3;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Cấu hình để đường dẫn /uploads/** sẽ trỏ vào thư mục musicFile dưới máy
        registry.addResourceHandler("/musicFile/**")
                .addResourceLocations("file:musicFile/");
    }
}
