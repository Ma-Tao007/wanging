package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.po.Drug;
import com.po.Student;
import com.util.DateUtils;

/**
 * Servlet implementation class DrugServlet
 */
@WebServlet(name="/StudentServlet",urlPatterns="/student")
public class StudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 放在第一行
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		
		//根据不同的参数，调用不同的方法
		StudentDao dd = new StudentDao();
		switch (method) {
		case "addPage":
			request.getRequestDispatcher("/jsp/student/add.jsp").forward(request, response);
			break;
		case "add":
			add(request,response);
			break;
		case "editPage":
			String sno = request.getParameter("sno");
			Student d = dd.getStudentBySno(sno);
			request.setAttribute("student", d);
			request.getRequestDispatcher("/jsp/student/edit.jsp").forward(request, response);
			break;
		case "edit":
			edit(request,response);
			break;
		case "delete":
			String sno1 = request.getParameter("sno");
			dd.getStudentBySno(sno1);
			//重定向到列表
			response.sendRedirect("student?method=getAll");
			break;
		case "getAll":
			getAll(request,response);
			break;
		default:
			break;
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		Integer age = Integer.parseInt(request.getParameter("sage"));
		String sdept = request.getParameter("sdept");
		String password = request.getParameter("password");
		String[] field1 = {"sname","ssex","age","sdept","password"};
		String[] field2 = {sname,ssex,age.toString(),sdept,password};
		StudentDao dd = new StudentDao();
		dd.update(field1, field2, sno);
		//重定向到列表
		try {
			response.sendRedirect("student/method=getAll");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//分页
        StudentDao dd = new StudentDao();
		List<Student> vlist = dd.getAllByPage();

        request.setAttribute("nlist",vlist);
        try {
			request.getRequestDispatcher("/jsp/student/showStudent.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		Integer age = Integer.parseInt(request.getParameter("sage"));
		String sdept = request.getParameter("sdept");
		String password = "111111";
		Student d = new Student(sno,sname,ssex,age,sdept,password);
		//重定向到列表
		try {
			StudentDao dd = new StudentDao();
			boolean insert = dd.insert(d);
			if(insert){
				response.sendRedirect("student?method=getAll");
			}else{
				response.getWriter().write("学号已存在");
			}
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
