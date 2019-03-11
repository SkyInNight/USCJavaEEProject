package cn.org.cerambycidae.Servlet.HelloWorld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

//Servlet访问路径和初始化页面参数
@WebServlet(
        urlPatterns = {""},
        initParams = {@WebInitParam(name = "language", value = "english")}
)
public class HelloWorldServlet extends HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //配置上下文字符格式，防止中文乱码
        response.setContentType("text/html; charset=UTF-8");
        //获取输出流对象
        PrintWriter out = response.getWriter();
        //获取初始化对象参数
        String language = this.getInitParameter("language");
        if (language != null) {
            if (language.equals("chinese")) {
                out.println("你好世界。MyFirstServlet" + "<br>");
            } else {
                out.println("Hello World! MyFirstServlet" + "<br>");
            }
        } else {
            out.println("RunTime Error!!" + "<br>");
        }
        out.println(request.getMethod());
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
