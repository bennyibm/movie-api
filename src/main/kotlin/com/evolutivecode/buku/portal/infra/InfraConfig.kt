package com.evolutivecode.buku.portal.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class InfraConfig{

    @Bean
    fun restTemplateBean(): RestTemplate {
        return RestTemplate()
    }
}