package cn.org.cerambycidae.MongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connection {


    private ConnectionProperty connectionProperty;
    private static Connection connection;
    private MongoClient mongoClient;
    private Connection(){
        connectionProperty = new ConnectionProperty();
    }

    public void setConnectionProperty(ConnectionProperty connectionProperty) {
        this.connectionProperty = connectionProperty;
    }

    /**
     *
     * @return 返回MongoDB数据库操作连接对象MongoDataBase,为增加对数据库的操作安全性所以没有将此对象设置为单例对象
     * @throws Exception 抛出数据库连接异常
     */
    public MongoDatabase getMongodb() throws Exception {
        //创建一个数据库连接对象
        mongoClient = new MongoClient(connectionProperty.getHost(),connectionProperty.getPort());
        //获取数据库操作对象,并连接数据库
        MongoDatabase mongodb = mongoClient.getDatabase(connectionProperty.getDatabase());
        if (mongodb.getName()!=null)
            return mongodb;
        else
            throw new Exception("数据库连接出错");
    }

    public static Connection getInstance() {
        if (connection != null)
            return connection;
        else{
            connection = new Connection();
        }
        return connection;
    }
}
