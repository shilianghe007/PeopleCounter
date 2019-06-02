package com.whu.programmer.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whu.programmer.util.CaptchaUtil;

/*
 * 
 * ÑéÖ¤Âëservlet
 */
public class CaptchaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -267144829785540631L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String method=request.getParameter("method");
		if("loginCaptcha".equals(method)) {
			generateLoginCapcha(request, response);
			return;
		}
		response.getWriter().write("error method");
	}
	private void generateLoginCapcha(HttpServletRequest request,HttpServletResponse response) throws IOException {
		CaptchaUtil captchaUtil=new CaptchaUtil();
		String generatorVCode=captchaUtil.generatorVCode();
		request.getSession().setAttribute("loginCaptcha", generatorVCode);
		BufferedImage generatorVCodeImage = captchaUtil.generatorVCodeImage(generatorVCode, true);
		ImageIO.write(generatorVCodeImage, "gif", response.getOutputStream());
	}
}
