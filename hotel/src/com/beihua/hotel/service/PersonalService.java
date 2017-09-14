package com.beihua.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.beihua.hotel.bean.Personal;
import com.beihua.hotel.mapper.PersonalMapper;

@Service
public class PersonalService {
	@Autowired
	private PersonalMapper personalMapper;
	//修改个人信息
	public boolean updatePersonal(Personal personal){
		boolean sign = false;
		try {
			personalMapper.updatePersonal(personal);
			sign = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sign;
		
	}
	
	//查询个人信息
	public Personal queryPersonal(Personal personal){
		return personalMapper.queryPersonal(personal);
	}
	//添加用户名到个人信息
	public boolean addPersonal(Personal personal){
		boolean sign = false;
		try {
			personalMapper.addPersonal(personal);
			sign = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sign;
	}
	//查找用户名（重名校验）
	public boolean queryPersonalName(String uname){
		boolean sign = true;
		try {
			List<Personal> i=personalMapper.queryPersonalName(uname);
			System.out.println(uname);
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
