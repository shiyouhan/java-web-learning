package top.syhan.web.servlet; /**
* @program: java-web-learning
*
* @description: Servlet快速入门——注解方式配置Servlet
* 
* @author: SYH
*
* @create: 2022-02-26 16:35
**/
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/demo")
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet学习.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
