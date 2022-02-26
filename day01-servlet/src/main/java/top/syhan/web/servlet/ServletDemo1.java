package top.syhan.web.servlet; /**
 * @program: java-web-learning
 * @description: Servlet快速入门——xml方式配置Servlet
 * @author: SYH
 * @create: 2022-02-26 16:37
 **/

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     *
     * @param servletRequest  请求对象
     * @param servletResponse 响应对象
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
