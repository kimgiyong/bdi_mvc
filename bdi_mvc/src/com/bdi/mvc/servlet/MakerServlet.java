package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.MakerService;
import com.bdi.mvc.service.impl.MakerServiceImpl;
import com.bdi.mvc.vo.Maker;

/**
 * Servlet implementation class MakerServlet
 */
@WebServlet("/MakerServlet")
public class MakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MakerService ms = new MakerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("makerList")) {
			List<Maker> makerList =  ms.getMakerList(null);
			request.setAttribute("list", makerList);
		}else if(cmd.equals("makerView") || cmd.equals("makerUpdate")) {
			String numStr = request.getParameter("mNum");
			if(numStr!=null) {
				int num = Integer.parseInt(numStr);
				Maker maker = ms.getMaker(num);
				request.setAttribute("maker", maker);
			}else {
				
			}
		}else if(cmd.equals("makerDelete")) {
			int num = Integer.parseInt(request.getParameter("mNum"));
			request.setAttribute("map", ms.deleteMaker(num));
			uri = "/maker/makerView";
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		if(cmd.equals("makerUpdate")) {
			String mNum = request.getParameter("mNum");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			String desc = request.getParameter("desc");
			Maker mk = new Maker(Integer.parseInt(mNum),name,price,cnt,0,desc);
			request.setAttribute("map",ms.updateMaker(mk));
			
		}else if(cmd.equals("makerInsert")) {
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			String desc = request.getParameter("desc");
//			Maker mk = new Maker(0,name,price,cnt,price*cnt,desc);
			Maker mk = new Maker(0,name,price,cnt,0,desc);
			request.setAttribute("map", ms.insertMaker(mk));
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
