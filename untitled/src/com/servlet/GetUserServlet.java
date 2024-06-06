package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/getUserServlet")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserServlet() {
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
		String id = request.getParameter("id");
		//System.out.println("id="+id);
		/*
		 * 1.����service���������ظ�id��Ӧ��¼��������Ϣ��user
		 * 2.��user�����װ��request�������,reuqest.setAttrubute("user",user);
		 * 3.������ת���ķ�ʽ����ת���༭ҳ�������ʾ
		 */
		UserService userv = new UserServiceImpl();
		User user = userv.findUserById(id);
		request.setAttribute("user", user);
		System.out.println("user:"+user);
		request.getRequestDispatcher("/user/editUser.jsp").forward(request, response);
	}

}
