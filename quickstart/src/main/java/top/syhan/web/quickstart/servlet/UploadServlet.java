package top.syhan.web.quickstart.servlet; /**
 * @program: java-web-learning
 * @description: ${description}
 * @author: SYH
 * @create: 2022-03-02 22:35
 **/

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@MultipartConfig
@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        //获取提交数据中的account
        String account = request.getParameter("account");
        System.out.println(account);

        Part part = request.getPart("file");
        // 原文件名
        System.out.println(part.getSubmittedFileName());

        String fileName = "";

        if (part.getContentType() != null) {
            // 给文件改名
            fileName = UUID.randomUUID() + part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
            // 获取项目部署的绝对路径
            ServletContext context = this.getServletContext();
            // 文件上传最终的目录/文件名
            String realPath = context.getRealPath("upload/" + fileName);
            // 上传
            part.write(realPath);
        }

        // 把上传图片的相对路径返回给客户端
        PrintWriter out = response.getWriter();
        out.write("./upload/" + fileName);
        out.flush();
        out.close();
    }
}
