package com.example.demo.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器实际上就是对web资源进行拦截，做一些处理后再交给下一个过滤器或servlet处理
 * 通常都是用来拦截request进行处理的，也可以对返回的response进行拦截处理
 *
 * @Author:王景阳
 * @DateTime:2022/4/15 16:23
 */

@Component
@Slf4j
public class WebFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("{} --> {}",request.getMethod(),request.getRequestURL().toString());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
