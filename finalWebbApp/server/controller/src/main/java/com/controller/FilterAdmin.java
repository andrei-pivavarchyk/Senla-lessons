package com.controller;


import com.model.Role;
import com.model.User;
import com.serviceAPI.ITokenHandler;
import com.serviceAPI.IUserHandler;
import com.serviceAPI.IUserService;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterAdmin implements Filter {

    private FilterConfig filterConfig;
    private static Logger log = Logger.getLogger(FilterToken.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        HttpServletResponse rs = (HttpServletResponse) response;

        IUserHandler userHandler = WebApplicationContextUtils.
                getRequiredWebApplicationContext(filterConfig.getServletContext()).
                getBean(IUserHandler.class);
        Role role = userHandler.getRole();

        if (role.equals(Role.ADMIN)) {

            try {
                chain.doFilter(request, response);
            } catch (Exception e) {
                log.error(e.toString());
            }
        } else {
            rs.setStatus(401);
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}