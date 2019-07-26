package com.etoak.BicycleManage.rental.service.impl;

import com.etoak.BicycleManage.common.Page;
import com.etoak.BicycleManage.rental.bean.Rental;
import com.etoak.BicycleManage.rental.bean.RentalVo;
import com.etoak.BicycleManage.rental.mapper.RentalMapper;
import com.etoak.BicycleManage.rental.service.RentalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    RentalMapper rentalMapper;

    @Override
    public String loadRentNum() {
        String lastRentNum =  rentalMapper.loadRentNum();
        return lastRentNum;
    }

    @Override
    public void add(Rental rental) {
        rentalMapper.add(rental);
    }

    @Override
    public Page<RentalVo> queryRental(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<RentalVo> list= rentalMapper.queryRental();
        PageInfo<RentalVo> info = new PageInfo<>(list);
        Page<RentalVo> page = new Page<>(info.getPageNum(), info.getPageSize(),
                info.getTotal(), info.getPages(), info.getList(), info.getPrePage(), info.getNextPage());
        return page;
    }

    @Override
    public int returnBike(String bno) {
        return rentalMapper.returnBike(bno);
    }
}
