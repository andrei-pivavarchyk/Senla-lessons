package com.controller;


import com.model.Role;
import com.model.User;
import com.serviceAPI.ITokenHandler;
import com.serviceAPI.IUserHandler;
import com.serviceAPI.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterToken implements Filter {

    private FilterConfig filterConfig;
    private static Logger log = Logger.getLogger(FilterToken.class);
    @Autowired
    private IUserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;
        String token = req.getHeader("authorization");

        ITokenHandler tokenHandler = WebApplicationContextUtils.
                getRequiredWebApplicationContext(filterConfig.getServletContext()).
                getBean(ITokenHandler.class);

        IUserHandler userHandler = WebApplicationContextUtils.
                getRequiredWebApplicationContext(filterConfig.getServletContext()).
                getBean(IUserHandler.class);
        Long id = tokenHandler.getUserIdByToken(token);
        if (id != null) {
            try {
                User user = this.userService.getUserByID(id);
                if (user != null) {
                    Role role = this.userService.getRoleByUser(user);
                    userHandler.setUser(user);
                    userHandler.setRole(role);
                    chain.doFilter(request, response);
                }

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