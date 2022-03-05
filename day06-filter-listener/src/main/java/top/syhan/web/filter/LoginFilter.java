package top.syhan.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @program: java-web-learning
 * @description:
 * @author: SYH
 * @create: 2022-03-04 09:19
 **/
@WebFilter(urlPatterns = "/page/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 登录状态校验码逻辑代码
        // 0. 将ServletRequest对象强制转换为HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 1. 将ServletRequest对象强制转化为HttpServletRequest对象
        // 1.1 在数组中存储和注册相关的资源路径
        String[] urls = {"/login.jsp", "/img", "/css/", "/js", "/loginServlet", "/register", "/registerServlet", "/verifyCodeServlet"};
        // 1.2 获取当前访问的资源路径
        String url = request.getRequestURL().toString();
        // 1.3 遍历数组，获取到每一个需要放行的资源路径
        for (String u : urls) {
            // 1.4 判断当前访问的资源路径，是否包含要放行的资源路径
            // 比如当前访问的资源路径是 /page/login.jsp, 而字符串 /page/login.jsp 包含了字符串 /login.jsp,所以这个字符串需要放行
            if (url.contains(u)) {
                //找到了，放行
                filterChain.doFilter(request, servletResponse);
                return;
            }
        }

        // 2. 取出session,并取出user
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        String msg = "";
        // 3. 判断user是否为null\
        if (user != null) {
            // 登录过了，放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else  {
            // 没有登录，直接跳转到登录页面
            msg = "没有登录";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
