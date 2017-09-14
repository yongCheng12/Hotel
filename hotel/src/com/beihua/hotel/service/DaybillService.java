package com.beihua.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beihua.hotel.bean.Bill;
import com.beihua.hotel.bean.Daybill;
import com.beihua.hotel.bean.Page;
import com.beihua.hotel.mapper.DaybillMapper;

@Service
public class DaybillService {
	@Autowired
	private DaybillMapper daybillMapper;
	
	//每日实际收入情况
   public void updateDaybill(Daybill daybill){
	   daybillMapper.updateDaybill(daybill);
	   
   }
   //分页显示daybill

	public List<Daybill> queryDayByPage(Page page){
		return daybillMapper.queryDayByPage(page);
		
	}
	//分页显示bill
	public List<Bill> queryBillByPage(Page page){
		return daybillMapper.queryBillByPage(page);
		
	}
	//按时间显示daybill
	public List<Daybill> queryDaybillByDate(Daybill daybill){
		return daybillMapper.queryDaybillByDate(daybill);
	}
	//查询所有的daybill
	public List<Daybill> qureyAllDaybill(Daybill daybill){
		return daybillMapper.qureyAllDaybill(daybill);
	}
	//查询月账单
	public List<Daybill> qureyMonthbill(String string){
		return daybillMapper.qureyMonthbill(string);
	}
	//查询年账单
	public List<Daybill> qureyYearbill(String string){
		return daybillMapper.qureyYearbill(string);
	}
}
