package top.syhan.web.exercise.web; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-02-28 18:54
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;
import top.syhan.web.exercise.entity.Brand;
import top.syhan.web.exercise.service.BrandService;

import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();
        //2. 存入request域中
        request.setAttribute("brands", brands);
        //3. 转发到brand.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
