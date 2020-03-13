package cn.org.cerambycidae.Servlet.Random;

import cn.org.cerambycidae.MongoDB.Connection;
import cn.org.cerambycidae.bean.CSDNInfo;
import cn.org.cerambycidae.bean.RandomInfo;
import com.alibaba.fastjson.JSON;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.opslab.util.RandomUtil;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/RandomNum/RandomServlet"})
public class RandomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        RandomInfo randomInfo = new RandomInfo();
        randomInfo.setRandom(RandomUtil.number(12));
        request.getSession().setAttribute("random", randomInfo);
        pw.println(randomInfo.getRandom());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
