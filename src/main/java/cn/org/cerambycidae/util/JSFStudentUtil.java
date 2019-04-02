package cn.org.cerambycidae.util;

import cn.org.cerambycidae.bean.StudentBean;
import cn.org.cerambycidae.pojo.StudentJSFInfo;

public class JSFStudentUtil {
    public static StudentBean Convert(StudentJSFInfo student) {
        StudentBean student1 = new StudentBean();
        student1.setStu_Age(student.getStuAge());
        student1.setStu_Gender(student.getStuGender());
        student1.setStu_Num(student.getStuNum());
        student1.setStu_Major(student.getStuMajor());
        student1.setStu_Name(student.getStuName());
        student1.setStu_TeamNum(student.getStuTeamnum());
        return student1;
    }
    public static StudentJSFInfo ReConvert(StudentBean student) {
        StudentJSFInfo studentJSFInfo = new StudentJSFInfo();
        studentJSFInfo.setStuAge(student.getStu_Age());
        studentJSFInfo.setStuGender(student.getStu_Gender());
        studentJSFInfo.setStuMajor(student.getStu_Major());
        studentJSFInfo.setStuName(student.getStu_Name());
        studentJSFInfo.setStuTeamnum(student.getStu_TeamNum());
        studentJSFInfo.setStuNum(student.getStu_Num());
        return studentJSFInfo;
    }
}
