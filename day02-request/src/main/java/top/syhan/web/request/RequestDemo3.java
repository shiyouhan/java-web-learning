package top.syhan.web.request; /**
 * @program: java-web-learning
 * @description: Request对象获取请求头数据：user-agent
 * @author: SYH
 * @create: 2022-02-26 17:36
 **/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据:user-agent
        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            //谷歌
            System.out.println("谷歌浏览器...");
        } else if (agent.contains("Firefox")) {
            //火狐
            System.out.println("火狐浏览器...");
        }
    }
}

