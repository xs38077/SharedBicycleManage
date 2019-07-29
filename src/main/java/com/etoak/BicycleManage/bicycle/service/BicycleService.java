package com.etoak.BicycleManage.bicycle.service;

import com.etoak.BicycleManage.bicycle.bean.Bicycle;
import com.etoak.BicycleManage.bicycle.bean.BicycleVo;
import com.etoak.BicycleManage.common.Dict;
import com.etoak.BicycleManage.common.Page;

import java.util.List;

public interface BicycleService {
    List<Dict> queryModel();

    void addBike(Bicycle bicycle);

    Page<BicycleVo> queryBicycle(int pageNumber, int pageSize, String bType);

    int updataBicycle(Bicycle bicycle);

    void deleteBikeById(String bikeno);

    List<String> queryBikeType();

    List<String> queryNoByType(String type);

    void alertStatus(String bno);

    int returnBike(String bno);

    int deleteCheckedBicycle(String ids);
}
