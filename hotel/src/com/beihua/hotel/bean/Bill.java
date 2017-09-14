package com.beihua.hotel.bean;

import java.util.List;

public class Bill {
	private String id;
	private String uname;
	private String roomcode;
	private String customer;
    private String idcard;
    private String r_money;
    private String foodbeverage;
    private String other;
    private String totle;
    private String time;
    private String remark;
    private String state;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getR_money() {
		return r_money;
	}
	public void setR_money(String rMoney) {
		r_money = rMoney;
	}
	public String getFoodbeverage() {
		return foodbeverage;
	}
	public void setFoodbeverage(String foodbeverage) {
		this.foodbeverage = foodbeverage;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getTotle() {
		return totle;
	}
	public void setTotle(String totle) {
		this.totle = totle;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	//每天的客房消费总合
	public String dayroom(List<Bill> bList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<bList.size();i++){
			Double t=Double.parseDouble(bList.get(i).getR_money());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			
		}
		return totle;
	}
	//每天的客房消费总合
	public String dayfoodbeverage(List<Bill> bList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<bList.size();i++){
			Double t=Double.parseDouble(bList.get(i).getFoodbeverage());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			
		}
		return totle;
	}
	
	//每天的客房消费总合
	public String dayother(List<Bill> bList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<bList.size();i++){
			Double t=Double.parseDouble(bList.get(i).getOther());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			
		}
		return totle;
	}
	
	//每天的客房消费总合
	public String daytotle(List<Bill> bList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<bList.size();i++){
			Double t=Double.parseDouble(bList.get(i).getTotle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			
		}
		return totle;
	}
	
	
}
