<%@page import="com.bdi.mvc.vo.Maker"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
List<Maker> makerList = new ArrayList<Maker>();
Maker m = new Maker(1,"갤5",1,1,0,"갤럭시5번째");
makerList.add(m);
makerList.add(new Maker(2,"갤4",22,2,0,"갤럭시4번째"));
makerList.add(new Maker(3,"V20",50,5,0,"브이이십"));
request.setAttribute("list",makerList);
RequestDispatcher rd = request.getRequestDispatcher("/views/maker/makerList");
rd.forward(request,response);
%>
