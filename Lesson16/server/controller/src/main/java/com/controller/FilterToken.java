package com.controller;

import com.service.api.ITokenHandler;
import com.service.api.IUserHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        ITokenHandler tokenHandler = WebApplicationContextUtils.
                getRequiredWebApplicationContext(filterConfig.getServletContext()).
                getBean( ITokenHandler.class);
        IUserHandler userHandler=WebApplicationContextUtils.
                getRequiredWebApplicationContext(filterConfig.getServletContext()).
                getBean( IUserHandler.class);
        Long id = tokenHandler.getUserIdByToken(token);
        if (id != null) {
            try {
                userHandler.setUserId(id);
                chain.doFilter(request, response);
            } catch (Exception e) {
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