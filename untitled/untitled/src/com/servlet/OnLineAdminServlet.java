package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.model.Admin;

/**
 * Servlet implementation class OnLineAdminServlet
 */
@WebServlet("/onLineAdminServlet")
public class OnLineAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnLineAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext application = request.getServletContext();
		
		Map<String,HttpSession> map = (Map<String,HttpSession>)application.getAttribute("onlineAdmins");
		Collection<HttpSession> values = map.values();
		List<Admin> list = new ArrayList<Admin>();
		for(HttpSession session:values) {
			Admin admin = (Admin)session.getAttribute("admin");
			list.add(admin);
		}
		JSONObject jobject = new JSONObject();
		jobject.put("code", 0);//0����ɹ�
		jobject.put("msg", "");
		jobject.put("count",list.size());//�ܼ�¼��
		jobject.put("data",list);//��ǰҳ�����ݼ�¼
		System.out.println(JSON.toJSONString(jobject));
		response.getWriter().println(JSON.toJSONString(jobject));
	}

}
