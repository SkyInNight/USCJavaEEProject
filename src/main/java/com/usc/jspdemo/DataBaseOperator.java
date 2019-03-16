package com.usc.jspdemo;

/**
 * 数据库访问类
 * 由于建立数据库连接的开销较大，一般采用数据库连接池的方式来处理数据库连接
 * 鉴于本示例中数据库访问量较小，在这里采用单例模式来构建数据库访问类
 * 即为该实例中所有数据库访问只建立一个数据库连接
 * @author NEWSTART
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.com.usc.pojo.Student;

public class DataBaseOperator {
    // 数据库连接变量，用来建立数据库连接
    Connection conn = null;
    // 数据库路径
    String driver = "com.mysql.jdbc.Driver";
    // 数据库用户名
    String uname = "root";
    // 数据库密码
    String pwd = "123456";
    String url = "jdbc:mysql://129.204.49.63/Student?characterEncoding=utf-8";
    // 实例变量，用来存储唯一实例，饿汉式
    static DataBaseOperator instance = null;

    // 构造函数，为实现单例模式，将构造函数定义为private类型
    private DataBaseOperator() {
        Init();
    }

    // 初始化方法
    void Init() {
        // 数据库驱动
        try {
            Class.forName(driver);
            // 建立并获得数据库连接
            try {
                conn = DriverManager.getConnection(url, uname, pwd);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // 获得该单例实例的方法
    public static DataBaseOperator getInstance() {
        // 如果不存在该实例则创建，并保存在instance中
        if (instance == null) {
            instance = new DataBaseOperator();
        }
        // 如果存在则返回该实例
        return instance;
    }

    // 数据库插入方法
    public void insert(Student st) throws SQLException {
        // 从student实例中获取信息
        int id = st.getId();
        String name = st.getName();
        int age = st.getAge();
        String gender = st.getGender();
        String major = st.getMajor();
        int teamNum = st.getTeam();
        // 创建插入数据库的SQL语句
        String sql = "insert into studentinfo(id,name,teamNum,age,gender,major) values (" + id + ",'" + name + "',"
                + teamNum + "," + age + ",'" + gender + "','" + major + "');";
        System.out.println(sql);
        // 执行数据库操作
        Statement statement = null;
        statement = conn.createStatement();
        statement.executeUpdate(sql);
        if (statement != null) {
            statement.close();
        }
    }

    // 数据库删除
    public void delete(String id) {
        // 执行数据库操作
        Statement statement = null;
        try {
            String sql = "delete from studentinfo where id='" + id + "'";
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 数据库更新操作
    public void update(Student st) {
        try {
            // 从student实例中获取信息
            int id = st.getId();
            String name = st.getName();
            int age = st.getAge();
            String gender = st.getGender();
            String major = st.getMajor();
            int teamNum = st.getTeam();
            // 创建插入数据库的SQL语句
            String sql = "update studentinfo set id=" + id + ",name='" + name + "',teamNum=" + teamNum + "," + "age="
                    + age + ",gender='" + gender + ",major='" + major + "');";
            System.out.println(sql);
            // 执行数据库操作
            Statement statement = null;
            statement = conn.createStatement();
            statement.executeUpdate(sql);
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 数据库查询操作
    public Set<Student> searchStudents(String id, String name, String teamNum) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        // 根据查询条件查询
        String sql = "select * from studentinfo";
        statement = conn.createStatement();
        Set<Student> sts = new HashSet<Student>();
        if (id == null)
            id = "";
        if (name == null)
            name = "";
        if (teamNum == null)
            teamNum = "";
        if (id == "")
            sql = sql + " where id like '%'";
        else
            sql = sql + " where id = " + id;
        if (name == "")
            sql = sql + " and name like '%'";
        else
            sql = sql + " and name = '" + name + "'";
        if (teamNum == "")
            sql = sql + " and teamNum like '%'";
        else
            sql = sql + " and teamNum = " + teamNum;
        System.out.println(sql);
        // 执行SQL
        resultSet = statement.executeQuery(sql);
        // 遍历查询结果
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setGender(resultSet.getString("gender"));
            student.setMajor(resultSet.getString("major"));
            student.setTeam(resultSet.getInt("teamNum"));
            sts.add(student);
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        return sts;

    }

    // 数据库查询之班级查询
    public java.util.Map<Integer, String> searchTeams(String teamNum, String baseRoom) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;
            statement = conn.createStatement();
            java.util.Map<Integer, String> teams = new HashMap<Integer, String>();
            if (teamNum == null)
                teamNum = "";
            if (baseRoom == null)
                baseRoom = "";
            if (teamNum == "" && baseRoom == "") {
                resultSet = statement.executeQuery("select * from Teams");
            }
            if (teamNum != "" && baseRoom == "") {
                resultSet = statement.executeQuery("select * from Teams where teamNum=" + teamNum + "");
            }
            if (teamNum == "" && baseRoom != "") {
                resultSet = statement.executeQuery("select * from Teams where baseRoom='" + baseRoom + "'");
            }
            if (teamNum != "" && baseRoom != "") {
                resultSet = statement.executeQuery(
                        "select * from Teams where teamNum=" + teamNum + " and baseRoom='" + baseRoom + "'");
            }
            while (resultSet.next()) {
                teams.put(resultSet.getInt("teamNum"), resultSet.getString("baseRoom"));
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            return teams;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

}

