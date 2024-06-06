package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DelUserServlet
 */
@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String parameter;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUserServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		UserService userv = new UserServiceImpl();
		boolean flag = userv.delUserById(id);
		JSONObject jobject = new JSONObject();		
		if(flag) {
			jobject.put("code", 0);//0�ɹ�
			jobject.put("msg", "ɾ���ɹ�");
		}else {
			jobject.put("code", 1);
			jobject.put("msg", "ɾ��ʧ��");
		}
		System.out.println(JSON.toJSONString(jobject));
		response.getWriter().println(JSON.toJSONString(jobject));
	}

}
