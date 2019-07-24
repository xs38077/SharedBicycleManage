package com.etoak.BicycleManage.user.mapper;

import com.etoak.BicycleManage.user.bean.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

	User queryUser(@Param("name") String name, @Param("password") String password);
	

	
}
