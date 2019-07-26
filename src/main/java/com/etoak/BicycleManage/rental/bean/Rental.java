package com.etoak.BicycleManage.rental.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    private String rentalNo;

    private String bikeType;

    private String bno;

    private String personName;

    private String phone;

    private String startTime;

    private String endTime;



}
