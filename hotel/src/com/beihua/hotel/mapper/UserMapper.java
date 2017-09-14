package com.beihua.hotel.mapper;

import java.util.List;

import com.beihua.hotel.bean.User;



public interface UserMapper {
	public List<User> queryUser();
	public List<User> queryUserUpdate();
	public void delectUser(User user);
	public void updateUser(User user);
	public User queryUserById(User user);
	public String  queryPassByName(String  name);
	public String  queryPermissionsByName(String  name);
	public void addUser(User users);
	public List<User> queryUsername(String name);
	
}
