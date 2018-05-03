package com.yuvaraj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.twilio.sdk.TwilioRestException;
import com.yuvaraj.IdTokenVerifierAndParser;
import com.yuvaraj.RandomCode;
import com.yuvaraj.dao.EmployeeDao;
import com.yuvaraj.model.Employee;
import com.yuvaraj.model.HashGenerate;
import com.yuvaraj.model.SendMail;
import com.yuvaraj.model.SendToMobile;
@Controller
public class EmployeeController 
{
@RequestMapping("/addEmployee")
public ModelAndView addEmployee(@RequestParam("name") String name,@RequestParam("age") int age,
		@RequestParam("mnum") int mnum,
		@RequestParam("Department") String department,
		@RequestParam("address") String address,
		@RequestParam("salary") int salary,@RequestParam("admin") int admin,
		@RequestParam("email") String email,@RequestParam("password") String password)  
{
	ModelAndView mv=new ModelAndView();
      Employee emp=new Employee();
      
      EmployeeDao dao=new EmployeeDao();
      emp.setName(name);
      emp.setAge(age);
      emp.setMnum(mnum);
      emp.setDepartment(department);
      emp.setAddress(address);
      emp.setSalary(salary);
      emp.setAdmin(admin);
      emp.setEmail(email);
      HashGenerate generate=new HashGenerate();
      String hashstring= "my-salt-text"+password ;
      String hashpassword=generate.generateHash(hashstring);
      emp.setPassword(hashpassword);
      System.out.println(hashpassword);
	  if(dao.addEmployee(emp)==1) {
	
	mv.setViewName("index.jsp");
	mv.addObject("result","successfully added");
	return mv;
	  }
	  else {
			mv.setViewName("index.jsp");
			mv.addObject("result","problem occur.....not added");
			return mv;
	     }
	
}
@RequestMapping("/viewemployee")
public ModelAndView viewEmployee() {
	ModelAndView mv =new ModelAndView();
	EmployeeDao dao=new EmployeeDao();
	List<Employee> list=EmployeeDao.getAllEmployees();
	for(Employee e:list)  
        System.out.println(e.getName());  
    mv.getModelMap().put("list", list);
   mv.setViewName("employee.jsp");
    return mv;
}
@RequestMapping("/deleteemployee")
public ModelAndView deleteemployee(@RequestParam("id") int id) {
	System.out.println(id);
	ModelAndView mv =new ModelAndView();
	EmployeeDao dao=new EmployeeDao();
	if(dao.deleteemployee(id)==1)
	{  
		mv.setViewName("employee.jsp");
		mv.addObject("result","successfully deleted");
		return mv;
		
	}else {
		mv.setViewName("employee.jsp");
		mv.addObject("result"," not successfully deleted");
	return mv;
	}}
@RequestMapping("/editemployee")
public ModelAndView editEmployee(@RequestParam("id") int id,@RequestParam("mnum") int mnum,@RequestParam("department") String department,@RequestParam("salary") int salary) {
	ModelAndView mv =new ModelAndView();
	EmployeeDao dao=new EmployeeDao();
	Employee emp=new Employee();
	emp.setId(id);
	emp.setMnum(mnum);
	emp.setDepartment(department);
	emp.setSalary(salary);
	if(dao.updateemployee(emp)==1) {
		mv.setViewName("employee.jsp");
		mv.addObject("result","successfully updated");
		
		return mv;
	}
	else {
		mv.setViewName("employee.jsp");
		mv.addObject("result","not updated");
	return mv;
	}
	
}
@RequestMapping("/loginadmin")
public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password) {
	ModelAndView mv=new ModelAndView();
	EmployeeDao dao=new EmployeeDao();
	 HashGenerate generate=new HashGenerate();
	 String hashstring="my-salt-text"+password;
	 String hashpassword=generate.generateHash(hashstring);
	 System.out.println(hashpassword);
	int a=dao.login(username, hashpassword);
	if(a==1) {
		
		mv.setViewName("index.jsp");
		mv.addObject("result","login successfully");
		return mv;
	}else if(a==2) {
		mv.setViewName("admin.jsp");
		mv.addObject("result","your not authourised person to login in administrator");
		return mv;
	}else {
		mv.setViewName("admin.jsp");
		mv.addObject("result","password is worng or please try again later");
		return mv;
	}
	
}
@RequestMapping("/forgotpassword")
public ModelAndView forgot(@RequestParam("username") String email,@RequestParam("password") String password,@RequestParam("code") String code) {
	ModelAndView mv=new ModelAndView();
	EmployeeDao dao=new EmployeeDao();
	 HashGenerate generate=new HashGenerate();
	 String hashstring="my-salt-text"+password;
	 String hashpassword=generate.generateHash(hashstring);
	
	if(dao.updatePassword(email, hashpassword,code)==1) {
		mv.setViewName("admin.jsp");
		mv.addObject("result","password has been successfully changed");
		return mv;
	}else if (dao.validatingUser(email)==2){
		mv.setViewName("forgotpassword.jsp");
		mv.addObject("result","email id is not a registered one");
		return mv;
	}else {
		mv.setViewName("forgotpassword.jsp");
		mv.addObject("result","your secret code or mail id is wrong or please try again later");
		return mv;
	}
	
}
@RequestMapping("/code")
public ModelAndView codeGenerator(@RequestParam("email") String email) throws TwilioRestException  {
	SendToMobile mobile=new SendToMobile();
	ModelAndView mv=new ModelAndView();
	EmployeeDao dao=new EmployeeDao();
	RandomCode code=new RandomCode();
	String code1=code.generateRandomCode();
	
	if(dao.validatingUser(email)==2) {
		mv.setViewName("forgot.jsp");
		mv.addObject("result","Email id is not a registered one,please contact admin:");
		return mv;
	}else if(dao.updateCode(email, code1)==1) {
		SendMail mail=new SendMail();
		mobile.sendSms(code1);
		mail.send("syuvraj*@gmail.com","secret code", code1);
		
		mv.setViewName("forgotpassword.jsp");
		mv.addObject("result","secret code has been sent to your email id,please copy that code and enter here:");
		return mv;
	}else {
		mv.setViewName("forgot.jsp");
		mv.addObject("result", "try again later");
		return mv;
	}
	
	
}
@RequestMapping("/gmailLogin")
public ModelAndView gmailLogin(@RequestParam("id_token") String idToken) 
{
	try {
	 GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
	 String name = (String) payLoad.get("name");
	 String email=payLoad.getEmail();
System.out.println(payLoad.get("profile"))      ;
	 ModelAndView mv=new ModelAndView();
	 mv.setViewName("index.jsp");
	 mv.addObject("result",email);
	 return mv;
	}catch(Exception e) {
		 throw new RuntimeException(e);
		 
	}
}
}











