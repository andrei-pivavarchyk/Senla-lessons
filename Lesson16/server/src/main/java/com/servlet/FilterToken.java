package com.servlet;


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

        //   Integer id = parseInt(request.getParameter("id"));
        //  PrintWriter pw = response.getWriter();

        HttpServletRequest request1 = (HttpServletRequest) request;
        String str = request1.getHeader("token");
        if (str != null) {
            chain.doFilter(request, response);
        }

               /* System.out.println("doFilter is execute");
                // Мы не можем вызвать response.sendRedirect("login.jsp") так как нам нужен httpResponse, а не ServletResponse.
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("login.jsp");
                //chain.doFilter(request, response);  // вызываем следующий фильтр. В этом примере нам это не понадобится.
       */
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}