package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.listerner.LockHelper;

/**
 * Servlet implementation class DoOffLineServlet
 */
@WebServlet("/doOffLineServlet")
public class DoOffLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoOffLineServlet() {
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
		String username = request.getParameter("username");
		//System.out.println("username:"+username);
		boolean flag = false;
		flag = LockHelper.destroyedSession(username);
		JSONObject jobject = new JSONObject();
		if(flag) {			
			jobject.put("code", 0);//0����ɹ�
			jobject.put("msg", "���߳ɹ���");			
			//System.out.println(JSON.toJSONString(jobject));
			
		}else {
			jobject.put("code", 1);//0����ɹ�
			jobject.put("msg", "����ʧ�ܣ�");		
		}
		response.getWriter().println(JSON.toJSONString(jobject));
	}

}
