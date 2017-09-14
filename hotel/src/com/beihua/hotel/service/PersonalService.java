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
	//�޸ĸ�����Ϣ
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
	
	//��ѯ������Ϣ
	public Personal queryPersonal(Personal personal){
		return personalMapper.queryPersonal(personal);
	}
	//����û�����������Ϣ
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
	//�����û���������У�飩
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
