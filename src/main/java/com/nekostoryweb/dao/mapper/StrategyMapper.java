package com.nekostoryweb.dao.mapper;

import com.nekostoryweb.dao.po.Strategy;
import com.nekostoryweb.dao.po.StrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StrategyMapper {
    int countByExample(StrategyExample example);

    int deleteByExample(StrategyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Strategy record);

    int insertSelective(Strategy record);

    List<Strategy> selectByExampleWithBLOBs(StrategyExample example);

    List<Strategy> selectByExample(StrategyExample example);

    Strategy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByExampleWithBLOBs(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByExample(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByPrimaryKeySelective(Strategy record);

    int updateByPrimaryKeyWithBLOBs(Strategy record);

    int updateByPrimaryKey(Strategy record);

    List<Strategy> selectByStatus(Integer status);
}