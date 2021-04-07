package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.po.Student;
import com.po.User;
import com.util.DBUtil;

public class UserDao {
	/**
	 * 登陆验证
	 * @param username
	 * @param password
	 * @param request 
	 * @return
	 */
	public String login(String username,String password, HttpServletRequest request,Integer type){
		//type==0 学生   1教师
		String sql = "";
		if(type==1){
			sql = "select * from user where username='"+username+"'";
		}else{
			sql = "select * from student where cno = '"+username+"'";
		}
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     User user = new User();
	     Student student = new Student();
	     Boolean flag = false;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 flag = true;
	        	 if(type==1){
					 user.setId(rs.getInt("id"));
					 user.setUsername(rs.getString("username"));
					 user.setPassword(rs.getString("password"));
				 }else{
	        	 	student.setSno(rs.getString("sno"));
	        	 	student.setPassword(rs.getString("password"));
				 }
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
	     if(!flag){
	    	 return "用户名不存在";
	     }else{
	    	 if(type==1?user.getPassword().equals(password):student.getPassword().equals(password)){
	    		 //存到session中
	    		 request.getSession().setAttribute("userinfo", type==1?user:student);
	    		 return "验证成功";
	    		 
	    	 }else{
	    		 return "密码错误";
	    	 }
	     }
	}
}
