package cn.org.cerambycidae.mapper;

import cn.org.cerambycidae.pojo.StudentJSFInfo;
import cn.org.cerambycidae.pojo.StudentJSFInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentJSFInfoMapper {
    long countByExample(StudentJSFInfoExample example);

    int deleteByExample(StudentJSFInfoExample example);

    int deleteByPrimaryKey(Integer stuNum);

    int insert(StudentJSFInfo record);

    int insertSelective(StudentJSFInfo record);

    List<StudentJSFInfo> selectByExample(StudentJSFInfoExample example);

    StudentJSFInfo selectByPrimaryKey(Integer stuNum);

    int updateByExampleSelective(@Param("record") StudentJSFInfo record, @Param("example") StudentJSFInfoExample example);

    int updateByExample(@Param("record") StudentJSFInfo record, @Param("example") StudentJSFInfoExample example);

    int updateByPrimaryKeySelective(StudentJSFInfo record);

    int updateByPrimaryKey(StudentJSFInfo record);
}