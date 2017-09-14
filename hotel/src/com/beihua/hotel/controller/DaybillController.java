package com.beihua.hotel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.beihua.hotel.bean.Bill;
import com.beihua.hotel.bean.Daybill;
import com.beihua.hotel.bean.MonthBill;
import com.beihua.hotel.bean.Page;
import com.beihua.hotel.bean.YearBill;
import com.beihua.hotel.service.DaybillService;

@Controller
public class DaybillController {
	@Autowired
	private DaybillService daybillService;

	@RequestMapping("/updateDaybill.do")
	public ModelAndView updateDaybill(Daybill daybill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			daybillService.updateDaybill(daybill);
			
			
			modelAndView.setViewName("page/manager.jsp");
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//分页显示每天的账单
	@RequestMapping("/queryDayByPage.do")
	public ModelAndView queryProvince(Daybill daybill,Page page){
		ModelAndView modelAndView = new ModelAndView();
		try {
			/*
			 * 计算各项总收入以及全部综合收入
			 */
			List<Daybill> allDayList =  daybillService.qureyAllDaybill(daybill);
			System.out.println(allDayList.size());
			String alld_r_money=daybill.dayroom(allDayList);
			modelAndView.addObject("alld_r_money", alld_r_money);
			String alld_foodbeverage=daybill.dayfoodbeverage(allDayList);
			modelAndView.addObject("alld_foodbeverage", alld_foodbeverage);
			String alld_other=daybill.dayother(allDayList);
			modelAndView.addObject("alld_other", alld_other);
			String alld_totle=daybill.daytotle(allDayList);
			modelAndView.addObject("alld_totle", alld_totle);
			
			//计算起始位置
			//System.out.println("xiayiye"+page.getTime());
			page.calculatePosition();
			//daybillService.queryDayByPage(page);
			List<Daybill> pList =  daybillService.queryDayByPage(page);
			modelAndView.addObject("page", page);
			modelAndView.addObject("dList", pList);
			modelAndView.setViewName("page/querytotal.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("/pageUp.do")
	public String pageUp(int nowPage,Page page){
		//页面-1
		//page.pageUp(nowPage);
		nowPage = nowPage <=1 ? 1 : nowPage - 1;
		//page.setNowPage(nowPage);
		return "queryDayByPage.do?nowPage="+nowPage;
	}
	
	
	
	@RequestMapping("/pageDown.do")
	public String pageDown(int nowPage,Page page){
		//页面+1
		nowPage = nowPage +1;
		//page.setNowPage(nowPage);
		//System.out.println("xiayiye"+nowPage);
		//page.pageDown(nowPage);
		return "queryDayByPage.do?nowPage="+nowPage;
		
	}
	//bill分页
	/*
	 * 难点：在下一页是丢失日期，最后在daybillinfo.jsp页面进pageDown.do把日期拼接进去实现了下一页
	 * 绑定参数是在bean中有共同属性，页面汇报400
	 * 或者是页面上有的属性在bean中没有，就会报页面400
	 */
	@RequestMapping("/queryBillByPage.do")
	public ModelAndView queryBillByPage(Daybill daybill, Page page){
		ModelAndView modelAndView = new ModelAndView();
		try {
			//page.setdTime(dTime);
			//计算起始位置
			page.calculatePosition();
			//daybillService.queryBillByPage(page);
			List<Bill> bList =  daybillService.queryBillByPage(page);
			modelAndView.addObject("page", page);
			modelAndView.addObject("bList", bList);
			modelAndView.setViewName("page/daybillinfo.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("/billPageUp.do")
	public String billPageUp(int nowPage,Page page){
		//页面-1
		//page.pageUp(nowPage);
		System.out.println("这是billPageUp"+nowPage);
		nowPage = nowPage <=1 ? 1 : nowPage - 1;
		//page.setNowPage(nowPage);
		return "queryBillByPage.do?nowPage="+nowPage;
	}
	
	
	
	@RequestMapping("/billPageDown.do")
	public String billPageDown(int nowPage,Page page){
		//页面+1
		nowPage = nowPage +1;
		//page.setNowPage(nowPage);
		System.out.println("这是billPageDown"+nowPage);
		//page.pageDown(nowPage);
		return "queryBillByPage.do?nowPage="+nowPage;
		
	}
	//通过时间查询daybillh账单
	@RequestMapping("/queryDaybillByDate.do")
	public ModelAndView queryDaybillByDate(Daybill daybill,Page page){
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<Daybill> allDayList =  daybillService.qureyAllDaybill(daybill);
			System.out.println(allDayList.size());
			String alld_r_money=daybill.dayroom(allDayList);
			modelAndView.addObject("alld_r_money", alld_r_money);
			String alld_foodbeverage=daybill.dayfoodbeverage(allDayList);
			modelAndView.addObject("alld_foodbeverage", alld_foodbeverage);
			String alld_other=daybill.dayother(allDayList);
			modelAndView.addObject("alld_other", alld_other);
			String alld_totle=daybill.daytotle(allDayList);
			modelAndView.addObject("alld_totle", alld_totle);
			//System.out.println("==============="+daybill.getTime());
			List<Daybill> dList =  daybillService.queryDaybillByDate(daybill);
			modelAndView.addObject("page", page);
			modelAndView.addObject("dList", dList);
			modelAndView.setViewName("page/querytotal.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//报表打印
	@RequestMapping("/printlist.do")
	public ModelAndView printList(Daybill daybill,MonthBill monthBill,YearBill yearBill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");//设置日期格式
			SimpleDateFormat dm = new SimpleDateFormat("yyyy-M");//设置日期格式
			SimpleDateFormat dy = new SimpleDateFormat("yyyy");//设置日期格式
			//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			String Time=df.format(new Date());
			//System.out.println("时间"+Time);
			String month=dm.format(new Date());
			String[] lm=month.split("-");
			int  bmonth=Integer.parseInt(lm[1]);
			if(bmonth>1){
				bmonth=bmonth-1;
			}else{
				bmonth=1;
			}
			String beformonth=lm[0]+"-"+Integer.toString(bmonth);
			System.out.println(beformonth);
			//System.out.println("时间"+month);
			/*String last=month-1;
			System.out.println("上月"+month-1);*/
			String year=dy.format(new Date());
			//System.out.println("时间"+year);
			daybill.setTime(Time);
			/*
			 * 日收入
			 */
			List<Daybill> dayList =daybillService.queryDaybillByDate(daybill);
			Daybill dbill=dayList.get(0);
			//System.out.println(dayList.get(0).getD_r_money());
			//List<Daybill> bList =  daybillService.qureyAllDaybill(daybill);
			/*
			 * 查询月收入
			 */
			List<Daybill> mList =daybillService.qureyMonthbill(month);
			monthBill.Monthroom(mList);
			monthBill.Monthfoodbeverage(mList);
			monthBill.Monthother(mList);
			monthBill.Monthtotle(mList);
			monthBill.Monthrealtotle(mList);
			monthBill.Monthspending(mList);
			/*
			 * 上月的收入
			 */
			List<Daybill> beforList =daybillService.qureyMonthbill(beformonth);
			monthBill.Lmonthroom(beforList);
			monthBill.Lmonthfoodbeverage(beforList);
			monthBill.Lmonthother(beforList);
			monthBill.Lmonthtotle(beforList);
			monthBill.Lmonthrealtotle(beforList);
			monthBill.Lmonthspending(beforList);
			
			
			/*
			 * 年收入
			 */
			List<Daybill> yList =daybillService.qureyYearbill(year);
			yearBill.Yearroom(yList);
			yearBill.Yearfoodbeverage(yList);
			yearBill.Yearother(yList);
			yearBill.Yeartotle(yList);
			yearBill.Yearrealtotle(yList);
			yearBill.Yearspending(yList);
			modelAndView.addObject("Time", Time);
			modelAndView.addObject("dbill", dbill);
			modelAndView.addObject("monthBill", monthBill);
			modelAndView.addObject("yearBill", yearBill);
			modelAndView.setViewName("page/printlist.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
