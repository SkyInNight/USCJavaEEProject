package cn.org.cerambycidae.service.Impl;

import cn.org.cerambycidae.mapper.UserInfoMapper;
import cn.org.cerambycidae.pojo.UserInfo;
import cn.org.cerambycidae.pojo.UserInfoExample;
import cn.org.cerambycidae.pojo.UserInfo;
import cn.org.cerambycidae.pojo.UserInfoExample;
import cn.org.cerambycidae.service.UserInfoService;
import cn.org.cerambycidae.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    SqlSession sqlSession;
    UserInfoMapper userInfoMapper;

    @Override
    public int insert(UserInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.insert(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int insertSelective(UserInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.insertSelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExampleSelective(UserInfo example, UserInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.updateByExampleSelective(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByExample(UserInfo example, UserInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.updateByExample(example, eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.updateByPrimaryKeySelective(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int updateByPrimaryKey(UserInfo example) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.updateByPrimaryKey(example);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int deleteByExample(UserInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.deleteByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        int conserquence = userInfoMapper.deleteByPrimaryKey(id);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.commit();
        sqlSession.close();
        return conserquence;
    }

    @Override
    public List<UserInfo> selectByExample(UserInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        List<UserInfo> conserquence = userInfoMapper.selectByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        UserInfo conserquence = userInfoMapper.selectByPrimaryKey(id);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }

    @Override
    public long countByExample(UserInfoExample eexample) {
        sqlSession = MyBatisUtil.getSqlSession();
        // UserInfoMapper，UserInfoMapper接口的实现类对象由sqlSession.getMapper(UserInfoMapper.class)动态构建出来
        userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        // 执行查询操作，将查询结果自动封装成User返回
        long conserquence = userInfoMapper.countByExample(eexample);
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return conserquence;
    }
}
