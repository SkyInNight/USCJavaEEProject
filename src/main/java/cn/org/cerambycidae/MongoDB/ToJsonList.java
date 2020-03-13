package cn.org.cerambycidae.MongoDB;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.MongoCursor;
import com.opslab.util.StringUtil;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ToJsonList {
    public static String Convert(MongoCursor<Document> mongoCursor){
        String json = new String();
        List<String> jsonList = new ArrayList<String>();
        while(mongoCursor.hasNext()){
            String jsonString = mongoCursor.next().toJson();
            json += jsonString + ",";
            jsonList.add(jsonString);
        }
        json = StringUtil.left(json,json.length()-1);
        return "["+json+"]";
    }
}
