package cn.org.cerambycidae.bean;

import com.opslab.util.RandomUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RandomInfo {
    private String random;

    public RandomInfo(){
        random = RandomUtil.number(12);
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String ShowRandom(){
        random = RandomUtil.number(12);
        return random;
    }
}
