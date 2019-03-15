package cn.org.cerambycidae.util.DataBaseUtil;

import cn.org.cerambycidae.pojo.StudentExample;

import java.io.UnsupportedEncodingException;

public class NameAndAgeRequest {
    public static StudentExample Conversion(String name, String age) throws UnsupportedEncodingException {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (name == null||name.equals(""))
        {
            criteria.andNameLike("%%");
        }else{
            //这里因为Get请求的字符编码转换是不能通过request直接转的，所以需要再转换一下
            criteria.andNameLike( "%"+new String(name.getBytes("ISO-8859-1"),"utf-8")+"%");
        }
        if (age != null&&!age.equals(""))
        {
            Integer integer = Integer.valueOf(age);
            criteria.andAgeEqualTo(integer);
        }
        return studentExample;
    }
}
