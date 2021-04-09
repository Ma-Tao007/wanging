package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GradeDao;
import com.dao.StudentDao;
import com.po.Grade;
import com.po.Student;

/**
 * Servlet implementation class DrugServlet
 */
@WebServlet(name="/GradeServlet",urlPatterns="/grade")
public class GradeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");// 放在第一行
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");

        //根据不同的参数，调用不同的方法
        GradeDao dd = new GradeDao();
        switch (method) {
            case "addPage":
                StudentDao studentDao = new StudentDao();
                List<Student> slist = studentDao.getAllByPage();
                request.setAttribute("slist", slist);
                request.getRequestDispatcher("/jsp/grade/add.jsp").forward(request, response);
                break;
            case "add":
                add(request,response);
                break;
            case "editPage":
                Integer id = Integer.parseInt(request.getParameter("id"));
                Grade d = dd.getById(id);
                request.setAttribute("grade", d);
                request.getRequestDispatcher("/jsp/grade/edit.jsp").forward(request, response);
                break;
            case "edit":
                edit(request,response);
                break;
            case "delete":
                Integer id1 = Integer.parseInt(request.getParameter("id"));
                dd.deleteById(id1);
                //重定向到列表
                response.sendRedirect("grade?method=getAll");
                break;
            case "getAll":
                getAll(request,response);
                break;
            default:
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer grade = Integer.parseInt(request.getParameter("grade"));
        GradeDao dd = new GradeDao();
        dd.update(id, grade);
        //重定向到列表
        try {
            response.sendRedirect("grade?method=getAll");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        //分页
        GradeDao dd = new GradeDao();
        List<Grade> vlist = dd.getAllByPage();

        request.setAttribute("nlist",vlist);
        try {
            request.getRequestDispatcher("/jsp/grade/showGrade.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String sno = request.getParameter("sno");
        String cname = request.getParameter("cname");
        Integer credit = Integer.parseInt(request.getParameter("credit"));
        Integer grade = Integer.parseInt(request.getParameter("grade"));
        Grade d = new Grade(null,sno,null,cname,credit,grade);
        //重定向到列表
        try {
            GradeDao dd = new GradeDao();
            boolean insert = dd.insert(d);
            response.sendRedirect("grade?method=getAll");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
