package com.beihua.hotel.bean;

import java.util.List;

public class MonthBill {
	private String m_r_money;
	private String m_foodbeverage;
	private String m_other;
	private String m_totle;
	private String m_realtotle;
	private String m_spending;
	private String l_r_money;
	private String l_foodbeverage;
	private String l_other;
	private String l_totle;
	private String l_realtotle;
	private String l_spending;
	public String getM_r_money() {
		return m_r_money;
	}
	public void setM_r_money(String mRMoney) {
		m_r_money = mRMoney;
	}
	public String getM_foodbeverage() {
		return m_foodbeverage;
	}
	public void setM_foodbeverage(String mFoodbeverage) {
		m_foodbeverage = mFoodbeverage;
	}
	public String getM_other() {
		return m_other;
	}
	public void setM_other(String mOther) {
		m_other = mOther;
	}
	public String getM_totle() {
		return m_totle;
	}
	public void setM_totle(String mTotle) {
		m_totle = mTotle;
	}
	public String getM_realtotle() {
		return m_realtotle;
	}
	public void setM_realtotle(String mRealtotle) {
		m_realtotle = mRealtotle;
	}
	public String getM_spending() {
		return m_spending;
	}
	public void setM_spending(String mSpending) {
		m_spending = mSpending;
	}
	
	public String getL_r_money() {
		return l_r_money;
	}
	public void setL_r_money(String lRMoney) {
		l_r_money = lRMoney;
	}
	public String getL_foodbeverage() {
		return l_foodbeverage;
	}
	public void setL_foodbeverage(String lFoodbeverage) {
		l_foodbeverage = lFoodbeverage;
	}
	public String getL_other() {
		return l_other;
	}
	public void setL_other(String lOther) {
		l_other = lOther;
	}
	public String getL_totle() {
		return l_totle;
	}
	public void setL_totle(String lTotle) {
		l_totle = lTotle;
	}
	public String getL_realtotle() {
		return l_realtotle;
	}
	public void setL_realtotle(String lRealtotle) {
		l_realtotle = lRealtotle;
	}
	public String getL_spending() {
		return l_spending;
	}
	public void setL_spending(String lSpending) {
		l_spending = lSpending;
	}
	//客房消费总合
	public void Monthroom(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_r_money()!=null){
			//System.out.println(allDayList.get(i).getD_r_money());
			Double t=Double.parseDouble(allDayList.get(i).getD_r_money());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setM_r_money(totle);
			}
		}
		
	}
	//餐饮消费总合
	public void Monthfoodbeverage(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_foodbeverage()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_foodbeverage());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setM_foodbeverage(totle);
			}
		}
		
	}
	
	//其他消费总合
	public void Monthother(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_other()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_other());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setM_other(totle);
			}
		}
		
	}
	
	//总消费总合
	public void Monthtotle(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_totle()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_totle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setM_totle(totle);
			}
		}
	
	}
	
	//总实际收入总合
	public void Monthrealtotle(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			//System.out.println(allDayList.get(i).getTime());
			if(allDayList.get(i).getRealtotle()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getRealtotle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setM_realtotle(totle);
			}
		}
	
	}
	//总支出
	public void Monthspending(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			//System.out.println(allDayList.get(i).getD_r_money());
			if(allDayList.get(i).getSpending()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getSpending());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setM_spending(totle);
			}
		}
	
	}
	
	//上月客房消费总合
	public void Lmonthroom(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_r_money()!=null){
			//System.out.println(allDayList.get(i).getD_r_money());
			Double t=Double.parseDouble(allDayList.get(i).getD_r_money());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setL_r_money(totle);
			}
		}
		
	}
	//上月餐饮消费总合
	public void Lmonthfoodbeverage(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_foodbeverage()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_foodbeverage());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setL_foodbeverage(totle);
			}
		}
		
	}
	
	//上月其他消费总合
	public void Lmonthother(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_other()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_other());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setL_other(totle);
			}
		}
		
	}
	
	//上月总消费总合
	public void Lmonthtotle(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			if(allDayList.get(i).getD_totle()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getD_totle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setL_totle(totle);
			}
		}
	
	}
	
	//上月总实际收入总合
	public void Lmonthrealtotle(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			//System.out.println(allDayList.get(i).getTime());
			if(allDayList.get(i).getRealtotle()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getRealtotle());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setL_realtotle(totle);
			}
		}
	
	}
	//上月总支出
	public void Lmonthspending(List<Daybill> allDayList){
		Double d_r_money=0.00;
		String totle=null;
		for(int i=0;i<allDayList.size();i++){
			//System.out.println(allDayList.get(i).getD_r_money());
			if(allDayList.get(i).getSpending()!=null){
			Double t=Double.parseDouble(allDayList.get(i).getSpending());
			d_r_money=d_r_money+t;
			totle=Double.toString(d_r_money);
			setL_spending(totle);
			}
		}
	
	}
}
