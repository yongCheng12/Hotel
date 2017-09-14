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
	//��δ�������Ϣ��ӵ�bill��
	@RequestMapping("/addBill.do")
	public ModelAndView addBill(Bill bill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			bill.setState("δ����");
			//System.out.println(bill.getUname());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d HH:mm:ss");//�������ڸ�ʽ
			//System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
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
	//���㲢���˵���ӵ�bill�в���ʾ������Ϣ
	@RequestMapping("/addsettlement.do")
	public ModelAndView addsettlement(Bill bill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d HH:mm:ss");//�������ڸ�ʽ
			System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
			String time=df.format(new Date());
			if(bill.getRoomcode()!=""&&bill.getRoomcode()!=null){
				bill.setTime(time);
				Double t=Double.parseDouble(bill.getOther())+Double.parseDouble(bill.getR_money())+Double.parseDouble(bill.getFoodbeverage());
				String totle=Double.toString(t);
				bill.setTotle(totle);
				//��ӵ�bill
				billService.addBill(bill);
				//��ѯbill��idcard=bill.getIdcard
				List<Bill> blist=billService.queryPersonalBill(bill);
				for(int i=0;i<blist.size();i++){
					if(blist.get(i).getState().equals("�ѽ���")){
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
				String tishi="��ѡ�񷿼�";
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
	
	//���û�����
	@RequestMapping("/updateState.do")
	public ModelAndView updateState(Bill bill,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<Bill> blist=billService.queryPersonalBill(bill);
			if(blist.size()==0){
				String billState="������ķ���Ų�����";
				modelAndView.addObject("billState",billState);
				modelAndView.setViewName("page/settement.jsp");
				return modelAndView;
			}else{
				if(bill.getRoomcode()!=""&&bill.getRoomcode()!=null){
					for(int j=0;j<blist.size();j++){
						if(blist.get(j).getState().equals("δ����")){
							bill.setState("�ѽ���");
							billService.updateState(bill);
							Bill tlist=billService.queryPersonalByTime(blist.get(j).getTime());
							modelAndView.addObject("bill",tlist);
							modelAndView.setViewName("page/settement.jsp");
							return modelAndView;
						}else{
                        /*���⣺���߼�����
                         * �ĳ��ض���							
                         */
							String billState="��Ķ����ѽ���";
							modelAndView.addObject("billState",billState);
							modelAndView.setViewName("page/settement.jsp");
							//response.sendRedirect("page/settement.jsp?billState="+billState);
						}
						
					}
				}else{
					String billState="��ѡ��Ҫ����ķ���";
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
	//��ѯ������Ϣ
	@RequestMapping("/showinfo.do")
	public ModelAndView queryPersonalInfo(Bill bill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			System.out.println("showinfo.do����");
			if(bill.getCustomer()!=""&&bill.getIdcard()!=null){
				List<Bill> bList=billService.queryPersonalInfo(bill);
				if(bList.size()>0){
					modelAndView.addObject("bList",bList);
					modelAndView.setViewName("page/showinfo.jsp");
					return modelAndView;
				}else{
					String tishi="�����Ϣ��������������";
					modelAndView.addObject("tishi",tishi);
					modelAndView.setViewName("page/showinfo.jsp");
					return modelAndView;
				}
			}else{
				String tishi="���������֤����Ϊ��";
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
	
	//ÿ�ս��˵�ʵ��
	@RequestMapping("/dayBill.do")
	public ModelAndView dayBill(Bill bill,Daybill daybill){
		ModelAndView modelAndView = new ModelAndView();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");//�������ڸ�ʽ
			//��ʱ�����
			daybill.setTime(df.format(new Date()));
			List<Daybill> dlist=billService.queryDayBill(daybill);
			if(dlist.size()>0){
				/*
				 * ÿ�ν���ÿ�ռ����Զ��������ݿ�������������ݣ���һ�ν�����Ӽ�¼
				 * �Ժ���붼�Ǽ�ʱ������ô�ӵ�����ȥ�޸�
				 */
				//ÿ�շ����ܺ�
				List<Bill> blist=billService.dayBill(df.format(new Date()));
				String d_r_money=bill.dayroom(blist);
				daybill.setD_r_money(d_r_money);
				//ÿ�ղ����ܺ�
				String d_foodbeverage=bill.dayfoodbeverage(blist);
				daybill.setD_foodbeverage(d_foodbeverage);
				//ÿ�������ܺ�
				String d_other=bill.dayother(blist);
				daybill.setD_other(d_other);
				//ÿ���ܼ��ܺ�
				String d_totle=bill.daytotle(blist);
				daybill.setD_totle(d_totle);
				billService.updateDaybill(daybill);
				List<Daybill> newdlist=billService.queryDayBill(daybill);
				modelAndView.addObject("dlist", newdlist.get(0));
				modelAndView.setViewName("page/dayaccount.jsp");
				return modelAndView;
			}else{
				
				//System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
				//bill.setTime(df.format(new Date()));
				List<Bill> blist=billService.dayBill(df.format(new Date()));
				//ÿ�շ����ܺ�
				String d_r_money=bill.dayroom(blist);
				daybill.setD_r_money(d_r_money);
				//ÿ�ղ����ܺ�
				String d_foodbeverage=bill.dayfoodbeverage(blist);
				daybill.setD_foodbeverage(d_foodbeverage);
				//ÿ�������ܺ�
				String d_other=bill.dayother(blist);
				daybill.setD_other(d_other);
				//ÿ���ܼ��ܺ�
				String d_totle=bill.daytotle(blist);
				daybill.setD_totle(d_totle);
				
				//����daybill
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
	
	//ÿ��������ϸ���
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
