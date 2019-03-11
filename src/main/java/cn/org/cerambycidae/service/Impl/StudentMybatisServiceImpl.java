package cn.org.cerambycidae.service.Impl;

import cn.org.cerambycidae.mapper.StudentMapper;
import cn.org.cerambycidae.pojo.Student;
import cn.org.cerambycidae.pojo.StudentExample;
import cn.org.cerambycidae.service.StudentService;
import cn.org.cerambycidae.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentMybatisServiceImpl implements StudentService {

    SqlSession sqlSession;
    StudentMapper studentMapper;

    @Override
    public int insert(Student example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.insert(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int insertSelective(Student example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.insertSelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExampleSelective(Student example, StudentExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByExampleSelective(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExample(Student example, StudentExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByExample(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByPrimaryKeySelective(Student example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByPrimaryKeySelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByPrimaryKey(Student example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.updateByPrimaryKey(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int deleteByExample(StudentExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
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
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = studentMapper.deleteByPrimaryKey(id);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public List<Student> selectByExample(StudentExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        List<Student> conserquence = studentMapper.selectByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        Student conserquence = studentMapper.selectByPrimaryKey(id);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }

    @Override
    public long countByExample(StudentExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // StudentMapper，StudentMapper接口的实现类对象由sqlSession.getMapper(StudentMapper.class)动态构建出来
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        long conserquence = studentMapper.countByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }
}
