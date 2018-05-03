package com.yuvaraj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yuvaraj.model.Employee;
import com.yuvaraj.model.HashGenerate;

public class EmployeeDao {
	HashGenerate generate=new HashGenerate();
 public int addEmployee(Employee emp) {
	 try {
		 String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://localhost/test";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "root", "");
		    
		    String query = " insert into employee1 (name, age,m_num,department,address,salary,admin,email,password)"
		            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement preparedStatement=conn.prepareStatement(query);
		    preparedStatement.setString(1,emp.getName());
		    preparedStatement.setInt(2,emp.getAge());
		    preparedStatement.setInt(3, emp.getMnum());
		    preparedStatement.setString(4, emp.getDepartment());
		    preparedStatement.setString(5, emp.getAddress());
		    preparedStatement.setInt(6,emp.getSalary());
		    preparedStatement.setInt(7,emp.getAdmin());
		    preparedStatement.setString(8, emp.getEmail());
		    preparedStatement.setString(9, emp.getPassword());
		    preparedStatement.execute();
		    conn.close();
		    return 1;
	 }catch(Exception e){
		 System.out.println(e);
		 return 0;
	 }
 }
 public static List<Employee> getAllEmployees(){  
     List<Employee> list=new ArrayList<Employee>();  
       
     try{  
    	 String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://localhost/test";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "root", "");
         PreparedStatement ps=conn.prepareStatement("select * from employee1");  
         ResultSet rs=ps.executeQuery();  
         while(rs.next()){  
             Employee e=new Employee(); 
             e.setId(rs.getInt(1));
             e.setName(rs.getString(2));  
             e.setAge(rs.getInt(3));  
             e.setMnum(rs.getInt(4));  
             e.setDepartment(rs.getString(5));  
             e.setAddress(rs.getString(6));
             e.setSalary(rs.getInt(7));
             list.add(e); 
             System.out.println(list);
         }  
         conn.close();  
     }catch(Exception e)
     {
    	 e.printStackTrace();
     }  
     for(Employee e:list)  
         System.out.println(e.getName());
     return list;  
 }  
 public int updateemployee(Employee emp) {
	 try {
		 String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://localhost/test";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "root", "");
		    String query = "update employee1 set m_num="  +    "\"" +emp.getMnum()+ "\"" 
		                +",department="+ "\"" +emp.getMnum()+ "\"" + ",salary= "+"\"" +emp.getSalary()+ "\""
		                +"where id ="+ "\"" +emp.getId()+ "\"";
		    PreparedStatement preparedStatement=conn.prepareStatement(query);
		    preparedStatement.execute();
		    return 1;
	 }catch(Exception e) {
		 e.printStackTrace();
		 return 0;
	 }
 }
 public int deleteemployee(int id) {
	 try {
		 String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://localhost/test";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "root", "");
      String query="delete from employee1 where id="+id; 
      PreparedStatement preparedStatement=conn.prepareStatement(query);
   //  preparedStatement.setInt(1, id);
      preparedStatement.execute();
	    conn.close();
	    return 1;
	 }catch(Exception e) {
		 System.out.println(e);
		 return 0;
	 }
 }
 public int login(String username,String password) {
	  try {
		  String myDriver = "org.gjt.mm.mysql.Driver";
		   String myUrl = "jdbc:mysql://localhost/test";
		   Class.forName(myDriver);
		   Connection conn = DriverManager.getConnection(myUrl, "root", "");
		   String query="select email,password,admin from employee1 where email="+ "\"" +username+ "\"" ;
		   Statement st = conn.createStatement();
		   ResultSet rs = st.executeQuery(query);
		   while(rs.next()) {
			   String email=rs.getString("email");
			   String pass=rs.getString("password");
			  
			 
			   int admin=rs.getInt("admin");
			  
			   if(email.equals(username) & pass.equals(password)) {
				   if(admin==1) {
					   return 1;
				   }else {
					   return 2;
				   }
				   
			   }else{
				   return 0;
			   }
		   }
		   conn.close();
		     return 0;
	  }catch(Exception e) {
		  return 0;
	  }
	}
 public int updatePassword( String username, String password,String code) {
	 try {
		 int val = 0;
		 String dcode = null;
		 String myDriver = "org.gjt.mm.mysql.Driver";
		   String myUrl = "jdbc:mysql://localhost/test";
		   Class.forName(myDriver);
		   Connection conn = DriverManager.getConnection(myUrl, "root", "");
		   String query="select count(email),code from employee1 where email="+"\"" +username+ "\"";
		   PreparedStatement preparedStatement=conn.prepareStatement(query);
		  ResultSet rs= preparedStatement.executeQuery(query);
		 while(rs.next()) {
			 val=rs.getInt(1);
			  dcode=rs.getString(2);
			 System.out.println(val);
		 }
		   if(val>0 & dcode.equals(code)) {
			   String sql="update employee1 set password="+"\"" +password+ "\"" +"where email="+"\"" +username+ "\"";
			   preparedStatement.execute(sql);
			   return 1;
		   }else {
			   
			   return 0;
		   }
		   
	 }catch(Exception e) {
		 return 0;
	 }
 }
 public int updateCode(String email,String code) {
	 try {
		 String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://localhost/test";
		    Class.forName(myDriver);
		    Connection conn = DriverManager.getConnection(myUrl, "root", "");
            String query="update employee1 set code="+ "\"" +code+ "\"" +"where email="+ "\"" +email+ "\"";  
		    PreparedStatement preparedStatement=conn.prepareStatement(query);
		    preparedStatement.execute();
		    return 1;
	 }catch(Exception e) {
		 e.printStackTrace();
		 return 0;
	 }
 
	
 }
 public int validatingUser(String email) {
	 try {
		 int val = 0;
		 String myDriver = "org.gjt.mm.mysql.Driver";
		   String myUrl = "jdbc:mysql://localhost/test";
		   Class.forName(myDriver);
		   Connection conn = DriverManager.getConnection(myUrl, "root", "");
		   String query="select count(email) from employee1 where email="+"\"" +email+ "\"";
		   PreparedStatement preparedStatement=conn.prepareStatement(query);
		  ResultSet rs= preparedStatement.executeQuery(query);
		 while(rs.next()) {
			 val=rs.getInt(1);
			 System.out.println(val);
		 }
		   if(val==0) {
			   return 2;
		   }else {
			   return 0;
		   }
 }catch(Exception e) {
	 return 0;
 }
 }
 private JdbcTemplate jdbcTemplate ;

 public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
 {
     this.jdbcTemplate = jdbcTemplate;
 }
 public void setDataSource(DataSource dataSource) {
	 }

 public int deletEmployee(int id) {
	
	
	String sql = "delete from employee1 where id="+id;
	jdbcTemplate.update(sql);
	 return 1;
 }
}
