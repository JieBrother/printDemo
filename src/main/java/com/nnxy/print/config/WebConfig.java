package com.nnxy.print.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: LuoFuJie
 * @time: 2019/11/14 20:12
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     *
     * 添加静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/file/**").addResourceLocations("file:D:/printFile/");
    }



}
