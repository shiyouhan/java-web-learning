package top.syhan.web.quickstart.servlet; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-03-03 14:29
 **/

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login2")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过缓冲字符流按⾏读取JSON数据，拼接到可变⻓字符串
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=utf-8");
        //将字符串转换成JSON对象返回
        out.print(JSONObject.parseObject(json.toString()));
        out.flush();
        out.close();
    }
}
