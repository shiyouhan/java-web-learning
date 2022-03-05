package top.syhan.cookie.session; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-02-28 11:32
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@WebServlet("/servletC")
public class ServletC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value= "你好";
        value = URLEncoder.encode(value, StandardCharsets.UTF_8);
        log.info(value);
        request.getRequestDispatcher("/servletD").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
