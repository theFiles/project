package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 编码过滤
 */
public class CharSet implements Filter {
    private String code;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("code");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding(code);
        servletResponse.setCharacterEncoding(code);
        servletResponse.setContentType("text/html;charset="+code);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
