package com.controller;

import com.service.TokenHandler;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterToken implements Filter {

    private FilterConfig filterConfig;
    private static Logger log = Logger.getLogger(FilterToken.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        String token = req.getHeader("token");
        Long id = TokenHandler.getInstance().getUserIdByToken(token);
        if (id != null) {
            try {
                chain.doFilter(request, response);
            }
            catch(Exception e){
                log.error(e.toString());
            }
        }
            rs.setStatus(401);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}