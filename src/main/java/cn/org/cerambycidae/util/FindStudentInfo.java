package cn.org.cerambycidae.util;

import cn.org.cerambycidae.pojo.StudentInfoExample;

import java.io.UnsupportedEncodingException;

public class FindStudentInfo {
    public static StudentInfoExample Conversion(String name, String age,String major) throws UnsupportedEncodingException {
        StudentInfoExample studentExample = new StudentInfoExample();
        StudentInfoExample.Criteria criteria = studentExample.createCriteria();
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
        if (major == null||major.equals("")){
            criteria.andMajorLike("%%");
        }else{
            criteria.andMajorLike( "%"+new String(major.getBytes("ISO-8859-1"),"utf-8")+"%");
        }
        return studentExample;
    }
}
