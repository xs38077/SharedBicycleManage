package com.etoak.BicycleManage.rental.service;

import com.etoak.BicycleManage.common.Page;
import com.etoak.BicycleManage.rental.bean.Rental;
import com.etoak.BicycleManage.rental.bean.RentalVo;

public interface RentalService {

     String loadRentNum();

    void add(Rental rental);

    Page<RentalVo> queryRental(int pageNumber, int pageSize);

    int returnBike(String bno);
}
