package com.file;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/WriterFile")
public class WriteFile extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public WriteFile(){
        super();
        //TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //TODO Auto-generated method stub
        this.doPost(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        //设置页面的文档类型和字符集，页面中的字符所采用的字符集
        response.setContentType("text/html;charset=UTF-8");
        //设置页面的编码方式，即以什么样的编码方式来保存页面文件
        response.setCharacterEncoding("UTF-8");
        //从response中获得PrintWriter类的对象，以用于向页面输出信息
        PrintWriter out = response.getWriter();
        String fileName = "temp.txt";//文件相对路径
        String filePath = this.getServletContext().getRealPath(fileName);//文件绝对路径
        //使用文件的绝对路径打开文件，如果文件不存在则创建文件
        File file = new File(filePath);
        //使用打开的文件对象，创建FileWriter类的实例
        FileWriter writer = new FileWriter(file);
        //使用打开的文件对象，创建BufferedWriter类的实例
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        //通过BufferedWriter类的实例，向文件中写入信息
        bufferedWriter.write("J2EE课程");
        bufferedWriter.newLine();
        bufferedWriter.write("Servlet写文件");
        //刷新缓存，将缓存中的内容写入到文件中
        bufferedWriter.flush();
        bufferedWriter.close();
        writer.close();
        out.print("<font-size='2'>文件写入完毕，路径："+file.getAbsolutePath()+"</font>");
    }
}
