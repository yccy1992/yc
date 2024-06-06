package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Admin;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/updateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
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
		HttpSession session = request.getSession();
		String admin_id = request.getParameter("admin_id");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		int _admin_id = 0;
		if(admin_id!=null && !"".equals(admin_id)) {
			_admin_id = Integer.parseInt(admin_id);
		}
		Admin admin = new Admin();
		admin.setAdmin_id(_admin_id);
		admin.setUsername(username);
		admin.setPhone(phone);
		admin.setBirthday(birthday);
		AdminService aser = new AdminServiceImpl();
		boolean flag = false;
		flag = aser.updateAdmin(admin);
		PrintWriter out = response.getWriter();
		if(flag) {
			session.setAttribute("admin", admin);
			out.print("<script>alert('�޸ĳɹ���')</script>");
		}else {
			out.print("<script>alert('�޸�ʧ�ܣ�')</script>");
		}
		String contextPath = request.getContextPath();
		response.setHeader("refresh", "3;URL="+contextPath+"/admin/modifyAdmin.jsp");
		
	}

}
