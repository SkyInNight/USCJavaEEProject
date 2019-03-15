package cn.org.cerambycidae.service.Impl;

import cn.org.cerambycidae.mapper.StudentInfoMapper;
import cn.org.cerambycidae.pojo.StudentInfo;
import cn.org.cerambycidae.pojo.StudentInfoExample;

import cn.org.cerambycidae.service.StudentInfoService;
import cn.org.cerambycidae.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.management.RuntimeErrorException;
import java.util.List;

public class StudentInfoServiceImpl implements StudentInfoService {

    SqlSession sqlSession;
    StudentInfoMapper studentMapper;

    @Override
    public int insert(StudentInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentInfoMapper，StudentInfoMapper接口的实现类对象由sqlSession.getMapper(StudentInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.insert(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int insertSelective(StudentInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentInfoMapper，StudentInfoMapper接口的实现类对象由sqlSession.getMapper(StudentInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.insertSelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExampleSelective(StudentInfo example, StudentInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentInfoMapper，StudentInfoMapper接口的实现类对象由sqlSession.getMapper(StudentInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByExampleSelective(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExample(StudentInfo example, StudentInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentInfoMapper，StudentInfoMapper接口的实现类对象由sqlSession.getMapper(StudentInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByExample(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByPrimaryKeySelective(StudentInfo example) {
        throw new RuntimeErrorException(new Error("此方法不可用"));
    }

    @Override
    public int updateByPrimaryKey(StudentInfo example) {
        throw new RuntimeErrorException(new Error("此方法不可用"));
    }

    @Override
    public int deleteByExample(StudentInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentInfoMapper，StudentInfoMapper接口的实现类对象由sqlSession.getMapper(StudentInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.deleteByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        throw new RuntimeErrorException(new Error("此方法不可用"));
    }

    @Override
    public List<StudentInfo> selectByExample(StudentInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentInfoMapper，StudentInfoMapper接口的实现类对象由sqlSession.getMapper(StudentInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        List<StudentInfo> conserquence = studentMapper.selectByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }

    @Override
    public StudentInfo selectByPrimaryKey(Integer id) {
        throw new RuntimeErrorException(new Error("此方法不可用"));
    }

    @Override
    public long countByExample(StudentInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentInfoMapper，StudentInfoMapper接口的实现类对象由sqlSession.getMapper(StudentInfoMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        long conserquence = studentMapper.countByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }
}
