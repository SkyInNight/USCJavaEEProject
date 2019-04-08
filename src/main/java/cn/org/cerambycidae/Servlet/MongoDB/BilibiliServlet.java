package cn.org.cerambycidae.Servlet.MongoDB;

import cn.org.cerambycidae.MongoDB.Connection;
import cn.org.cerambycidae.MongoDB.ToJsonList;
import cn.org.cerambycidae.pojo.Student;
import cn.org.cerambycidae.service.Impl.StudentMybatisServiceImpl;
import cn.org.cerambycidae.service.StudentService;
import cn.org.cerambycidae.util.DataBaseUtil.NameAndAgeRequest;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

@WebServlet(urlPatterns = {"/MongoDB/BilibiliServlet"})
public class BilibiliServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        //获取对MongoDB的数据库连接
        try {
        Connection connection = Connection.getInstance();
        MongoDatabase database = connection.getMongodb();;
        MongoCollection<Document> coll = database.getCollection("bilibili");

        //查找当前表中的全部数据
        FindIterable<Document> findIterable = coll.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        String json = ToJsonList.Convert(mongoCursor);
        pw.print("{\"total\":" + coll.countDocuments() + ",\"rows\":" + json + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
