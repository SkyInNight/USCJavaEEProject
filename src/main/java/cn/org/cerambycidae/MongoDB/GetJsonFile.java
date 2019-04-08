package cn.org.cerambycidae.MongoDB;

import com.alibaba.fastjson.JSON;
import com.opslab.util.FileUtil;
import com.opslab.util.StringUtil;

import java.io.File;
import java.util.List;

public class GetJsonFile {
    private static String filePath = "src/main/resources/Json/jsonFile.txt";

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public static List<String> getJson(String path){
        StringBuffer content = new StringBuffer();
        List<String> contents = FileUtil.lines(new File(path));
        for (String str:contents){
            content.append(str);
        }
        //            JSONArray bsons =  JSONArray.parseArray(json);
        //            List<String> jsonList =  bsons.toJavaList(String.class);
        List<String> jsonList = JSON.parseArray(StringUtil.replaceBlank(content.toString()),String.class);
        return jsonList;
    }

    public static List<String> getJson(){
        return getJson(filePath);
    }
}
