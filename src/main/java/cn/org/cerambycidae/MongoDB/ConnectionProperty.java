package cn.org.cerambycidae.MongoDB;

import com.opslab.util.PropertiesUtil;

public class ConnectionProperty {

    private String host;
    private int port;
    private String database;
    private String path = "src/main/resources/properties/db.properties";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public ConnectionProperty(){
        UpdateProperty(path);
    }

    public void UpdateProperty(String path){
        this.path = path;
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        try{
            host = propertiesUtil.GetValueByKey(path,"mongodb.host");
            port = Integer.parseInt(propertiesUtil.GetValueByKey(path,"mongodb.port"));
            database = propertiesUtil.GetValueByKey(path,"mongodb.database");
        }catch (Exception e){
            //这里添加一层文件保护，为防止读取不到配置文件导致出错
            e.printStackTrace();
        }
    }
}
