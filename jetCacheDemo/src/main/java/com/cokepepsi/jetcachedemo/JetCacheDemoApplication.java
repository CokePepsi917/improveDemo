package com.cokepepsi.jetcachedemo;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = {"com.cokepepsi.jetcachedemo"})
public class JetCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetCacheDemoApplication.class, args);
    }

}
