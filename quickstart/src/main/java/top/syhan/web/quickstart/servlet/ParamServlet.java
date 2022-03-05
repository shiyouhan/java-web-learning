package top.syhan.web.quickstart.servlet; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-03-03 12:38
 **/

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/param")
public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得参数部分字符串
        String str = req.getQueryString();
        //按 & 分割成若⼲组
        String[] params = str.split("&");
        Map<String, String> map = new HashMap<>(4);
        for (String s : params) {
            //每组按 = 分割，得到参数名和参数值
            String[] split = s.split("=");
            //如果参数值包含编码后的中⽂，需要解码
            if (split[1].contains("%")) {
                //URLDecoder解码
                split[1] = URLDecoder.decode(split[1],
                        StandardCharsets.UTF_8);
            }
            //这⼀组参数的键值对存⼊map
            map.put(split[0], split[1]);
        }
        //将结果以JSON格式回显给客户端
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(map));
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
