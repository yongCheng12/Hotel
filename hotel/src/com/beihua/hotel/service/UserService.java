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
	
	//��ѯ�����û�
	public User queryUserById(User user){
		return userMapper.queryUserById(user);
	}
	
	//ɾ���û�
	public void delectUser(User user){
		userMapper.delectUser(user);
	}
	
	//�޸��û�Ȩ��
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
	
	//��ѯ����
	public String  queryPassByName(String name){
		return userMapper.queryPassByName(name);
	}
	
	//��ѯȨ��
	public String   queryPermissionsByName(String name){
		return userMapper.queryPermissionsByName(name);
	} 
	
	//����û�
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
	
	//�����û���������У�飩
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
