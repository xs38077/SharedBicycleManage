package com.etoak.BicycleManage.rental.mapper;

import com.etoak.BicycleManage.rental.bean.Rental;
import com.etoak.BicycleManage.rental.bean.RentalVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentalMapper {

    String loadRentNum();

    void add(Rental rental);

    List<RentalVo> queryRental();

    int returnBike(@Param("bno")String bno);
}
