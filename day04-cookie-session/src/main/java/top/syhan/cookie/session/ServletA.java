package top.syhan.cookie.session; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-02-28 10:58
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送cookie
        //1. 创建Cookie对象
        Cookie cookie = new Cookie("username", "zhangsan");
        //2. 通过response发送cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
