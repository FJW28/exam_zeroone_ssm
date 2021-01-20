package com.tledu.cn.filter;

import com.tledu.cn.pojo.User;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter( "/main/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将父接口转为子接口
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            chain.doFilter(req, resp);
        }else if (user==null){
            response.sendRedirect("/07-Blog/login2.html");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
