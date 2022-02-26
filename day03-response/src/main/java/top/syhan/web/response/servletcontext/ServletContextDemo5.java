package top.syhan.web.response.servletcontext; /**
 * @program: java-web-learning
 * @description: ServletContext功能 ：获取文件的真实(服务器)路径
 * @author: SYH
 * @create: 2022-02-26 18:11
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过HttpServlet获取
        ServletContext context = this.getServletContext();
        // 获取文件的服务器路径
        //web目录下资源访问
        String b = context.getRealPath("/b.txt");
        System.out.println(b);
        // File file = new File(realPath);
        //WEB-INF目录下的资源访问
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        //src目录下的资源访问
        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

