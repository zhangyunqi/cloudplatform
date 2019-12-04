package com.zyq.cloudplatform.sso.authserver.configuration.filter;

import org.springframework.util.Assert;
import org.springframework.web.cors.*;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域
 * 这是一个替代Spring MVC Java配置和XML命名空间CORS配置，
 * 适用于仅依赖spring-web(而非spring-webmvc)或for的应用程序
 * 需要在{@link javax.servlet.Filter}上执行CORS检查的安全约束
 * 水平。
 * @author zhangyunqi
 * @date 2019/12/04
 */
public class CorsFilter extends OncePerRequestFilter {
    private final CorsConfigurationSource configSource;

    private CorsProcessor processor = new DefaultCorsProcessor();


    /**
     * Constructor accepting a {@link CorsConfigurationSource} used by the filter
     * to find the {@link CorsConfiguration} to use for each incoming request.
     * @see UrlBasedCorsConfigurationSource
     */
    public CorsFilter(CorsConfigurationSource configSource) {
        Assert.notNull(configSource, "CorsConfigurationSource must not be null");
        this.configSource = configSource;
    }


    /**
     * Configure a custom {@link CorsProcessor} to use to apply the matched
     * {@link CorsConfiguration} for a request.
     * <p>By default {@link DefaultCorsProcessor} is used.
     */
    public void setCorsProcessor(CorsProcessor processor) {
        Assert.notNull(processor, "CorsProcessor must not be null");
        this.processor = processor;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (CorsUtils.isCorsRequest(request)) {
            CorsConfiguration corsConfiguration = this.configSource.getCorsConfiguration(request);
            if (corsConfiguration != null) {
                boolean isValid = this.processor.processRequest(corsConfiguration, request, response);
                if (!isValid || CorsUtils.isPreFlightRequest(request)) {
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
