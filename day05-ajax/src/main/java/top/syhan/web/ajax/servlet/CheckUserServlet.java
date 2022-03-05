package top.syhan.web.ajax.servlet; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-03-02 10:23
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import top.syhan.web.exercise.entity.User;
import top.syhan.web.exercise.service.UserService;

import java.io.IOException;

@WebServlet("/checkUserService")
public class CheckUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String username = request.getParameter("username");
        //User user = User.builder().username(username).build();
        //boolean flag = userService.register(user);
        //response.getWriter().write(String.valueOf(flag));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
