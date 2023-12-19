package com.cokepepsi.streamsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;

/**
 * 故障现象:未能重复消费
 * 导致原因: 配置的分组group是相同的, 是同一个组内, 不能重复消费
 *
 * 自定义配置分组
 * 自定义配置分为不同组, 解决未能重复消费的问题
 *
 */
@SpringBootApplication
public class StreamSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSourceApplication.class, args);
    }

}
