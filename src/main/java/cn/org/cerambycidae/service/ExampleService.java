package cn.org.cerambycidae.service;

import cn.org.cerambycidae.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * ExampleService主要封装对数据库表的基本操作<操作对象，对象主键，对象Example>
 */
public interface ExampleService<T, K, O> {

    /* 数据增加 */

    //添加一个数据库记录
    int insert(T example);

    //异步添加一个数据库记录
    int insertSelective(T example);

    /* 数据修改 */

    //异步更新数据
    int updateByExampleSelective(@Param("example") T example, @Param("eexample") O eexample);

    //更新数据
    int updateByExample(@Param("example") T example, @Param("eexample") O eexample);

    //按照主键异步更新数据
    int updateByPrimaryKeySelective(T example);

    //按照主键更新数据
    int updateByPrimaryKey(T example);

    /* 数据查询 */

    //删除数据集
    int deleteByExample(O eexample);

    //通过主键删除数据
    int deleteByPrimaryKey(K id);

    /* 数据删除 */

    //查询数据
    List<T> selectByExample(O eexample);

    //通过主键查询数据
    T selectByPrimaryKey(K id);

    /* 统计数据 */
    long countByExample(O eexample);
}
