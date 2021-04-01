package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.po.Drug;
import com.util.DBUtil;
import com.util.PagingVO;

public class DrugDao {

	/**
	 * ����
	 */
	public boolean insert(Drug drug){
		boolean f = false;
        String sql = "insert into drug(drugname,price,num,inputtime) values('"+drug.getDrugname()+"'"
        		+ ","+drug.getPrice()+","+drug.getNum()+",'"+drug.getInputtime()+"')";
        
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

	/**
	 * ����ͨ��id��ѯ
	 */
	public Drug getDrugById(Integer id){
		Drug d = new Drug();
	     String sql = "select * from drug where id="+id;
	     
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 d.setId(rs.getInt("id"));
	        	 d.setDrugname(rs.getString("drugname"));
	        	 d.setNum(rs.getInt("num"));
	        	 d.setPrice(rs.getDouble("price"));
	        	 d.setInputtime(rs.getString("inputtime"));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
	     return d;
	}
	
    /**
     * ɾ��
     * 
     * @return
     */
    
    public boolean deleteById (Integer id) {
        boolean f = false;
        String sql = "delete from drug where id =" + id + "";
        
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
    
    /**
     * �޸�*/
    public boolean update(String []strlist,String []strlist1,Integer id) {
        String sql = "update drug set ";
        for(int i=0;i<strlist.length;i++)
        {
            if(i!=strlist.length-1)
                sql+=strlist[i]+"='" + strlist1[i] + "',";
            else sql+=strlist[i]+"='" + strlist1[i] + "' where id=" + id + "";
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
	/**
	 * �����ֶβ�ѯ���
	 */
    public List<Drug> findByField(String field,String value){
    	List<Drug> list = new ArrayList<>();
	     String sql = "select * from drug where "+field+" like '"+value+"'";
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 Drug d = new Drug();
	        	 d.setId(rs.getInt("id"));
	        	 d.setDrugname(rs.getString("drugname"));
	        	 d.setNum(rs.getInt("num"));
	        	 d.setPrice(rs.getDouble("price"));
	        	 d.setInputtime(rs.getString("inputtime"));
	             list.add(d);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
	     return list;
    }
    /**
     * ��ҳ��������
     */
    public List<Drug> getAllByPage(int toPageNo){
    	PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
    	List<Drug> list = new ArrayList<>();
	     String sql = "select * from drug limit "+pagingVO.getTopageNo()+","+pagingVO.getPageSize();
	     
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	        	 Drug d = new Drug();
	        	 d.setId(rs.getInt("id"));
	        	 d.setDrugname(rs.getString("drugname"));
	        	 d.setNum(rs.getInt("num"));
	        	 d.setPrice(rs.getDouble("price"));
	        	 d.setInputtime(rs.getString("inputtime"));
	             list.add(d);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
    	return list;
    }
    /**
     * ���Ҹ���
     */
    public int getCount(){
		 boolean f = false;
	     String sql = "select count(*) from drug";
	     
	     Connection conn = DBUtil.getConn();
	     Statement state = null;
	     ResultSet rs = null;
	     int a = 0;
	     try {
	         state = conn.createStatement();
	         rs = state.executeQuery(sql);
	         while(rs.next())
	         {
	         //��ӡ�ľ����ܼ�¼�����Ѽ����������ֻ��һ����¼һ���ֶεı�
	                a = rs.getInt(1);
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         DBUtil.close(state, conn);
	     }
	     
	     if (a > 0) {
	         f = true;
	     }
	     return a;
    }
}
