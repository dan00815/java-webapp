package com.event.cia103g1springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.event.cia103g1springboot.config.LoginInterceptor;

@Configuration
public class Webconfig implements WebMvcConfigurer {
	
   	@Autowired
	LoginInterceptor loginInterceptor;

    //靜態資源路徑~~
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
    //靜態網頁路徑 可配轉場...等 要從modelattribute取資料的不能放這
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/event/addpage").setViewName("back-end/evt/evtaddpage");
        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/listpage").setViewName("front-end/listpage");
        registry.addViewController("/attend").setViewName("front-end/attendpage");
        registry.addViewController("/sucessandfail").setViewName("back-end/evt/sucessandfail");
//        registry.addViewController("/sucessattend").setViewName("back-end/attendsucess");
        registry.addViewController("/planroom/add").setViewName("plan/planroom/addpage");
        registry.addViewController("/ezpay").setViewName("/back-end/ezpay");
//        registry.addViewController("/product/productlist").setViewName("front-end/product/productlist");
        registry.addViewController("/emp/login").setViewName("emp/login");
        // 將 /emp/register 路徑對應到 emp/register 視圖
        registry.addViewController("/emp/register").setViewName("emp/register");
        // 將 /emp/reset-password 路徑對應到 emp/reset_password 視圖
        registry.addViewController("/emp/reset-password").setViewName("emp/reset_password");
        // 將 /emp/list 路徑對應到 emp/list 視圖
        registry.addViewController("/emp/list").setViewName("emp/list");
    }
    
}
