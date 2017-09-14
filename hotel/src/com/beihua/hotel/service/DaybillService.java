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
	
	//ÿ��ʵ���������
   public void updateDaybill(Daybill daybill){
	   daybillMapper.updateDaybill(daybill);
	   
   }
   //��ҳ��ʾdaybill

	public List<Daybill> queryDayByPage(Page page){
		return daybillMapper.queryDayByPage(page);
		
	}
	//��ҳ��ʾbill
	public List<Bill> queryBillByPage(Page page){
		return daybillMapper.queryBillByPage(page);
		
	}
	//��ʱ����ʾdaybill
	public List<Daybill> queryDaybillByDate(Daybill daybill){
		return daybillMapper.queryDaybillByDate(daybill);
	}
	//��ѯ���е�daybill
	public List<Daybill> qureyAllDaybill(Daybill daybill){
		return daybillMapper.qureyAllDaybill(daybill);
	}
	//��ѯ���˵�
	public List<Daybill> qureyMonthbill(String string){
		return daybillMapper.qureyMonthbill(string);
	}
	//��ѯ���˵�
	public List<Daybill> qureyYearbill(String string){
		return daybillMapper.qureyYearbill(string);
	}
}
