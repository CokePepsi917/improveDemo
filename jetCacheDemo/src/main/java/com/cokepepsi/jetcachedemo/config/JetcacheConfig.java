package com.cokepepsi.jetcachedemo.config;

import com.alicp.jetcache.CacheManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author CokePepsi
 * @date 2023/9/20 10:53
 */
@Configuration
public class JetcacheConfig {
    @Resource
    private CacheManager cacheManager;
}
