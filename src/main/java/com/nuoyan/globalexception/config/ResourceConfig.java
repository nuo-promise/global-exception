package com.nuoyan.globalexception.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring.mvc.throw-exception-if-no-handler-found=true
 * spring.resources.add-mappings=false
 * 1. 发现404 直接抛出
 * 2. 关闭默认的静态资源路径映射
 * 这样 会 导致静态资源访问 有问题
 * 使用如下配置 可以修护静态资源
 */
@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
