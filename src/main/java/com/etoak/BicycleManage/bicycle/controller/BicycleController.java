package com.etoak.BicycleManage.bicycle.controller;

import com.etoak.BicycleManage.bicycle.bean.Bicycle;
import com.etoak.BicycleManage.bicycle.bean.BicycleVo;
import com.etoak.BicycleManage.bicycle.service.BicycleService;
import com.etoak.BicycleManage.common.Dict;
import com.etoak.BicycleManage.common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bicycle")
public class BicycleController {
    @Autowired
    BicycleService bicycleService;

    @RequestMapping("/to_addBike")
    public String toAddBike(){
        return "bicycle/add_bike";
    }

    @RequestMapping("/queryModel")
    @ResponseBody
    public List<Dict> queryModel(){
        List<Dict> dictList = bicycleService.queryModel();
        return dictList;
    }

    @RequestMapping("/add")
    public String addBike(Bicycle bicycle){

        bicycleService.addBike(bicycle);

        return "redirect:/bicycle/to_addBike";
    }

    @RequestMapping("/to_BikeList")
    public String toBicycleList(){
        return "bicycle/bicyclelist";
    }

    @RequestMapping("/queryBicycle")
    @ResponseBody
    public Page<BicycleVo> queryBicycle(@RequestParam(required=false ,defaultValue="1")int pageNumber,@RequestParam(required=false ,defaultValue="3")int pageSize ,String bType){
        Page<BicycleVo> page = bicycleService.queryBicycle(pageNumber,pageSize,bType);
        return page;
    }

    @PutMapping("{bike_no}")
    @ResponseBody
    public Map<String,Object> updateBicycle(@PathVariable("bike_no") String bike_no, @RequestBody Bicycle bicycle){
        HashMap<String, Object> map = new HashMap<>();
        bicycle.setBikeNo(bike_no);
        int updateCount = bicycleService.updataBicycle(bicycle);
        map.put("code", updateCount);
        map.put("msg", "success");
        return map;
    }

    @DeleteMapping("deleteBike/{bikeno}")
    public String delByHouseId( @PathVariable("bikeno")String bikeno){
        bicycleService.deleteBikeById(bikeno);
        return "redirect:/bicycle/to_BikeList";
    }

    //加载单车型号
    @RequestMapping("queryBikeType")
    @ResponseBody
    public List<String> queryBikeType(){
        List<String> typeList = bicycleService.queryBikeType();
        return typeList;
    }

    @RequestMapping("queryNoByType/{type}")
    @ResponseBody
    public List<String> queryNoByType(@PathVariable("type")String type){
        List<String> noList = bicycleService.queryNoByType(type);
        return noList;
    }

    @RequestMapping("deleteCheckedBicycle")
    public String deleteCheckedBicycle(String ids){
        String[] idsArray = ids.split(",");
        List<String> idList = Arrays.asList(idsArray);
        bicycleService.deleteCheckedBicycle(idList);
        return "redirect:/bicycle/to_BikeList";
    }

}
