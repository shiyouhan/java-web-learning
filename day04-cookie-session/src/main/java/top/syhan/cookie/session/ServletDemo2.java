package top.syhan.cookie.session; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-02-28 14:00
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取session对象
        HttpSession session = request.getSession();
        log.info(String.valueOf(session));
        // 2. 获取数据
        String username = (String) session.getAttribute("username");
        log.info(username);
        // 3. 销毁session
        session.invalidate();
        log.info((String) session.getAttribute("username"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
