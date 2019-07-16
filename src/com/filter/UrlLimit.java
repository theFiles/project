package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UrlLimit implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        String uri = ((HttpServletRequest)servletRequest).getRequestURI();

        // 限定浏览规则
//        if(!"/index".equals(uri)){
            servletRequest.getRequestDispatcher("404.html").forward(servletRequest,servletResponse);
//            return;
//        }
//        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
