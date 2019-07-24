package com.etoak.BicycleManage.user.service.impl;

import com.etoak.BicycleManage.user.bean.User;
import com.etoak.BicycleManage.user.mapper.UserMapper;
import com.etoak.BicycleManage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User queryUser(String name, String password) {
		return userMapper.queryUser(name,password);
	}

}
