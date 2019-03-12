package cn.org.cerambycidae.Servlet.DataBase;

import cn.org.cerambycidae.pojo.Student;
import cn.org.cerambycidae.service.Impl.StudentMybatisServiceImpl;
import cn.org.cerambycidae.service.StudentService;
import cn.org.cerambycidae.util.DataBaseUtil.NameAndAgeRequest;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

@WebServlet(urlPatterns = {"/DataBase/ShowDataBaseServlet"})
public class ShowDataBaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();

        //得到查询响应数据
        String name = request.getParameter("name");
        name = URLDecoder.decode(name,"UTF-8");
        String age = request.getParameter("age");

        //数据处理，数据库连接方面，用来响应消息
        StudentService service=new StudentMybatisServiceImpl();
        List<Student> students = service.selectByExample(NameAndAgeRequest.Conversion(name,age));

        //分页查找商品销售记录，需判断是否有带查询条件

        //将商品销售记录转换成json字符串
        String listJson = JSONObject.toJSONString(students);
        //得到总记录数
        int total = students.size();

        //需要返回的数据有总记录数和行数据
        String json = "{\"total\":" + total + ",\"rows\":" + listJson + "}";
        pw.print(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
