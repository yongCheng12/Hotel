package com.beihua.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beihua.hotel.bean.User;
import com.beihua.hotel.mapper.UserMapper;


@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	public List<User> showUser(){
		return userMapper.queryUser();		
	}
	
	
	public List<User> showUserUpdate(){
		return userMapper.queryUserUpdate();		
	}
	
	//查询单个用户
	public User queryUserById(User user){
		return userMapper.queryUserById(user);
	}
	
	//删除用户
	public void delectUser(User user){
		userMapper.delectUser(user);
	}
	
	//修改用户权限
	public boolean updateUser(User user){
		boolean sign = false;
		try {
			userMapper.updateUser(user);
			sign = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sign;
		
	}
	
	//查询密码
	public String  queryPassByName(String name){
		return userMapper.queryPassByName(name);
	}
	
	//查询权限
	public String   queryPermissionsByName(String name){
		return userMapper.queryPermissionsByName(name);
	} 
	
	//添加用户
	public boolean addUsers(User user){
		boolean sign = false;
		try {
			userMapper.addUser(user);
			sign = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sign;
	}
	
	//查找用户名（重名校验）
	public boolean queryUsername(String name){
		boolean sign = true;
		try {
			List<User> i=userMapper.queryUsername(name);
			System.out.println(name);
			System.out.println(i.size());
			if(i.size()>0){
				sign = false;
			}else{
				sign = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sign;
		
	}
	
}
