package com.beihua.hotel.mapper;

import java.util.List;

import com.beihua.hotel.bean.Personal;



public interface PersonalMapper {
	public void updatePersonal(Personal personal);
	public Personal queryPersonal(Personal personal);
	public void addPersonal(Personal personal);
	public List<Personal> queryPersonalName(String uname);
}
