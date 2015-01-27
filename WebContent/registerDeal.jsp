<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.demon.registeration.entity.*"%>
<%@page import="com.demon.registeration.service.*"%>
<%@page import="com.demon.registeration.service.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username = request.getParameter("username");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");

User u = new User();
u.setPassword(password);
u.setUsername(username);
UserManager um = new UserManagerImpl();
boolean exist = um.exists(u);
if(!exist) {
	response.sendRedirect("registerFail.jsp");
	return;
}
um.add(u);

response.sendRedirect("registerSuccess.jsp");
%>
