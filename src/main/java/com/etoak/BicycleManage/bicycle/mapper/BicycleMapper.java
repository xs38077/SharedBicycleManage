package com.etoak.BicycleManage.bicycle.mapper;

import com.etoak.BicycleManage.bicycle.bean.Bicycle;
import com.etoak.BicycleManage.bicycle.bean.BicycleVo;
import com.etoak.BicycleManage.common.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BicycleMapper {

    List<Dict> queryModel();

    void addBike(Bicycle bicycle);

    List<BicycleVo> queryList(@Param("bType")String bType);

    int updateBicycle(Bicycle bicycle);

    void deleteById(@Param("bikeno")String bikeno);

    List<String> queryBikeType();

    List<String> queryNoByType(@Param("type")String type);

    void alertStatus(@Param("bno")String bno);

    int returnBike(@Param("bno")String bno);

    int deleteCheckedBicycle(@Param("ids")String ids);
}
