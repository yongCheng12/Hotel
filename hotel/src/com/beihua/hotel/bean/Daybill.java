package com.beihua.hotel.bean;

import java.util.List;

public class Daybill {
	private String id;
	private String uname;
	private String d_r_money;
	private String d_foodbeverage;
	private String d_other;
	private String d_totle;
	private String realtotle;
	private String spending;
	private String time;
	private String remark;
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
	public String getD_r_money() {
		return d_r_money;
	}
	public void setD_r_money(String dRMoney) {
		d_r_money = dRMoney;
	}
	public String getD_foodbeverage() {
		return d_foodbeverage;
	}
	public void setD_foodbeverage(String dFoodbeverage) {
		d_foodbeverage = dFoodbeverage;
	}
	public String getD_other() {
		return d_other;
	}
	public void setD_other(String dOther) {
		d_other = dOther;
	}
	public String getD_totle() {
		return d_totle;
	}
	public void setD_totle(String dTotle) {
		d_totle = dTotle;
	}
	public String getRealtotle() {
		return realtotle;
	}
	public void setRealtotle(String realtotle) {
		this.realtotle = realtotle;
	}
	public String getSpending() {
		return spending;
	}
	public void setSpending(String spending) {
		this.spending = spending;
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
	 
	//客房消费总合
	public String dayroom(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_r_money()!=null){
			//System.out.println(allDayList.get(i).getD_r_money());
			Double t=Double.parseDouble(allDayList.get(i).getD_r_money());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			}
		}
		return totle;
	}
	//餐饮消费总合
	public String dayfoodbeverage(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_foodbeverage()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_foodbeverage());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			}
		}
		return totle;
	}
	
	//其他消费总合
	public String dayother(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_other()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_other());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			}
		}
		return totle;
	}
	
	//总消费总合
	public String daytotle(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_totle()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_totle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			}
		}
		return totle;
	}
	

}
