/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author agunga
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/axxx/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR, DispatcherType.INCLUDE})
public class UserFilter implements Filter {

    private FilterConfig filterConfig = null;

    public UserFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpSession session = hsr.getSession(false);//
        if ((session == null || session.isNew()) || session.getAttribute("user_a") == null) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("../admin/login");
        }
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpSession session = hsr.getSession(false);
        session.getAttribute("user_a");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        doBeforeProcessing(request, response);

        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException t) {
        }
        doAfterProcessing(request, response);
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }
 
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {

        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("UserFilter()");
        }
        StringBuilder sb = new StringBuilder("UserFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

}
