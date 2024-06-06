package com.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.model.PageBean;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/listUserServlet")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserServlet() {
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
		//����service���ؼ�¼���
		response.setContentType("text/html;charset=utf-8");
		Map<String, String[]> map = request.getParameterMap();
		
		//���Ի�ȡ����ܴ����ķ�ҳ��Ϣ page limit
		UserService user = new UserServiceImpl();
		
		PageBean pagebean = user.getNowPageUserByCondition(map);		
		
		JSONObject jobject = new JSONObject();
		jobject.put("code", 0);//0����ɹ�
		jobject.put("msg", "");
		jobject.put("count", pagebean.getTotalCount());//�ܼ�¼��
		jobject.put("data", pagebean.getList());//��ǰҳ�����ݼ�¼
		System.out.println(JSON.toJSONString(jobject));
		response.getWriter().println(JSON.toJSONString(jobject));
	}

}
