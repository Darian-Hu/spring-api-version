package com.spring.api.version;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * 配置api版本
 */
public class ApiVersionAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ApiVersionWebMvcRegistrations apiVersionWebMvcRegistrations() {
        return new ApiVersionWebMvcRegistrations();
    }
}
