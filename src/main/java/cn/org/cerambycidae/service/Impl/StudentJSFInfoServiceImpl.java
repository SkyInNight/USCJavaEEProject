package cn.org.cerambycidae.service.Impl;

import cn.org.cerambycidae.mapper.StudentJSFInfoMapper;
import cn.org.cerambycidae.pojo.StudentJSFInfo;
import cn.org.cerambycidae.pojo.StudentJSFInfoExample;
import cn.org.cerambycidae.service.StudentJSFInfoService;
import cn.org.cerambycidae.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.management.RuntimeErrorException;
import java.util.List;

public class StudentJSFInfoServiceImpl implements StudentJSFInfoService {
    SqlSession sqlSession;
    StudentJSFInfoMapper studentMapper;

    @Override
    public int insert(StudentJSFInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.insert(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int insertSelective(StudentJSFInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.insertSelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExampleSelective(StudentJSFInfo example, StudentJSFInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByExampleSelective(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExample(StudentJSFInfo example, StudentJSFInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByExample(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByPrimaryKeySelective(StudentJSFInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByPrimaryKeySelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByPrimaryKey(StudentJSFInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByPrimaryKeySelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int deleteByExample(StudentJSFInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.deleteByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.deleteByPrimaryKey(id);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public List<StudentJSFInfo> selectByExample(StudentJSFInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        List<StudentJSFInfo> conserquence = studentMapper.selectByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }

    @Override
    public StudentJSFInfo selectByPrimaryKey(Integer id) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        StudentJSFInfo conserquence = studentMapper.selectByPrimaryKey(id);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }

    @Override
    public long countByExample(StudentJSFInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentJSFInfoMapper，StudentJSFInfoMapper接口的实现类对象由sqlSession.getMapper(StudentJSFInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentJSFInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        long conserquence = studentMapper.countByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }
}
