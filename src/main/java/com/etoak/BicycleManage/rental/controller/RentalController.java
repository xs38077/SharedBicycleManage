package com.etoak.BicycleManage.rental.controller;

import com.etoak.BicycleManage.bicycle.bean.Bicycle;
import com.etoak.BicycleManage.bicycle.bean.BicycleVo;
import com.etoak.BicycleManage.bicycle.service.BicycleService;
import com.etoak.BicycleManage.common.Dict;
import com.etoak.BicycleManage.common.Page;
import com.etoak.BicycleManage.rental.bean.Rental;
import com.etoak.BicycleManage.rental.bean.RentalVo;
import com.etoak.BicycleManage.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    BicycleService bicycleService;

    @Autowired
    RentalService rentalService;

    @RequestMapping("/to_rentBike")
    public String toRentBike(){
        return "rental/add_rent";
    }

    @RequestMapping("/loadRentNum")
    @ResponseBody
    public Map<String, String> loadRentNum(){
        String lastRentNum =  rentalService.loadRentNum();
        HashMap<String, String> map = new HashMap<>();
        map.put("lastRentNum",lastRentNum);
        return map;
    }

    @RequestMapping("/add")
    public String add(Rental rental){
        rentalService.add(rental);
        bicycleService.alertStatus(rental.getBno());
        return "redirect:/rental/to_rentBike";
    }

    @RequestMapping("/to_rentList")
    public String to_rentList(){
        return "rental/rentallist";
    }

    @RequestMapping("/queryRental")
    @ResponseBody
    public Page<RentalVo> queryRental(@RequestParam(required = false,defaultValue = "1")int pageNumber,@RequestParam(required = false,defaultValue = "1") int pageSize){
        Page<RentalVo> page = rentalService.queryRental(pageNumber,pageSize);
        return page;
    }

    @RequestMapping("/returnBike/{bno}")
    @ResponseBody
    public Map returnBike(@PathVariable("bno")String bno){
        //更新结束租赁时间
        int count = rentalService.returnBike(bno);
        //修改租赁状态
        int count1 = bicycleService.returnBike(bno);
        HashMap<String, String> map = new HashMap<>();
        if(count==1 && count1==1){
            map.put("status","success");

        }else{
            map.put("status","error");
        }
        return map;
    }
}
