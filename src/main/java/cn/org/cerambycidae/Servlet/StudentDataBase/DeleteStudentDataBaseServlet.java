package cn.org.cerambycidae.Servlet.StudentDataBase;

import cn.org.cerambycidae.pojo.StudentInfo;
import cn.org.cerambycidae.pojo.StudentInfoExample;
import cn.org.cerambycidae.service.Impl.StudentInfoServiceImpl;
import cn.org.cerambycidae.service.StudentInfoService;
import cn.org.cerambycidae.util.FindStudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/DataBaseStudent/DeleteStudentDataBaseServlet"})
public class DeleteStudentDataBaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        //得到查询响应数据
        String id = request.getParameter("id");
        Integer integer = Integer.valueOf(id);
        StudentInfoExample studentExample = new StudentInfoExample();
        StudentInfoExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(integer);
        //数据处理，数据库连接方面，用来响应消息
        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        int retu = studentInfoService.deleteByExample(studentExample);
        StudentInfoExample studentExample2 = new StudentInfoExample();
        StudentInfoExample.Criteria criteria2 = studentExample2.createCriteria();
        criteria2.andNameLike("%%");
        List<StudentInfo> students = studentInfoService.selectByExample(studentExample2);
        request.getSession().setAttribute("students",students);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
