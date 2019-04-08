package cn.org.cerambycidae.Servlet.MongoDB;

import cn.org.cerambycidae.MongoDB.Connection;
import cn.org.cerambycidae.MongoDB.ToJsonList;
import cn.org.cerambycidae.bean.CSDNInfo;
import com.alibaba.fastjson.JSON;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/MongoDB/CSDNServlet"})
public class CSDNServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        //获取对MongoDB的数据库连接
        try {
            Connection connection = Connection.getInstance();
            MongoDatabase database = connection.getMongodb();;
            MongoCollection<Document> coll = database.getCollection("csdn");

            //查找当前表中的全部数据
            FindIterable<Document> findIterable = coll.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            List<CSDNInfo> csdns = new ArrayList<>();
            while(mongoCursor.hasNext()){
                String jsonString = mongoCursor.next().toJson();
                CSDNInfo csdnInfo = (CSDNInfo) JSON.parseObject(jsonString,CSDNInfo.class);
                csdns.add(csdnInfo);
            }
            request.getSession().setAttribute("csdns",csdns);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
