package com.controller;


import com.model.UserData;
import com.service.TokenHandler;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterToken implements Filter {
    private FilterConfig filterConfig;

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
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            rs.setStatus(404);
        }

    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}