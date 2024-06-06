package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Admin;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "��¼����", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");// �������������ַ������룬���Խ������
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		/*
		 * 1.��ȡ�û��ĵ�¼��Ϣ 2.�������ݿⴴ����󣬵��� int flag = login(username,password);
		 * 3.���ݷ���ֵflag,�ж��û��Ƿ��ܵ�¼ ��1���û��������� ��2���������
		 * ��3��������¼������û�������¼���û�ѡ���˼�ס���룬����Cookie���󣬰��û����˺ż�¼���������
		 */
		// 1.��ȡ�û��ĵ�¼��Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remberUsername = request.getParameter("remberUsername");
		String code = request.getParameter("veryfyCode");// ��ȡ�û��������֤��
		String verifyCode = (String) session.getAttribute("verifyCode");// ��ȡͼƬ�б�����session�е���֤��
		if (verifyCode != null) {
			if (verifyCode.equals(code)) {
				// ������֤��
				// System.out.println("remberUsername:"+remberUsername);
				// 2.�������ݿⴴ����󣬵��� int flag = login(username,password);
				AdminService aserv = new AdminServiceImpl();
				int flag = aserv.login(username, password);

				// 3.���ݷ���ֵflag,�ж��û��Ƿ��ܵ�¼
				// *��1���û���������
				if (flag == 3) {
					String msg = "�û��������ڣ�";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					// ��2���������
				} else if (flag == 2) {
					String msg = "�������";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					// ��3��������¼������û�������¼���û�ѡ���˼�ס���룬����Cookie���󣬰��û����˺ż�¼���������
				} else if (flag == 1) {
					if ("on".equals(remberUsername)) {
						// ����Cookie���󣬷��͸����������
						Cookie cookie = new Cookie("username", username);
						cookie.setMaxAge(60 * 60 * 24 * 30);// 30��
						response.addCookie(cookie);//
					}
					Admin admin = aserv.getUserByUserName(username);
					session.setAttribute("admin", admin);
					request.getRequestDispatcher("/admin/main.jsp").forward(request, response);
//					ServletContext application = session.getServletContext();
//					System.out.println(application.getRealPath("/"));
				}
			} else {
				String msg = "��֤�����";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	}

}
