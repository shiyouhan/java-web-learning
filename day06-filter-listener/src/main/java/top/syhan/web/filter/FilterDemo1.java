package top.syhan.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description:
 * @author: SYH
 * @create: 2022-03-04 08:32
 **/
@WebFilter(urlPatterns = "/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("11111");
        //System.out.println("过滤器1被执行。。。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("33333");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1销毁");
    }
}
