package com.etoak.BicycleManage.rental.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalVo extends Rental {
    private int status;
}
