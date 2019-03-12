package cn.org.cerambycidae.util;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AcceptJson {
    public String acceptJSON(HttpServletRequest request){
        String acceptjson = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader( (ServletInputStream) request.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            acceptjson = sb.toString();
//            System.out.print(acceptjson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acceptjson;
    }
}
