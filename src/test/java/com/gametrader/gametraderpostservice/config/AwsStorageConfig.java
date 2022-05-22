package com.gametrader.gametraderpostservice.config;

import com.amazonaws.services.s3.AmazonS3;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class AwsStorageConfig {
    @Bean
    @Primary
    public AmazonS3 s3Client() {
        return Mockito.mock(AmazonS3.class);
    }
}
