package com.file;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ReadFile")
public class ReadFile extends HttpServlet{
    private static final long serialVersionUID = 1L;
    //构造函数
    public ReadFile(){
        super();
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //TODO Auto-generated method stub
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //设置页面的文档类型和字符集，页面中的字符所采用的字符集
        response.setContentType("text/html;charset=UTF-8");
        //设置页面的编码方式，即以什么样的编码方式来保存页面文件
        response.setCharacterEncoding("UTF-8");
        //从response中获得PrintWriter类的对象，以用于向页面输出信息
        PrintWriter out = response.getWriter();
        //向页面输出信息
        out.println("<!DOCTYPE HTML PUBLIC\"-//W3C//DTD HTML 4.01Transitional//EN\">");
        out.println("<HTML>");
        out.println("       <HEAD><meta charset=\"UTF-8\"><TITLE>A Servlet</TITLE></HEAD>");
        out.println("   <BODY>");
        out.println("   <XMP>");
        String fileName = "/DataBase/index.jsp";//文件相对路径
        String filePath = this.getServletContext().getRealPath(fileName);//文件绝对路径
        out.println("要读取的文件：" + filePath);
        out.println("内容如下：");
        //使用绝对路径打开文件
        File file = new File(filePath);
        if(file.exists())
        {
            //使用打开的文件对象，创建FileReader类的实例
            FileReader reader = new FileReader(file);
            //使用打开文件对应的reader对象，创建BufferedReader类的实例
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            //逐行读取文件并输出到页面上
            while((line = bufferedReader.readLine())!=null)
            {
                out.println(line);
            }
            bufferedReader.close();
        }
        else {
            out.println("未找到文件！");
        }
        out.println("   </XMP>");
        out.println("   </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
