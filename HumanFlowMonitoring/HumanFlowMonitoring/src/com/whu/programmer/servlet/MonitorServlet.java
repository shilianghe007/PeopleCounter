package com.whu.programmer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author �ܺ���
 *�����Ϣ����ʵ��
 */
public class MonitorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3983531337847962884L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String method=request.getParameter("method");
		if("toMonitorListView".equals(method)) {
			MonitorList(request,response);
		}
	}
	
	private void MonitorList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO �Զ����ɵķ������
		try {
			request.getRequestDispatcher("view/monitorList.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
