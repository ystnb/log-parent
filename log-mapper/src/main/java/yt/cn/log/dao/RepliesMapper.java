package yt.cn.log.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yt.cn.log.pojo.Replies;
import yt.cn.log.pojo.RepliesExample;

@Mapper
public interface RepliesMapper {
    int countByExample(RepliesExample example);

    int deleteByExample(RepliesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Replies record);

    int insertSelective(Replies record);

    List<Replies> selectByExampleWithBLOBs(RepliesExample example);

    List<Replies> selectByExample(RepliesExample example);

    Replies selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Replies record, @Param("example") RepliesExample example);

    int updateByExampleWithBLOBs(@Param("record") Replies record, @Param("example") RepliesExample example);

    int updateByExample(@Param("record") Replies record, @Param("example") RepliesExample example);

    int updateByPrimaryKeySelective(Replies record);

    int updateByPrimaryKeyWithBLOBs(Replies record);

    int updateByPrimaryKey(Replies record);
}