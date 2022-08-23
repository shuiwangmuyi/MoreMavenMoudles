package com.moudel1.unit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @title: RestTemplateing
 * @Author Wy
 * @Date: 2022/8/22 14:30
 * @Version 1.0
 */
@Configuration
public class RestTemplateUnit {
    private int READ_TIME_OUT = 5000;
    private int CONNECT_TIME_OUT = 15000;

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(READ_TIME_OUT);
        factory.setReadTimeout(CONNECT_TIME_OUT);
        return factory ;
    }

}
