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
	//����û�
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
	//��ѯ����������Ϣ
	public List<Bill> queryPersonalBill(Bill bill){
		return billMapper.queryPersonalBill(bill);
	}
	
	//�û�����
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
	
	//��ѯ����������Ϣͨ��ʱ��
	public Bill queryPersonalByTime(String  time){
		return billMapper.queryPersonalByTime(time);
	}
	//��ѯ������Ϣ
	public List<Bill> queryPersonalInfo(Bill bill){
		return billMapper.queryPersonalInfo(bill);
	}
	//ÿ��������Ϣ
	 public List<Bill> dayBill(String time){
		 return billMapper.dayBill(time);
	 }
	 //����������Ϣ����daybill
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
	 //��ѯdaybill����Ϣͨ��ʱ��
	 public List<Daybill> queryDayBill(Daybill daybill){
		 return billMapper.queryDayBill(daybill);
	 }
	//�޸���������Ϣ����daybill
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
