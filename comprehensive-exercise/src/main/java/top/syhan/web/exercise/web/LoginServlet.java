package top.syhan.web.exercise.web; /**
 * @program: java-web-learning
 * @description:  登录逻辑处理
 * @author: SYH
 * @create: 2022-02-28 16:35
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import top.syhan.web.exercise.entity.User;
import top.syhan.web.exercise.service.UserService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 是否勾选了"记住我"
        String remember = request.getParameter("remember");
        System.out.println(remember + "==================");

        // 2. 调用service登录
        User user = UserService.login(username, password);

        // 3. 判断
        if (user != null) {
            // 非空，登录成功
            // 是否勾选了记住我
            if ("on".equals(remember)) {
                System.out.println("需要记录Cookie");
                // 1. 创建Cookie对象
                Cookie cUserName = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);
                // 2. 设置存活时间
                cUserName.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);
                // 3. 发送
                response.addCookie(cUserName);
                response.addCookie(cPassword);
            }
            // 将用户信息记在session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            System.out.println(contextPath);
            response.sendRedirect(contextPath + "/index");

        } else {
            // 登陆失败，记录信息
            request.setAttribute("msg", "用户名或密码错误");
            // 转发
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
}
