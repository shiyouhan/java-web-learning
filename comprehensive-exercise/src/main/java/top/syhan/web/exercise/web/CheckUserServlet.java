package top.syhan.web.exercise.web; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-03-04 10:27
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import top.syhan.web.exercise.entity.User;
import top.syhan.web.exercise.service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/check")
public class CheckUserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        User user = User.builder().username(username).build();
        boolean flag = UserService.register(user);
        response.getWriter().write(String.valueOf(flag));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
