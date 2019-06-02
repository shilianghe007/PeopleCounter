package com.whu.programmer.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
/*
 * 
 * ��½��֤
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.whu.programmer.dao.AdminDao;
import com.whu.programmer.model.Admin;
import com.whu.programmer.util.StringUtil;

import javafx.util.converter.ShortStringConverter;
		
		
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7889364347967632309L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String method=request.getParameter("method");
		if("logout".equals(method)) {
			logout(request, response);
			return;
		}
		String vcode = request.getParameter("vcode");
		String name=request.getParameter("account");
		String password=request.getParameter("password");
		String loginCaptcha = request.getSession().getAttribute("loginCaptcha").toString();
		if(StringUtil.isEmpty(vcode)) {
		response.getWriter().write("vcodeError");
		return;
		}
		if(!vcode.toUpperCase().equals(loginCaptcha.toUpperCase())) {
			response.getWriter().write("vcodeError");
			return;
		}
		//��֤��ͨ�� �ж��û��������Ƿ���ȷ
		String loginStatus="loginFailed";
		AdminDao adminDao=new AdminDao();
		Admin admin = adminDao.login(name, password);
		adminDao.closeCon();
		if(admin==null) {
			response.getWriter().write("loginError");
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", admin);
		loginStatus = "loginSuccess";
		response.getWriter().write(loginStatus);
	}
	
	//ע����½
	private void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().removeAttribute("user");
		response.sendRedirect("index.jsp");
	}
}
