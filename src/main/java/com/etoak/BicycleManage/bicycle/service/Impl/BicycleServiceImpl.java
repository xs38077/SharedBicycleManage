package com.etoak.BicycleManage.bicycle.service.Impl;

import com.etoak.BicycleManage.bicycle.bean.Bicycle;
import com.etoak.BicycleManage.bicycle.bean.BicycleVo;
import com.etoak.BicycleManage.bicycle.mapper.BicycleMapper;
import com.etoak.BicycleManage.bicycle.service.BicycleService;
import com.etoak.BicycleManage.common.Dict;
import com.etoak.BicycleManage.common.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleServiceImpl implements BicycleService {

    @Autowired
    BicycleMapper bicycleMapper;

    @Override
    public List<Dict> queryModel() {
        return bicycleMapper.queryModel();
    }

    @Override
    public void addBike(Bicycle bicycle) {
        bicycleMapper.addBike(bicycle);
    }

    @Override
    public Page<BicycleVo> queryBicycle(int pageNumber, int pageSize, String bType) {
//1.设置分页信息
        PageHelper.startPage(pageNumber,pageSize);

        //2.查询数据
        List<BicycleVo> list = bicycleMapper.queryList(bType);

        //3.创建pageInfo对象
        PageInfo<BicycleVo> info = new PageInfo<>(list);

        //4.创建自定义Page对象
        Page<BicycleVo> page = new Page<>(info.getPageNum(), info.getPageSize(),
                info.getTotal(), info.getPages(), info.getList(), info.getPrePage(), info.getNextPage());
        //5.返回Page
        return page;
    }

    @Override
    public int updataBicycle(Bicycle bicycle) {
        return bicycleMapper.updateBicycle(bicycle);
    }

    @Override
    public void deleteBikeById(String bikeno) {
        bicycleMapper.deleteById(bikeno);
    }
}
