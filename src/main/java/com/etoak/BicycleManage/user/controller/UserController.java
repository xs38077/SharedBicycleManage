package com.etoak.BicycleManage.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.etoak.BicycleManage.user.bean.User;
import com.etoak.BicycleManage.user.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/to_login")
	public String toLoginPage(){
		return "/user/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		//销毁session
		session.invalidate();
		return "redirect:/user/to_login";
	}
	
	@RequestMapping("/login")
	public String logout(HttpServletRequest request, @RequestParam String name,@RequestParam String password){
		//加密密码
		String md5 = DigestUtils.md5Hex(password);
		User user = userService.queryUser(name,md5);
		if(user==null){
			throw new RuntimeException("用户名或密码错误");
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return "/index";
	}
	
	public static void main(String[] args) {
		String md5Hex = DigestUtils.md5Hex("etoak");
		System.out.println(md5Hex);
	}
	
}
