package com.dao;

import com.po.Grade;
import com.po.Student;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @anther mt
 * @creater 2021-04-09 11:13
 */
public class GradeDao {


    public boolean insert(Grade grade){
        boolean f = false;

        StudentDao sd = new StudentDao();
        grade.setSname(sd.getStudentBySno(grade.getSno()).getSname());

        String sql = "insert into grade (sno,sname,cname,credit,grade) values('"+grade.getSno()+"'"
                + ",'"+grade.getSname()+"','"+grade.getCname()+"',"+grade.getCredit()+","+grade.getGrade()
                +")";

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

    public boolean deleteById (Integer id) {
        boolean f = false;
        String sql = "delete from grade where id =" + id + "";

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

    public boolean update(Integer id,Integer grade) {
        String sql = "update grade set grade = "+grade+" where id = "+id;

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

    public List<Grade> getAllByPage(){

        List<Grade> list = new ArrayList<>();
        String sql = "select * from grade";

        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next())
            {
                Grade d = new Grade();
                d.setId(rs.getInt("id"));
                d.setSno(rs.getString("sno"));
                d.setSname(rs.getString("sname"));
                d.setCname(rs.getString("cname"));
                d.setCredit(rs.getInt("credit"));
                d.setGrade(rs.getInt("grade"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        return list;
    }

    public Grade getById(Integer id) {
        Grade d = new Grade();
            String sql = "select * from grade where id="+id;

            Connection conn = DBUtil.getConn();
            Statement state = null;
            ResultSet rs = null;
            try {
                state = conn.createStatement();
                rs = state.executeQuery(sql);
                while(rs.next())
                {
                    d.setId(rs.getInt("id"));
                    d.setSno(rs.getString("sno"));
                    d.setSname(rs.getString("sname"));
                    d.setCname(rs.getString("cname"));
                    d.setCredit(rs.getInt("credit"));
                    d.setGrade(rs.getInt("grade"));
                }
                return d;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(state, conn);
            }
            return null;
    }
}
