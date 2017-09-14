package com.beihua.hotel.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beihua.hotel.bean.Bill;
import com.beihua.hotel.bean.Daybill;

import com.beihua.hotel.service.BillService;

@Controller
public class BillController {
	@Autowired
	private BillService billService;
	//将未结算的信息添加到bill中
	@RequestMapping("/addBill.do")
	public ModelAndView addBill(Bill bill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			bill.setState("未结算");
			//System.out.println(bill.getUname());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d HH:mm:ss");//设置日期格式
			//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			bill.setTime(df.format(new Date()));
			int t=Integer.parseInt(bill.getOther())+Integer.parseInt(bill.getR_money());
			//System.out.println(t);
			String totle=Integer.toString(t);
			bill.setTotle(totle);
			billService.addBill(bill);
			modelAndView.setViewName("page/manager.jsp");
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	//结算并将账单添加到bill中并显示消费信息
	@RequestMapping("/addsettlement.do")
	public ModelAndView addsettlement(Bill bill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			String time=df.format(new Date());
			if(bill.getRoomcode()!=""&&bill.getRoomcode()!=null){
				bill.setTime(time);
				Double t=Double.parseDouble(bill.getOther())+Double.parseDouble(bill.getR_money())+Double.parseDouble(bill.getFoodbeverage());
				String totle=Double.toString(t);
				bill.setTotle(totle);
				//添加到bill
				billService.addBill(bill);
				//查询bill中idcard=bill.getIdcard
				List<Bill> blist=billService.queryPersonalBill(bill);
				for(int i=0;i<blist.size();i++){
					if(blist.get(i).getState().equals("已结算")){
						if(blist.get(i).getTime().equals(time)){
							modelAndView.addObject("bill",blist.get(i));
							modelAndView.setViewName("page/bill.jsp");
							return modelAndView;
						}
					}else{
						modelAndView.setViewName("page/manager.jsp");
						return modelAndView;
					}
					
				}
				
			}else{
				String tishi="请选择房间";
				modelAndView.addObject("tishi",tishi);
				modelAndView.setViewName("page/consumer.jsp");
				return modelAndView;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//将用户结算
	@RequestMapping("/updateState.do")
	public ModelAndView updateState(Bill bill,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<Bill> blist=billService.queryPersonalBill(bill);
			if(blist.size()==0){
				String billState="你输入的房间号不存在";
				modelAndView.addObject("billState",billState);
				modelAndView.setViewName("page/settement.jsp");
				return modelAndView;
			}else{
				if(bill.getRoomcode()!=""&&bill.getRoomcode()!=null){
					for(int j=0;j<blist.size();j++){
						if(blist.get(j).getState().equals("未结算")){
							bill.setState("已结算");
							billService.updateState(bill);
							Bill tlist=billService.queryPersonalByTime(blist.get(j).getTime());
							modelAndView.addObject("bill",tlist);
							modelAndView.setViewName("page/settement.jsp");
							return modelAndView;
						}else{
                        /*问题：有逻辑问题
                         * 改成重定向							
                         */
							String billState="你的订单已结算";
							modelAndView.addObject("billState",billState);
							modelAndView.setViewName("page/settement.jsp");
							//response.sendRedirect("page/settement.jsp?billState="+billState);
						}
						
					}
				}else{
					String billState="请选择要计算的房间";
					modelAndView.addObject("billState",billState);
					modelAndView.setViewName("page/settement.jsp");
					return modelAndView;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	//查询消费信息
	@RequestMapping("/showinfo.do")
	public ModelAndView queryPersonalInfo(Bill bill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			System.out.println("showinfo.do里面");
			if(bill.getCustomer()!=""&&bill.getIdcard()!=null){
				List<Bill> bList=billService.queryPersonalInfo(bill);
				if(bList.size()>0){
					modelAndView.addObject("bList",bList);
					modelAndView.setViewName("page/showinfo.jsp");
					return modelAndView;
				}else{
					String tishi="你的信息有误请重新输入";
					modelAndView.addObject("tishi",tishi);
					modelAndView.setViewName("page/showinfo.jsp");
					return modelAndView;
				}
			}else{
				String tishi="姓名和身份证不能为空";
				modelAndView.addObject("tishi",tishi);
				modelAndView.setViewName("page/showinfo.jsp");
				return modelAndView;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//每日结账的实现
	@RequestMapping("/dayBill.do")
	public ModelAndView dayBill(Bill bill,Daybill daybill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");//设置日期格式
			//将时间存入
			daybill.setTime(df.format(new Date()));
			List<Daybill> dlist=billService.queryDayBill(daybill);
			if(dlist.size()>0){
				/*
				 * 每次进入每日记账自动计算数据库里面的消费数据，第一次进入添加记录
				 * 以后进入都是及时根据怎么加的数据去修改
				 */
				//每日房费总合
				List<Bill> blist=billService.dayBill(df.format(new Date()));
				String d_r_money=bill.dayroom(blist);
				daybill.setD_r_money(d_r_money);
				//每日餐饮总合
				String d_foodbeverage=bill.dayfoodbeverage(blist);
				daybill.setD_foodbeverage(d_foodbeverage);
				//每日其他总合
				String d_other=bill.dayother(blist);
				daybill.setD_other(d_other);
				//每日总计总合
				String d_totle=bill.daytotle(blist);
				daybill.setD_totle(d_totle);
				billService.updateDaybill(daybill);
				List<Daybill> newdlist=billService.queryDayBill(daybill);
				modelAndView.addObject("dlist", newdlist.get(0));
				modelAndView.setViewName("page/dayaccount.jsp");
				return modelAndView;
			}else{
				
				//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
				//bill.setTime(df.format(new Date()));
				List<Bill> blist=billService.dayBill(df.format(new Date()));
				//每日房费总合
				String d_r_money=bill.dayroom(blist);
				daybill.setD_r_money(d_r_money);
				//每日餐饮总合
				String d_foodbeverage=bill.dayfoodbeverage(blist);
				daybill.setD_foodbeverage(d_foodbeverage);
				//每日其他总合
				String d_other=bill.dayother(blist);
				daybill.setD_other(d_other);
				//每日总计总合
				String d_totle=bill.daytotle(blist);
				daybill.setD_totle(d_totle);
				
				//存入daybill
				billService.addDayBill(daybill);
				//List<Daybill> dlist=billService.queryDayBill(daybill);
				//modelAndView.addObject("dlist", dlist);
				modelAndView.setViewName("page/dayaccount.jsp");
				return modelAndView;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//每日消费详细情况
	@RequestMapping("/dayBillInfo.do")
	public ModelAndView dayBill(String time){
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			List<Bill> bList=billService.dayBill(time);
			modelAndView.addObject("bList", bList);
			modelAndView.setViewName("page/daybillinfo.jsp");
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}
