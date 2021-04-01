package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name="/UserServlet",urlPatterns="/user")
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 放在第一行
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String method = request.getParameter("method");
		UserDao ud = new UserDao();
		switch (method) {
		case "login":
			//ajax请求的响应方式
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			response.getWriter().write(ud.login(username, password, request));
			break;
		case "logout":
			//ajax退出
			request.getSession().removeAttribute("userinfo");
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
