package top.syhan.web.quickstart.servlet; /**
 * @program: java-web-learning
 * @description: 接收前端表单请求，向客户端返回JSON数据
 * @author: SYH
 * @create: 2022-03-02 20:46
 **/

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.syhan.web.quickstart.entity.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println(account + password);
        User user = new User("syhan@qq.com", "123");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        out.print(JSON.toJSONString(user));
        out.flush();
        out.close();
    }
}
