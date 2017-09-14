package com.beihua.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.beihua.hotel.bean.Bill;
import com.beihua.hotel.bean.Daybill;
import com.beihua.hotel.mapper.BillMapper;

@Service
public class BillService {
	@Autowired
	private BillMapper billMapper;
	//添加用户
	public boolean addBill(Bill bill){
		boolean sign = false;
		try {
			billMapper.addBill(bill);
			sign = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sign;
		
	}
	//查询个人消费信息
	public List<Bill> queryPersonalBill(Bill bill){
		return billMapper.queryPersonalBill(bill);
	}
	
	//用户结账
	public boolean updateState(Bill bill){
		boolean sign = false;
		try {
			billMapper.updateState(bill);
			sign = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sign;
		
	}
	
	//查询个人消费信息通过时间
	public Bill queryPersonalByTime(String  time){
		return billMapper.queryPersonalByTime(time);
	}
	//查询消费信息
	public List<Bill> queryPersonalInfo(Bill bill){
		return billMapper.queryPersonalInfo(bill);
	}
	//每日消费信息
	 public List<Bill> dayBill(String time){
		 return billMapper.dayBill(time);
	 }
	 //将总消费信息存入daybill
	 public boolean addDayBill(Daybill daybill){
		
				boolean sign = false;
				try {
					billMapper.addDayBill(daybill);
					sign = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return sign;
	 }
	 //查询daybill的信息通过时间
	 public List<Daybill> queryDayBill(Daybill daybill){
		 return billMapper.queryDayBill(daybill);
	 }
	//修改总消费信息存入daybill
	 public boolean updateDaybill(Daybill daybill){
			boolean sign = false;
			try {
				billMapper.updateDaybill(daybill);
				sign = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sign;
	 }
}
