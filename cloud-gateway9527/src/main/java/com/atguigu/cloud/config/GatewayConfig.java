package com.atguigu.cloud.config;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.config.HttpClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;

/**
 * @author yexingchen
 * @create 2024-05-22 21:41
 */

@Configuration
public class GatewayConfig {

    @Bean
    public HttpClientCustomizer httpClientResolverCustomizer() {
        return new HttpClientCustomizer() {
            @Override
            public HttpClient customize(HttpClient httpClient) {
                return httpClient.resolver(DefaultAddressResolverGroup.INSTANCE);
            }
        };
    }
}

