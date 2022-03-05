package top.syhan.web.exercise.web; /**
 * @program: java-web-learning
 * @description: 接收json参数，新建brand
 * @author: SYH
 * @create: 2022-03-03 15:42
 **/

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import top.syhan.web.exercise.entity.Brand;
import top.syhan.web.exercise.service.BrandService;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/newBrand")
public class NewBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 如果用 request.getParameter 是错的，不能接收json的数据
        // String brandName = request.getParameter("brandName");
        //System.out.println(brandName);

        // 1. 用缓冲字符输入流来获取请求体数据
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        // 2. 将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(json.toString(), Brand.class);
        // 3. 调用service 添加
        brandService.add(brand);
        // 4. 响应成功
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
