package com.gametrader.gametraderpostservice;
import com.gametrader.gametraderpostservice.config.AwsStorageConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = AwsStorageConfig.class)
public class GametraderPostServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
