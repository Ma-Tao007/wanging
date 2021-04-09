package com.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.WarnDao;
import com.po.Student;

/**
 * Servlet implementation class DrugServlet
 */
@WebServlet(name="/WarningServlet",urlPatterns="/warn")
public class WarnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");// 放在第一行
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");

        //根据不同的参数，调用不同的方法
        WarnDao dd = new WarnDao();
        switch (method) {
            case "getAll":
                List<Map> warn = dd.getAll();
                request.setAttribute("warn",warn);
                request.getRequestDispatcher("/jsp/warning/showWarning.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
