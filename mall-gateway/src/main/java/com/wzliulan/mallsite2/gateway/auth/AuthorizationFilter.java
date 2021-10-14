package com.wzliulan.mallsite2.gateway.auth;

import com.wzliulan.mallsite2.gateway.auth.service.AuthService;
import com.wzliulan.mallsite2.gateway.config.FilterOrderConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 鉴权过滤器
 */
@Slf4j
@Component
public class AuthorizationFilter implements GlobalFilter, Ordered {
    @Autowired
    private AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("鉴权过滤器：执行【鉴权】拦截，拦截的路径：{}", request.getPath());
        //authService.isValid("tk");

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        /**
         * 鉴权拦截器必须是第二个被执行的自定义拦截器，它将为系统提供基于RBAC模型的安全管理服务
         */
        return FilterOrderConfig.SECONDARY_FILTER;
    }
}
