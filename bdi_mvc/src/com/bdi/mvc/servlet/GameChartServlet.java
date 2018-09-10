package com.bdi.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.GameChartService;
import com.bdi.mvc.service.impl.GameChartServiceImpl;
import com.bdi.mvc.vo.GameChart;

/**
 * Servlet implementation class GameChaerServlet
 */
@WebServlet("/GameChaerServlet")
public class GameChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameChartService gcs = new GameChartServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		try {
			if(cmd.equals("gamechartList")) {
				request.setAttribute("gamechart", gcs.GameChartList());
			}else if(cmd.equals("gamechartView") || cmd.equals("gamechartUpdate")){
				request.setAttribute("gamechart", gcs.GameChartView(Integer.parseInt(request.getParameter("gcNum"))));
			}else if(cmd.equals("gamechartDelete")) {
				int gcNum = Integer.parseInt(request.getParameter("gcNum"));
				request.setAttribute("msg", gcs.GameChartDelete(gcNum));
				uri = "/views" + "/gamechart/gamechartView";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		String gcName = request.getParameter("게임이름");
		String gcPrice = request.getParameter("게임가격");
		String gcVendor = request.getParameter("게임제작사");
		String gcOrder = request.getParameter("게임수량");
		String gcDesc = request.getParameter("게임설명");
		String gcImg = request.getParameter("게임로고");
		try {
			if(cmd.equals("gamechartInsert")) {
				GameChart gc = new GameChart(
						null,
						gcName,
						Integer.parseInt(gcPrice),
						gcVendor,
						Integer.parseInt(gcOrder),
						gcDesc,
						gcImg
						);
				request.setAttribute("msg", gcs.GameChartInsert(gc));
			}else if(cmd.equals("gamechartUpdate")){
				int gcNum = Integer.parseInt(request.getParameter("게임숫자"));
				GameChart gc = new GameChart(
						gcNum,
						gcName,
						Integer.parseInt(gcPrice),
						gcVendor,
						Integer.parseInt(gcOrder),
						gcDesc,
						gcImg
						);
				request.setAttribute("msg", gcs.GameChartUpdate(gc));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
