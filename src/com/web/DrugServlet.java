package com.web;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DrugDao;
import com.po.Drug;
import com.util.DateUtils;
import com.util.PagingVO;

/**
 * Servlet implementation class DrugServlet
 */
@WebServlet(name="/DrugServlet",urlPatterns="/drug")
public class DrugServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// ���ڵ�һ��
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		
		//���ݲ�ͬ�Ĳ��������ò�ͬ�ķ���
		DrugDao dd = new DrugDao();
		switch (method) {
		case "addPage":
			request.getRequestDispatcher("/jsp/drug/add.jsp").forward(request, response);
			break;
		case "add":
			add(request,response);
			break;
		case "editPage":
			Integer id = Integer.parseInt(request.getParameter("id"));
			Drug d = dd.getDrugById(id);
			request.setAttribute("drug", d);
			request.getRequestDispatcher("/jsp/drug/edit.jsp").forward(request, response);
			break;
		case "edit":
			edit(request,response);
			break;
		case "delete":
			Integer id2 = Integer.parseInt(request.getParameter("id"));
			dd.deleteById(id2);
			//�ض����б�
			response.sendRedirect("drug?method=getAll");
			break;
		case "getAll":
			getAll(request,response);
			break;
		case "findByName":
			String findByName = request.getParameter("findByName");
			List<Drug> list = dd.findByField("drugname", "%"+findByName+"%");
			request.setAttribute("nlist", list);
			request.getRequestDispatcher("/jsp/drug/showDrug.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String drugname = request.getParameter("drugname");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		String inputtime = request.getParameter("inputtime");
		String[] field1 = {"drugname","price","num","inputtime"};
		String[] field2 = {drugname,price.toString(),num.toString(),inputtime};
		DrugDao dd = new DrugDao();
		dd.update(field1, field2, id);
		//�ض����б�
		try {
			response.sendRedirect("drug?method=getAll");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//��ҳ
		String strpage = request.getParameter("page");
		Integer page = 0;
		if(strpage==null){
			page = 0;
		}else{
			page = Integer.parseInt(strpage);
		}
		 //�û�
        List<Drug> vlist = null;
        PagingVO pagingVO = new PagingVO();
        DrugDao dd = new DrugDao();
        //������ҳ��
        pagingVO.setTotalCount(dd.getCount());
        if(page==null || page==0){
            pagingVO.setToPageNo(1);
            vlist = dd.getAllByPage(1);
        }else{
            pagingVO.setToPageNo(page);
            vlist = dd.getAllByPage(page);
        }
        request.setAttribute("nlist",vlist);
        request.setAttribute("pagingVO", pagingVO);
        try {
			request.getRequestDispatcher("/jsp/drug/showDrug.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String drugname = request.getParameter("drugname");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		String inputtime = DateUtils.getCurrentTime();
		Drug d = new Drug();
		d.setDrugname(drugname);
		d.setInputtime(inputtime);
		d.setNum(num);
		d.setPrice(price);
		DrugDao dd = new DrugDao();
		dd.insert(d);
		//�ض����б�
		try {
			response.sendRedirect("drug?method=getAll");
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
