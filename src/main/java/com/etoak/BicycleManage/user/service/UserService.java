package com.etoak.BicycleManage.user.service;


import com.etoak.BicycleManage.user.bean.User;

public interface UserService {
	User queryUser(String name, String password);
}
