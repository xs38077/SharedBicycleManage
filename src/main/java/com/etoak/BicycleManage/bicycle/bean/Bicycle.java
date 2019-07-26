package com.etoak.BicycleManage.bicycle.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bicycle {

    private String bikeNo;

    private String model;//类别

    private String bType;//型号

    private String gys;

    private int remainNum;

    private int status;

}
