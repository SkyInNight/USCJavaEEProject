package cn.org.cerambycidae.util.JsonUtil;

import com.alibaba.fastjson.JSONObject;

public class ToJson {
    public static String Convert(Object o){
        return JSONObject.toJSONString(o);
    }
}
