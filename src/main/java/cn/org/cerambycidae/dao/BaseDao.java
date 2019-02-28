package cn.org.cerambycidae.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BaseDao<T,ID extends Serializable>{
    private Class classzz;

    public BaseDao(){
        Type type=this.getClass().getGenericSuperclass();       //获取直接继承父类及其类型参数
        ParameterizedType ptype=(ParameterizedType)type;
        Type[] types=ptype.getActualTypeArguments();            //获取所有泛型内的参数类型
        this.classzz=(Class)types[0];                           //取第一个类型
    }


    public List<T> query(String sql)throws Exception{
        return query(sql,null);
    }

    public List<T> query(String sql,Object[] params)throws Exception{
        Connection conn=DBHelper.getConnection();
        PreparedStatement pst=conn.prepareStatement(sql);
        if(params!=null) {
            for (int i=0;i<params.length;i++){
                pst.setObject(i+1,params[i]);
            }
        }
        ResultSet rs=pst.executeQuery();
        List<T> datas=convertEntity(rs);
        DBHelper.closeResource(conn,pst,rs);
        return datas;
    }

    /**
     * 获取类名
     * @return
     */
    public String getTableName(){
        return classzz.getSimpleName();
    }

    /**
     * 构造一个oid的sql
     * @param tableName
     * @return
     */

    public String buildOidSql(String tableName){
        return "select * from "+tableName+ " where id=?";
    }
    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    public T queryById(ID id) throws Exception{
        String oIdSql=buildOidSql(getTableName());            //构造oid查询sql
        T entity=query(oIdSql,new Object[]{id}).get(0);
        return entity;
    }

    /**
     * 结果集转换为实体类
     * @param rs
     * @return
     * @throws Exception
     */
    private List<T> convertEntity(ResultSet rs)throws Exception{
        List<T> datas=new ArrayList<T>();
        Field[] fields=classzz.getDeclaredFields();                            //反射获取类的所有属性
        ResultSetMetaData metaData=rs.getMetaData();                            //获取数据表的元数据
        int columnCount=metaData.getColumnCount();                              //获取返回数据的列总数
        while(rs.next()){
            Object obj=classzz.getDeclaredConstructor().newInstance();          //实例化实体对象
            for(int i=0;i<columnCount;i++){
                String columnLabel= metaData.getColumnLabel(i+1);               //获取as后的字段名
                Object value=rs.getObject(columnLabel);                         //获取该字段的值
                for(int fieldIndex=0;fieldIndex<fields.length;fieldIndex++){
                    Field field=fields[fieldIndex];
                    if(columnLabel.equals(field.getName())){                    //字段名和属性名相同
                        field.setAccessible(true);                              //允许暴力访问private修饰的属性
                        field.set(obj,value);                                   //给属性赋值
                        break;
                    }
                }
            }
            datas.add((T)obj);
        }
        return datas;
    }
}
