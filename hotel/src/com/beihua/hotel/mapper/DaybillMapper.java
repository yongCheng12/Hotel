package com.beihua.hotel.mapper;

import java.util.List;

import com.beihua.hotel.bean.Bill;
import com.beihua.hotel.bean.Daybill;
import com.beihua.hotel.bean.Page;


public interface DaybillMapper {
	public void updateDaybill(Daybill daybill);
	public List<Daybill> queryDayByPage(Page page);
	public List<Bill> queryBillByPage(Page page);
	public List<Daybill> queryDaybillByDate(Daybill daybill);
	public List<Daybill> qureyAllDaybill(Daybill daybill);
	public List<Daybill> qureyMonthbill(String string);
	public List<Daybill> qureyYearbill(String string);
}
