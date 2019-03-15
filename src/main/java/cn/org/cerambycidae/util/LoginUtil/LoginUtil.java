package cn.org.cerambycidae.util.LoginUtil;

import cn.org.cerambycidae.pojo.UserInfoExample;

public class LoginUtil {
    public static UserInfoExample Convert(String name,String password){
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andNameLike(name);
        criteria.andPasswordLike(password);
        return userInfoExample;
    }
}
