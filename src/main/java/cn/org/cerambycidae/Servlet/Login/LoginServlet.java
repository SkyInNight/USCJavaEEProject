package cn.org.cerambycidae.Servlet.Login;

import cn.org.cerambycidae.pojo.UserInfo;
import cn.org.cerambycidae.service.Impl.StudentMybatisServiceImpl;
import cn.org.cerambycidae.service.Impl.UserInfoServiceImpl;
import cn.org.cerambycidae.service.StudentService;
import cn.org.cerambycidae.service.UserInfoService;
import cn.org.cerambycidae.util.AcceptJson;
import cn.org.cerambycidae.util.JsonUtil.ToJson;
import cn.org.cerambycidae.util.LoginUtil.LoginUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet( urlPatterns = "/Login/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        AcceptJson acceptJson = new AcceptJson();
        String json = acceptJson.acceptJSON(request);

        //将获取的json字符串转为对象
        JSONObject userJson = JSONObject.parseObject(json);
        UserInfo user = JSON.toJavaObject(userJson,UserInfo.class);

        //对获得的数据进行查询
        UserInfoService userInfoService = new UserInfoServiceImpl();
        List<UserInfo> userInfos = userInfoService.selectByExample(LoginUtil.Convert(user.getName(),user.getPassword()));

        //判断查询的数据是否符合要求
        String message;
        if (userInfos.size()>0){
            request.setAttribute("userInfo",userInfos.get(0));
            message = "success";
            pw.print(ToJson.Convert(message));
        }else{
            message = "false";
            String str = ToJson.Convert(message);
            pw.print(ToJson.Convert(message));
        }
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
