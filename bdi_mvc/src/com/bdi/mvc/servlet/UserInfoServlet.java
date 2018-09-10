package com.bdi.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.UserInfoService;
import com.bdi.mvc.service.impl.UserInfoServiceImpl;
import com.bdi.mvc.vo.UserInfo;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uis = new UserInfoServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		if(cmd.equals("userInfoList")) {
			request.setAttribute("list", uis.userInfoList());
		}else if(cmd.equals("userInfoView") || cmd.equals("userInfoUpdate")) {
			int num = Integer.parseInt(request.getParameter("uiNo"));
			request.setAttribute("user", uis.userInfoView(num));
		}else if(cmd.equals("userInfoDelete")) {
			int num = Integer.parseInt(request.getParameter("uiNo"));
			request.setAttribute("success", uis.userInfoDelete(num));
			uri = "/userinfo/userInfoView";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		String uiName = request.getParameter("uiName");
		String uiId = request.getParameter("uiId");
		String uiPwd = request.getParameter("uiPwd");
		String uiDesc = request.getParameter("uiDesc");
		int uiAge = Integer.parseInt(request.getParameter("uiAge"));
		int diNo = Integer.parseInt(request.getParameter("diNo"));
		if(cmd.equals("userInfoInsert")) {
			UserInfo ui = new UserInfo(0,uiName,uiId,uiPwd,uiDesc,uiAge,diNo);
			request.setAttribute("success", uis.userInfoInsert(ui));
		}else if(cmd.equals("userInfoUpdate")) {
			int uiNo = Integer.parseInt(request.getParameter("uiNo"));
			UserInfo ui = new UserInfo(uiNo,uiName,uiId,uiPwd,uiDesc,uiAge,diNo);
			request.setAttribute("success", uis.userInfoUpdate(ui));
		}

		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
