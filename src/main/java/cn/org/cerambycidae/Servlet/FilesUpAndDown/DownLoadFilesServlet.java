package cn.org.cerambycidae.Servlet.FilesUpAndDown;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/UpAndDown/DownloadFiles")
public class DownLoadFilesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("name");
        // 防止读取name名乱码
        filename = new String(filename.getBytes("iso-8859-1"), "utf-8");
        // 设置文件MIME类型
        // resp.setContentType(getServletContext().getMimeType(filename));
        response.addHeader("Content-Type", "application/octet-stream");
        // 设置Content-Disposition
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        // 获取要下载的文件绝对路径
        String fullFileName = getServletContext().getRealPath("/UpAndDown/download/" + filename);
        // 输入流为项目文件，输出流指向浏览器
        InputStream is = new FileInputStream(fullFileName);
        ServletOutputStream os = response.getOutputStream();

        /*
         * 设置缓冲区 is.read(b)当文件读完时返回-1
         */
        int len = -1;
        byte[] b = new byte[1024];
        while ((len = is.read(b)) != -1) {
            os.write(b, 0, len);
        }
        // 关闭流
        is.close();
        os.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}
