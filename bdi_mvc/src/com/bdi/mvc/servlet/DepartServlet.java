package com.bdi.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.DepartService;
import com.bdi.mvc.service.impl.DepartServiceImpl;
import com.bdi.mvc.vo.Depart;

/**
 * Servlet implementation class DepartServlet
 */
@WebServlet("/DepartServlet")
public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartService ds = new DepartServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		response.setContentType("text/html;charset=utf-8");
		try {
			if(cmd.equals("departList")) {
				request.setAttribute("departList", ds.selectDepartList(null));
			}else if(cmd.equals("departView")||cmd.equals("departUpdate")){
				String diNoStr = request.getParameter("diNo");
				Depart depart = new Depart();
				depart.setDiNo(Integer.parseInt(diNoStr));
				request.setAttribute("depart", ds.selectDepart(depart));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			if(cmd.equals("departInsert")) {
				String diName = request.getParameter("diName");
				String diDesc = request.getParameter("diDesc");
				Depart depart = new Depart(0, diName, diDesc, 0);
				request.setAttribute("rMap", ds.insertDepart(depart));
			}else if(cmd.equals("departUpdate")){
				String diNo = request.getParameter("diNo");
				String diName = request.getParameter("diName");
				String diDesc = request.getParameter("diDesc");
				Depart depart = new Depart(Integer.parseInt(request.getParameter("diNo")), diName, diDesc, 0);
				request.setAttribute("rMap", ds.updateDepart(depart));
			}else if(cmd.equals("departDelete")) {
				Depart depart = new Depart(Integer.parseInt(request.getParameter("diNo")),null,null,0);
				request.setAttribute("rMap", ds.deleteDepart(depart));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request,response);
	}

}
