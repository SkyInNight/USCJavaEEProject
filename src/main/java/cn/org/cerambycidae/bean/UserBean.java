package cn.org.cerambycidae.bean;

import cn.org.cerambycidae.pojo.UserInfo;
import cn.org.cerambycidae.util.LoginUtil.LoginValidatieUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean //这里是将此类注册为JavaServer Faces的资源，从而不需要配置托管Bean的配置文件
@SessionScoped
public class UserBean {

    private Integer id;

    private String name;

    private String password;

    private String emails;

    public UserBean() {
        this.name = "admin";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String VerifyPassword(){
        String consequence;
        //1. 判断密码首先需要获取正确的用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setName(this.name);
        userInfo.setPassword(this.password);
        return LoginValidatieUtil.Convert(userInfo);
    }
}
