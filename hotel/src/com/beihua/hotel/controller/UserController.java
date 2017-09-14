package com.beihua.hotel.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.beihua.hotel.bean.Path;
import com.beihua.hotel.bean.User;
import com.beihua.hotel.service.UserService;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//��ѯ�û�
	@RequestMapping("/showUser.do")
	public ModelAndView selectUser(){
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			List<User> uList =userService.showUser();
			modelAndView.addObject("uList", uList);
			modelAndView.setViewName("bgpage/showUser.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//��ʾ�û�Ȩ��
	@RequestMapping("/queryUserById.do")
	public ModelAndView queryUserById(User user){
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			User use =userService.queryUserById(user);
			modelAndView.addObject("user", use);
			modelAndView.setViewName("bgpage/permissions.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//�޸��û�Ȩ����ʾ
	@RequestMapping("/showUserUpdate.do")
	public ModelAndView selectUserUpdate(){
		ModelAndView modelAndView = new ModelAndView();
		try {
			
			List<User> uList =userService.showUserUpdate();
			modelAndView.addObject("uList", uList);
			modelAndView.setViewName("bgpage/updateUser.jsp");
			
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//ɾ���û�
	@RequestMapping("/deleteUser.do")
	public ModelAndView deleteUser(User user){
		ModelAndView modelAndView = new ModelAndView();
		try {
			userService.delectUser(user);
			modelAndView.setViewName("/showUser.do");
			
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//�޸�Ȩ��
	@RequestMapping("/updateUser.do")
	public ModelAndView updateUser(User user){
		ModelAndView modelAndView = new ModelAndView();
		try {
			userService.updateUser(user);
			modelAndView.setViewName("/showUserUpdate.do");
			
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	//��¼
	@RequestMapping("/queryPassByName.do")
	public ModelAndView queryPassByName(User user,HttpSession session){
		 ModelAndView modelAndView = new ModelAndView();
		 String password = userService.queryPassByName(user.getName());
		 String Permissions=userService.queryPermissionsByName(user.getName());
		 System.out.println("123��"+Permissions);
		if(password == null||password.equals("")){
			String tishi="�û���������";
			modelAndView.addObject("tishi", tishi);
			modelAndView.setViewName("page/login.jsp");
			return modelAndView;
		}else if(user.getPassword().equals(password)){
			if(Permissions.equals("����Ա")){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("page/employee.jsp");
				return modelAndView;
			}else if(Permissions.equals("��������")){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("page/manager.jsp");
				return modelAndView;
			}else if(Permissions.equals("����Ա")){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("bgpage/main.jsp");
				return modelAndView;
			}else if(Permissions==null){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("bgpage/employee.jsp");
				return modelAndView;
			}
				
			
		}else{
			String tishi="�������";
			modelAndView.addObject("tishi", tishi);
			modelAndView.setViewName("page/login.jsp");
			return modelAndView;
		}
		
		
		return null;
	}
	
	//ע���û�
	@RequestMapping("/rigister.do")
	public ModelAndView rigister(User user){
		ModelAndView modelAndView = new ModelAndView();
		if(user.getName()!=""&&user.getName()!=null){
			 if(userService.queryUsername(user.getName())){
			 
				 if(userService.addUsers(user)){
					modelAndView.addObject("user", user);
					modelAndView.setViewName("page/login.jsp");
					return modelAndView;
				}
			}else{
				String tishi="�û����ظ�";
				modelAndView.addObject("tishi", tishi);
				modelAndView.setViewName("page/register.jsp");
				return modelAndView;
			}
		}else{
			String tishi="�û�������Ϊ��";
			modelAndView.addObject("tishi", tishi);
			modelAndView.setViewName("page/register.jsp");
			return modelAndView;
		}
		
		
		return null;
	}
	
	//ҳ����ת��ҳ
	@RequestMapping("/mainPage.do")
	public ModelAndView mainPage(User user){
		ModelAndView modelAndView = new ModelAndView();
		String Permissions=userService.queryPermissionsByName(user.getName());
		if(Permissions.equals("����Ա")){
			modelAndView.setViewName("page/employee.jsp");
			return modelAndView;
		}else if(Permissions.equals("��������")){
			
			modelAndView.setViewName("page/manager.jsp");
			return modelAndView;
		}
		
		
		return null;
	}
	@RequestMapping("/dateBeifen.do")
	public void date(HttpServletRequest request,Path path){
		try {
			System.out.println("============");
			  Runtime rt = Runtime.getRuntime();
			   // ���� ����mysql�İ�װĿ¼������
			   Process child = rt
			     .exec("D://mysql5//bin//mysqldump -h localhost -uroot -pmysql  webshop");
			   // ���õ�������Ϊutf-8�����������utf-8
			   // �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
			   InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
			   InputStreamReader xx = new InputStreamReader(in, "utf-8");
			   // �������������Ϊutf-8�����������utf-8����������ж����������
			   String inStr;
			   StringBuffer sb = new StringBuffer("");
			   String outStr;
			   // ��Ͽ���̨�����Ϣ�ַ���
			   BufferedReader br = new BufferedReader(xx);
			   while ((inStr = br.readLine()) != null) {
			    sb.append(inStr + "\r\n");
			   }
			   outStr = sb.toString();
			   // Ҫ�����������õ�sqlĿ���ļ���
			   FileOutputStream fout = new FileOutputStream(
			     "f:/Hotel_1.sql");
			   OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
			   writer.write(outStr);
			   writer.flush();
			   in.close();
			   xx.close();
			   br.close();
			   writer.close();
			   fout.close();
			   System.out.println("");
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
		
	}
	@RequestMapping("/backBeifen.do")
	public void back(User user){
		try {      
            String fPath = "f:/Hotel_1.sql";    
            Runtime rt = Runtime.getRuntime();      
     
            // ���� mysql �� cmd:      
            Process child = rt.exec("D://mysql5//bin//mysql.exe -uroot -pmysql abc ");      
            OutputStream out = child.getOutputStream();//����̨��������Ϣ��Ϊ�����      
            String inStr;      
            StringBuffer sb = new StringBuffer("");      
            String outStr;      
            BufferedReader br = new BufferedReader(new InputStreamReader(      
                    new FileInputStream(fPath), "utf8"));      
            while ((inStr = br.readLine()) != null) {      
                sb.append(inStr + "\r\n");      
            }      
            outStr = sb.toString();      
     
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");      
            writer.write(outStr);      
            // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���      
            writer.flush();      
            // �����ǹر����������      
            out.close();      
            br.close();      
            writer.close();      
     
            System.out.println("");      
     
        } catch (Exception e) {      
            e.printStackTrace();      
        }      
     
    } 
	//û���
	@RequestMapping("/formdateBeifen.do")
	public void formdate(MultipartHttpServletRequest request,Path path){
		try {
			
			//��ȡ<input type="file" />��ǩ���ļ�
			//List<MultipartFile> fileList = request.getFiles("rpath");
			//System.out.println(fileList.size());
			//ָ���ϴ��ļ��Ĵ洢·��
			String uploadPath = request.getSession().getServletContext().getRealPath("date/");
			//System.out.println(uploadPath);
			//ʹ���ļ���ʽ�����ļ���
			//ָ���ļ�����
			File folder = new File(uploadPath);
			if(!folder.exists()){
				//����ļ��в����ڣ������ļ���
				folder.mkdir();
			}
			System.out.println("============");
			 Runtime rt = Runtime.getRuntime();
			   // ���� ����mysql�İ�װĿ¼������
			   Process child = rt
			     .exec("D://mysql5//bin//mysqldump -h localhost -uroot -pmysql  webshop");
			   // ���õ�������Ϊutf-8�����������utf-8
			   // �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
			   InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
			   InputStreamReader xx = new InputStreamReader(in, "utf-8");
			   // �������������Ϊutf-8�����������utf-8����������ж����������
			   String inStr;
			   StringBuffer sb = new StringBuffer("");
			   String outStr;
			   // ��Ͽ���̨�����Ϣ�ַ���
			   BufferedReader br = new BufferedReader(xx);
			   while ((inStr = br.readLine()) != null) {
			    sb.append(inStr + "\r\n");
			   }
			   outStr = sb.toString();
			   // Ҫ�����������õ�sqlĿ���ļ���
			   FileOutputStream fout = new FileOutputStream(
			     ""+uploadPath+"/Hotel_1.sql");
			   OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
			   writer.write(outStr);
			   writer.flush();
			   in.close();
			   xx.close();
			   br.close();
			   writer.close();
			   fout.close();
			   System.out.println("");
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
		
	}
	//Ҳû���
	@RequestMapping("/formbackdateBeifen.do")
	public void formbackdate(MultipartHttpServletRequest request,Path path){
		try {
			String uploadPath = request.getSession().getServletContext().getRealPath("date/");
			 String fPath = uploadPath+"/Hotel_1.sql";    
	            Runtime rt = Runtime.getRuntime();      
	     
	            // ���� mysql �� cmd:      
	            Process child = rt.exec("D://mysql5//bin//mysql.exe -uroot -pmysql "+path.getName()+" ");      
	            OutputStream out = child.getOutputStream();//����̨��������Ϣ��Ϊ�����      
	            String inStr;      
	            StringBuffer sb = new StringBuffer("");      
	            String outStr;      
	            BufferedReader br = new BufferedReader(new InputStreamReader(      
	                    new FileInputStream(fPath), "utf8"));      
	            while ((inStr = br.readLine()) != null) {      
	                sb.append(inStr + "\r\n");      
	            }      
	            outStr = sb.toString();      
	     
	            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");      
	            writer.write(outStr);      
	            // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���      
	            writer.flush();      
	            // �����ǹر����������      
	            out.close();      
	            br.close();      
	            writer.close();      
	     
	            System.out.println("");      
	     
			
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
		
	}
}
