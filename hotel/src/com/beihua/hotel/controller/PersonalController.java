package com.beihua.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beihua.hotel.bean.Personal;
import com.beihua.hotel.service.PersonalService;

@Controller
public class PersonalController {
	@Autowired
	private PersonalService personalService;
	/*
	 * �޸ĸ�����Ϣ
	 */
	@RequestMapping("/updatePersonal.do")
	public ModelAndView updatePersonal(Personal personal){
		ModelAndView modelAndView = new ModelAndView();
		try {
			personalService.updatePersonal(personal);
		   
		    
			modelAndView.setViewName("queryPersonal.do");
			
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	/*
	 * �ж��Ƿ���ڱ��û�������ȥ��ѯ����������ڣ���ȥ���uname���ڲ�ѯ��
	 */
	@RequestMapping("/queryPersonal.do")
	public ModelAndView queryPersonal(Personal personal){
		ModelAndView modelAndView = new ModelAndView();
		try {
			//System.out.println("�жϽ��"+personalService.queryPersonalName(personal.getUname()));
			if(personalService.queryPersonalName(personal.getUname())){
				personalService.addPersonal(personal);
				Personal p=personalService.queryPersonal(personal);
				modelAndView.addObject("personal", p);
				modelAndView.setViewName("page/personal.jsp");
			}else{
				
				Personal p=personalService.queryPersonal(personal);
			    
				modelAndView.addObject("personal", p);
				modelAndView.setViewName("page/personal.jsp");
			}
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*@RequestMapping("/addUname.do")
	public ModelAndView addUname(Personal personal){
		ModelAndView modelAndView = new ModelAndView();
		try {
			boolean p=personalService.addPersonal(personal);
		    
			modelAndView.addObject("personal", p);
			modelAndView.setViewName("page/personal.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}*/
}
