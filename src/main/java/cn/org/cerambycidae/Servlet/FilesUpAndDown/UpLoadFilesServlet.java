package cn.org.cerambycidae.Servlet.FilesUpAndDown;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UploadFiles")
@MultipartConfig
public class UpLoadFilesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 说明输入的请求信息采用UTF-8编码方式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // Servlet3.0中引用的新方法，用来处理multipart/form-data类型编码表单
        Part part = req.getPart("file");
        // 获取HTTP头信息
        String headerInfo = part.getHeader("content-disposition");
        // 从HTTP头信息中获取文件名
        String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
        // 获得存储上传文件的文件路径
        // String fileSavingFolder =
        // this.getServletContext().getRealPath("/UploadFiles");
        String fileSavingFolder = getServletContext().getRealPath("/UpAndDown/download/");//文件绝对路径
//        String fileSavingFolder = "D:\\temp";
        // 获得存储上传文件的完整路径
        // 文件夹位置固定
        String fileSavingPath = fileSavingFolder + File.separator + fileName;
        // 如果文件夹不存在，则创建文件夹
        File file = new File(fileSavingFolder + File.separator);
        if (!file.exists()) {
            file.mkdir();
        }
        part.write(fileSavingPath);
        PrintWriter out = resp.getWriter();
        out.println("上传成功！");
    }
}
