package yt.cn.log.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yt.cn.log.pojo.lUser;
import yt.cn.log.pojo.lUserExample;

@Mapper
public interface lUserMapper {
    int countByExample(lUserExample example);

    int deleteByExample(lUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(lUser record);

    int insertSelective(lUser record);

    List<lUser> selectByExample(lUserExample example);

    lUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") lUser record, @Param("example") lUserExample example);

    int updateByExample(@Param("record") lUser record, @Param("example") lUserExample example);

    int updateByPrimaryKeySelective(lUser record);

    int updateByPrimaryKey(lUser record);
    void insertBody(@Param("user") lUser user);
}