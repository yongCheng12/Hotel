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
	
	//查询用户
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
	
	//显示用户权限
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
	
	//修改用户权限显示
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
	
	//删除用户
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
	
	//修改权限
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
	//登录
	@RequestMapping("/queryPassByName.do")
	public ModelAndView queryPassByName(User user,HttpSession session){
		 ModelAndView modelAndView = new ModelAndView();
		 String password = userService.queryPassByName(user.getName());
		 String Permissions=userService.queryPermissionsByName(user.getName());
		 System.out.println("123的"+Permissions);
		if(password == null||password.equals("")){
			String tishi="用户名不存在";
			modelAndView.addObject("tishi", tishi);
			modelAndView.setViewName("page/login.jsp");
			return modelAndView;
		}else if(user.getPassword().equals(password)){
			if(Permissions.equals("收银员")){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("page/employee.jsp");
				return modelAndView;
			}else if(Permissions.equals("财务主管")){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("page/manager.jsp");
				return modelAndView;
			}else if(Permissions.equals("管理员")){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("bgpage/main.jsp");
				return modelAndView;
			}else if(Permissions==null){
				session.setAttribute("username", user.getName());
				modelAndView.setViewName("bgpage/employee.jsp");
				return modelAndView;
			}
				
			
		}else{
			String tishi="密码错误";
			modelAndView.addObject("tishi", tishi);
			modelAndView.setViewName("page/login.jsp");
			return modelAndView;
		}
		
		
		return null;
	}
	
	//注册用户
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
				String tishi="用户名重复";
				modelAndView.addObject("tishi", tishi);
				modelAndView.setViewName("page/register.jsp");
				return modelAndView;
			}
		}else{
			String tishi="用户名不能为空";
			modelAndView.addObject("tishi", tishi);
			modelAndView.setViewName("page/register.jsp");
			return modelAndView;
		}
		
		
		return null;
	}
	
	//页面跳转首页
	@RequestMapping("/mainPage.do")
	public ModelAndView mainPage(User user){
		ModelAndView modelAndView = new ModelAndView();
		String Permissions=userService.queryPermissionsByName(user.getName());
		if(Permissions.equals("收银员")){
			modelAndView.setViewName("page/employee.jsp");
			return modelAndView;
		}else if(Permissions.equals("财务主管")){
			
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
			   // 调用 调用mysql的安装目录的命令
			   Process child = rt
			     .exec("D://mysql5//bin//mysqldump -h localhost -uroot -pmysql  webshop");
			   // 设置导出编码为utf-8。这里必须是utf-8
			   // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
			   InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
			   InputStreamReader xx = new InputStreamReader(in, "utf-8");
			   // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
			   String inStr;
			   StringBuffer sb = new StringBuffer("");
			   String outStr;
			   // 组合控制台输出信息字符串
			   BufferedReader br = new BufferedReader(xx);
			   while ((inStr = br.readLine()) != null) {
			    sb.append(inStr + "\r\n");
			   }
			   outStr = sb.toString();
			   // 要用来做导入用的sql目标文件：
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
     
            // 调用 mysql 的 cmd:      
            Process child = rt.exec("D://mysql5//bin//mysql.exe -uroot -pmysql abc ");      
            OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流      
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
            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免      
            writer.flush();      
            // 别忘记关闭输入输出流      
            out.close();      
            br.close();      
            writer.close();      
     
            System.out.println("");      
     
        } catch (Exception e) {      
            e.printStackTrace();      
        }      
     
    } 
	//没完成
	@RequestMapping("/formdateBeifen.do")
	public void formdate(MultipartHttpServletRequest request,Path path){
		try {
			
			//获取<input type="file" />标签的文件
			//List<MultipartFile> fileList = request.getFiles("rpath");
			//System.out.println(fileList.size());
			//指定上传文件的存储路径
			String uploadPath = request.getSession().getServletContext().getRealPath("date/");
			//System.out.println(uploadPath);
			//使用文件方式创建文件夹
			//指定文件类型
			File folder = new File(uploadPath);
			if(!folder.exists()){
				//如果文件夹不存在，创建文件夹
				folder.mkdir();
			}
			System.out.println("============");
			 Runtime rt = Runtime.getRuntime();
			   // 调用 调用mysql的安装目录的命令
			   Process child = rt
			     .exec("D://mysql5//bin//mysqldump -h localhost -uroot -pmysql  webshop");
			   // 设置导出编码为utf-8。这里必须是utf-8
			   // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
			   InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
			   InputStreamReader xx = new InputStreamReader(in, "utf-8");
			   // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
			   String inStr;
			   StringBuffer sb = new StringBuffer("");
			   String outStr;
			   // 组合控制台输出信息字符串
			   BufferedReader br = new BufferedReader(xx);
			   while ((inStr = br.readLine()) != null) {
			    sb.append(inStr + "\r\n");
			   }
			   outStr = sb.toString();
			   // 要用来做导入用的sql目标文件：
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
	//也没完成
	@RequestMapping("/formbackdateBeifen.do")
	public void formbackdate(MultipartHttpServletRequest request,Path path){
		try {
			String uploadPath = request.getSession().getServletContext().getRealPath("date/");
			 String fPath = uploadPath+"/Hotel_1.sql";    
	            Runtime rt = Runtime.getRuntime();      
	     
	            // 调用 mysql 的 cmd:      
	            Process child = rt.exec("D://mysql5//bin//mysql.exe -uroot -pmysql "+path.getName()+" ");      
	            OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流      
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
	            // 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免      
	            writer.flush();      
	            // 别忘记关闭输入输出流      
	            out.close();      
	            br.close();      
	            writer.close();      
	     
	            System.out.println("");      
	     
			
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
		
	}
}
