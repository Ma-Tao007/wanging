package com.dao;

import com.po.Student;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @anther mt
 * @creater 2021-04-09 13:46
 */
public class WarnDao {
    public List<Map> getAll() {
        List<Map> result = new ArrayList<>();

        String sql = "select a1.id,a1.sno,a1.sname,ifnull(a1.s1,0) sum,ifnull(a2.s1,0) nsum from\n" +
                "(select id,sno,sname,count(id) s1 from grade GROUP BY sno) a1\n" +
                "LEFT JOIN\n" +
                "(select id,sno,sname,count(id) s1 from grade where grade<60 GROUP BY sno) a2\n" +
                "on a1.sno = a2.sno";

        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                //有数据
                Map map = new HashMap();
                map.put("sno",rs.getString("sno"));
                map.put("sname",rs.getString("sname"));
                map.put("sum",rs.getInt("sum"));
                map.put("nsum",rs.getInt("nsum"));
                result.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }
        return result;
    }
}
