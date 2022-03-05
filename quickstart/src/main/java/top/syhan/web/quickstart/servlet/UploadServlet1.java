package top.syhan.web.quickstart.servlet; /**
 * @program: java-web-learning
 * @description: 处理axios通过formData提交的多⽂件上传请求，同时formData⾥还有其他参数
 * @author: SYH
 * @create: 2022-03-03 14:36
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@MultipartConfig
@WebServlet(urlPatterns = "/upload1")
public class UploadServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取提交数据中的account
        String account = request.getParameter("account");
        System.out.println(account);
        Part part = request.getPart("file");
        // 原⽂件名
        System.out.println(part.getSubmittedFileName());
        String fileName = "";
        if (part.getContentType() != null) {
            // 给⽂件改名
            fileName = UUID.randomUUID() +
                    part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
            // 获取项⽬部署的绝对路径
            ServletContext context = this.getServletContext();
            // ⽂件上传最终的⽬录/⽂件名
            String realPath = context.getRealPath("upload/" + fileName);
            // 上传
            part.write(realPath);
        }
        // 把上传图⽚的相对路径返回给客户端
        PrintWriter out = response.getWriter();
        out.write("./upload/" + fileName);
        out.flush();
        out.close();
    }
}
