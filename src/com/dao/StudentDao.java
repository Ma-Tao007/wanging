package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.po.Drug;
import com.po.Student;
import com.util.DBUtil;

public class StudentDao {


	public boolean insert(Student student){
		boolean f = false;
		if(getStudentBySno(student.getSno())!=null){
			return f;
		}
        String sql = "insert into student(sno,sname,ssex,sage,sdept,password) values('"+student.getSno()+"'"
        		+ ",'"+student.getSname()+"','"+student.getSex()+"',"+student.getAge()+",'"+student.getSdept()
				+"','"+student.getPassword()+"')";
        
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;
        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        if (a > 0) {
            f = true;
        }
        return f;
	}

	public Student getStudentBySno(String sno){
		Student d = new Student();
	     String sql = "select * from student where sno='"+sno+"'";
	     
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
				 d.setSno(rs.getString("sno"));
				 d.setSname(rs.getString("sname"));
				 d.setSex(rs.getString("ssex"));
				 d.setAge(rs.getInt("sage"));
				 d.setWarning(rs.getString("warning"));
				 d.setPassword(rs.getString("password"));
				 d.setSdept(rs.getString("sdept"));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
	     return d;
	}

    public boolean deleteById (String sno) {
        boolean f = false;
        String sql = "delete from student where sno =" + sno + "";
        
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;
        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        
        if (a > 0) {
            f = true;
        }
        return f;
    }

    public boolean update(String []strlist,String []strlist1,String sno) {
        String sql = "update student set ";
        for(int i=0;i<strlist.length;i++)
        {
            if(i!=strlist.length-1)
                sql+=strlist[i]+"='" + strlist1[i] + "',";
            else sql+=strlist[i]+"='" + strlist1[i] + "' where sno='" + sno + "'";
        }

        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;

        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        
        if (a > 0) {
            f = true;
        }
        return f;
    }

    public List<Student> getAllByPage(){

    	List<Student> list = new ArrayList<>();
	     String sql = "select * from student";
	     
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 Student d = new Student();
	        	 d.setSno(rs.getString("sno"));
	        	 d.setSname(rs.getString("sname"));
	        	 d.setSex(rs.getString("ssex"));
	        	 d.setAge(rs.getInt("sage"));
	        	 d.setWarning(rs.getString("warning"));
	        	 d.setPassword(rs.getString("password"));
	        	 d.setSdept(rs.getString("sdept"));
	             list.add(d);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
    	return list;
    }
}
