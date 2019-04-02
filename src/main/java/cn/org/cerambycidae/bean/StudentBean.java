package cn.org.cerambycidae.bean;

import cn.org.cerambycidae.pojo.StudentJSFInfo;
import cn.org.cerambycidae.pojo.StudentJSFInfoExample;
import cn.org.cerambycidae.service.Impl.StudentJSFInfoServiceImpl;
import cn.org.cerambycidae.service.StudentJSFInfoService;
import cn.org.cerambycidae.util.JSFStudentUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.*;

@ManagedBean
@SessionScoped
public class StudentBean {
    private int stu_Num; //学生id
    private String stu_Name; //学生姓名
    private int stu_TeamNum; //学生教室id
    private int stu_Age; //学生年龄
    private String stu_Major; //学生专业
    private String stu_Gender; //学生性别
    private StudentBean aStudent;
    private Set<StudentBean> allStudent = null;

    public int getStu_Num() {
        return stu_Num;
    }

    public void setStu_Num(int stu_Num) {
        this.stu_Num = stu_Num;
    }

    public String getStu_Name() {
        return stu_Name;
    }

    public void setStu_Name(String stu_Name) {
        this.stu_Name = stu_Name;
    }

    public int getStu_TeamNum() {
        return stu_TeamNum;
    }

    public void setStu_TeamNum(int stu_TeamNum) {
        this.stu_TeamNum = stu_TeamNum;
    }

    public int getStu_Age() {
        return stu_Age;
    }

    public void setStu_Age(int stu_Age) {
        this.stu_Age = stu_Age;
    }

    public String getStu_Major() {
        return stu_Major;
    }

    public void setStu_Major(String stu_Major) {
        this.stu_Major = stu_Major;
    }

    public String getStu_Gender() {
        return stu_Gender;
    }

    public void setStu_Gender(String stu_Gender) {
        this.stu_Gender = stu_Gender;
    }

    public StudentBean getaStudent() {
        return aStudent;
    }

    public void setaStudent(StudentBean aStudent) {
        this.aStudent = aStudent;
    }

    public Set<StudentBean> getAllStudent() {
        return allStudent;
    }

    public void setAllStudent(Set<StudentBean> allStudent) {
        this.allStudent = allStudent;
    }

    // 用于添加一个新学生的方法
    public String AddStudent() throws Exception {

        // 返回值为student，使页面导航到student.xhtml
        StudentJSFInfoService studentInfoService = new StudentJSFInfoServiceImpl();
        StudentJSFInfo studentJSFInfo = JSFStudentUtil.ReConvert(this);
        studentInfoService.insertSelective(studentJSFInfo);
        return "student";
    }

    // 用于更新一个学生信息的方法
    public String UpdateStudent() {

        // 返回值为student，使页面导航到student.xhtml
        StudentJSFInfoService studentInfoService = new StudentJSFInfoServiceImpl();
        StudentJSFInfo studentJSFInfo =JSFStudentUtil.ReConvert(aStudent);
        studentInfoService.updateByPrimaryKeySelective(studentJSFInfo);
        return "student";
    }

    // 用于更新一个学生信息的方法
    public String EditStudent() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        String studentNum = params.get("studentBeanNum");
        StudentJSFInfoService studentInfoService = new StudentJSFInfoServiceImpl();
        StudentJSFInfo studentJSFInfo = studentInfoService.selectByPrimaryKey(Integer.valueOf(studentNum));
        aStudent = JSFStudentUtil.Convert(studentJSFInfo);
        // 返回值为editStudent，使页面导航到editStudent.xhtml
        return "editStudent";
    }

    // 用于删除一个学生信息的方法
    public String DeleteStudent() {

        // 返回值为student，使页面导航到student.xhtml
        StudentJSFInfoService studentInfoService = new StudentJSFInfoServiceImpl();
        studentInfoService.deleteByPrimaryKey(stu_Num);
        return "student";
    }

    // 构造JPQL实现查询的示例
    public String QueryStudents() throws SQLException {
        //这里只需要查询出所有学生的信息即可
        StudentJSFInfoService studentInfoService = new StudentJSFInfoServiceImpl();
        StudentJSFInfoExample studentJSFInfo = new StudentJSFInfoExample();
        StudentJSFInfoExample.Criteria criteria = studentJSFInfo.createCriteria();
        Set<StudentBean> sts = new HashSet<>();
        if (stu_Num+"" != null&& stu_Num!=0)
            criteria.andStuNumEqualTo(stu_Num);
        if (stu_Name != null&&!stu_Name.equals(""))
            criteria.andStuNameLike("%"+stu_Name+"%");
        else
            criteria.andStuNameLike("%%");
        List<StudentJSFInfo> students = studentInfoService.selectByExample(studentJSFInfo);
        for (StudentJSFInfo student:students) {
            sts.add(JSFStudentUtil.Convert(student));
        }
        sts.stream().sorted();
        allStudent = sts;
        // 返回值为student，使页面导航到student.xhtml
        return "student";
    }
}
