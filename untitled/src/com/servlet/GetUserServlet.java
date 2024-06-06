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
		 * 1.调用service方法，返回该id对应记录的完整信息，user
		 * 2.把user对象封装到request域对象中,reuqest.setAttrubute("user",user);
		 * 3.用请求转发的方式，调转到编辑页面进行显示
		 */
		UserService userv = new UserServiceImpl();
		User user = userv.findUserById(id);
		request.setAttribute("user", user);
		System.out.println("user:"+user);
		request.getRequestDispatcher("/user/editUser.jsp").forward(request, response);
	}

}
