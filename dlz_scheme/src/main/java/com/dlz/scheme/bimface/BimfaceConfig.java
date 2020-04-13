package com.dlz.scheme.bimface;

import com.bimface.sdk.BimfaceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BimfaceConfig {

    @Value("${bimface.appKey}")
    private String appKey;

    @Value("${bimface.appSecret}")
    private String appSecret;

    @Bean
    public BimfaceClient bimfaceClient(){
        return new BimfaceClient(appKey,appSecret);
    }

}
