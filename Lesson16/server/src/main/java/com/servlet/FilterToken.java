package com.servlet;
/*

import com.service.TokenHandler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.Integer.parseInt;

public class FilterToken implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        Boolean tokenValid = TokenHandler.getInstance().checkToken(token);
        if (tokenValid) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse rs = (HttpServletResponse) response;
            rs.getWriter().write("filter bad");
          //  rs.sendError(404);
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}*/