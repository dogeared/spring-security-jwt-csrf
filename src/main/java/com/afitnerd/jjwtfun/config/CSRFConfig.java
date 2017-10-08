package com.afitnerd.jjwtfun.config;

import com.afitnerd.jjwtfun.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class CSRFConfig {

    @Autowired
    SecretService secretService;

    @Bean
    @ConditionalOnMissingBean
    public CsrfTokenRepository jwtCsrfTokenRepository() {
        return new JWTCSRFTokenRepository(secretService.getHS256SecretBytes());
    }
}
