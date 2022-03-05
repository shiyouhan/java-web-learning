package top.syhan.cookie.session; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-02-28 13:57
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取Session对象
        HttpSession session = request.getSession();
        // 打印session
        log.info(String.valueOf(session));
        // 2. 存储数据
        session.setAttribute("username", "zhangsan");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
