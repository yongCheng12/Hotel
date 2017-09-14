package com.beihua.hotel.mapper;

import java.util.List;

import com.beihua.hotel.bean.Bill;
import com.beihua.hotel.bean.Daybill;

public interface BillMapper {
	public void addBill(Bill bill);
    public List<Bill> queryPersonalBill(Bill bill);
    public void updateState(Bill bill);
    public Bill queryPersonalByTime(String time);
    public List<Bill> queryPersonalInfo(Bill bill);
    public List<Bill> dayBill(String time);
    public void addDayBill(Daybill daybill);
    public List<Daybill> queryDayBill(Daybill daybill);
    public void updateDaybill(Daybill daybill);
}
