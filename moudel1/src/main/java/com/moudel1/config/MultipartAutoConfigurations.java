//package com.moudel1.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
///**
// * @title: AllConfig
// * @Author Wy
// * @Date: 2022/8/22 13:42
// * @Version 1.0
// */
//@Configuration
//@ConfigurationProperties (prefix = "spring.servlet.multipart", ignoreUnknownFields = false)
//public class MultipartAutoConfigurations {
//    private long maxUploadSize;
//    private int maxInMemorySize;
//    /**
//     * 配置 StandardServletMultipartResolver 解析器
//     * 	没CommonsMultipartResolver才使用"spring.servlet.multipart"配置
//     * @return
//     */
//    @Bean //(name = "multipartResolver")
//    public MultipartResolver multipartResolver(){
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(this.maxUploadSize);
//        multipartResolver.setMaxInMemorySize(this.maxInMemorySize);
//        return  multipartResolver();
//    }
//
//
//}
