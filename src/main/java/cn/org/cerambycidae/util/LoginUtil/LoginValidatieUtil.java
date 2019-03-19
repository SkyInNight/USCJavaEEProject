package cn.org.cerambycidae.util.LoginUtil;

import cn.org.cerambycidae.pojo.UserInfo;
import cn.org.cerambycidae.pojo.UserInfoExample;
import cn.org.cerambycidae.service.Impl.UserInfoServiceImpl;
import cn.org.cerambycidae.service.UserInfoService;

import java.util.List;

public class LoginValidatieUtil {
    public static String Convert(UserInfo userInfo){
        String consequence="";
        //获取查询条件语句
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andNameLike(userInfo.getName());

        //查询对象数据
        UserInfoService userInfoService = new UserInfoServiceImpl();
        List<UserInfo> userInfos = userInfoService.selectByExample(userInfoExample);

        //判断用户名是否存在
        if (userInfos.size()==0){
            consequence = "NameError";
        }
        //判断密码是否合法
        else{
            for (UserInfo user:userInfos) {
                if (user.getPassword().equals(userInfo.getPassword())){
                    consequence = "sucess";
                    break;
                }
            }
            if (!consequence.equals("sucess")){
                consequence = "PasswordError";
            }
        }
        return consequence;
    }
}
