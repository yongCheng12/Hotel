package com.beihua.hotel.bean;

import java.util.List;

public class YearBill {
	private String y_r_money;
	private String y_foodbeverage;
	private String y_other;
	private String y_totle;
	private String y_realtotle;
	private String y_spending;
	public String getY_r_money() {
		return y_r_money;
	}
	public void setY_r_money(String yRMoney) {
		y_r_money = yRMoney;
	}
	public String getY_foodbeverage() {
		return y_foodbeverage;
	}
	public void setY_foodbeverage(String yFoodbeverage) {
		y_foodbeverage = yFoodbeverage;
	}
	public String getY_other() {
		return y_other;
	}
	public void setY_other(String yOther) {
		y_other = yOther;
	}
	public String getY_totle() {
		return y_totle;
	}
	public void setY_totle(String yTotle) {
		y_totle = yTotle;
	}
	public String getY_realtotle() {
		return y_realtotle;
	}
	public void setY_realtotle(String yRealtotle) {
		y_realtotle = yRealtotle;
	}
	public String getY_spending() {
		return y_spending;
	}
	public void setY_spending(String ySpending) {
		y_spending = ySpending;
	}
	
	//客房消费总合
	public void Yearroom(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_r_money()!=null){
			//System.out.println(allDayList.get(i).getD_r_money());
			Double t=Double.parseDouble(allDayList.get(i).getD_r_money());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setY_r_money(totle);
			}
		}
		
	}
	//餐饮消费总合
	public void Yearfoodbeverage(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_foodbeverage()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_foodbeverage());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setY_foodbeverage(totle);
			}
		}
		
	}
	
	//其他消费总合
	public void Yearother(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_other()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_other());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setY_other(totle);
			}
		}
		
	}
	
	//总消费总合
	public void Yeartotle(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_totle()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_totle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setY_totle(totle);
			}
		}
	
	}
	
	//总实际收入总合
	public void Yearrealtotle(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			//System.out.println(allDayList.get(i).getTime());
			if(allDayList.get(i).getRealtotle()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getRealtotle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setY_realtotle(totle);
			}
		}
	
	}
	//总支出
	public void Yearspending(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			//System.out.println(allDayList.get(i).getD_r_money());
			if(allDayList.get(i).getSpending()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getSpending());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setY_spending(totle);
			}
		}
	
	}
}
