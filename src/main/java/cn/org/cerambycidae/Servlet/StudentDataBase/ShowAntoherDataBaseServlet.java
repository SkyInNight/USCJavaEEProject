package cn.org.cerambycidae.Servlet.StudentDataBase;

import cn.org.cerambycidae.pojo.StudentInfo;
import cn.org.cerambycidae.pojo.StudentInfoExample;
import cn.org.cerambycidae.service.Impl.StudentInfoServiceImpl;
import cn.org.cerambycidae.service.StudentInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/DataBaseStudent/ShowStudentDataBase"})
public class ShowAntoherDataBaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        //数据处理，数据库连接方面，用来响应消息
        StudentInfoService studentInfoService=new StudentInfoServiceImpl();
        StudentInfoExample studentInfo = new StudentInfoExample();
        StudentInfoExample.Criteria criteria = studentInfo.createCriteria();
        criteria.andNameLike("%%");
        List<StudentInfo> students = studentInfoService.selectByExample(studentInfo);
        request.getSession().setAttribute("students",students);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
