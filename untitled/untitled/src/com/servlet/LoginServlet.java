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
@WebServlet(description = "登录处理", urlPatterns = { "/login" })
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
		request.setCharacterEncoding("UTF-8");// 设置请求对象的字符集编码，可以解决乱码
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		/*
		 * 1.获取用户的登录信息 2.创建数据库创造对象，调用 int flag = login(username,password);
		 * 3.根据返回值flag,判断用户是否能登录 （1）用户名不存在 （2）密码错误
		 * （3）正常登录，如果用户正常登录，用户选择了记住密码，创建Cookie对象，把用户的账号记录到浏览器中
		 */
		// 1.获取用户的登录信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remberUsername = request.getParameter("remberUsername");
		String code = request.getParameter("veryfyCode");// 获取用户输入的验证码
		String verifyCode = (String) session.getAttribute("verifyCode");// 获取图片中保持在session中的验证码
		if (verifyCode != null) {
			if (verifyCode.equals(code)) {
				// 忽略验证码
				// System.out.println("remberUsername:"+remberUsername);
				// 2.创建数据库创造对象，调用 int flag = login(username,password);
				AdminService aserv = new AdminServiceImpl();
				int flag = aserv.login(username, password);

				// 3.根据返回值flag,判断用户是否能登录
				// *（1）用户名不存在
				if (flag == 3) {
					String msg = "用户名不存在！";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					// （2）密码错误
				} else if (flag == 2) {
					String msg = "密码错误！";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					// （3）正常登录，如果用户正常登录，用户选择了记住密码，创建Cookie对象，把用户的账号记录到浏览器中
				} else if (flag == 1) {
					if ("on".equals(remberUsername)) {
						// 创建Cookie对象，发送给浏览器保存
						Cookie cookie = new Cookie("username", username);
						cookie.setMaxAge(60 * 60 * 24 * 30);// 30天
						response.addCookie(cookie);//
					}
					Admin admin = aserv.getUserByUserName(username);
					session.setAttribute("admin", admin);
					request.getRequestDispatcher("/admin/main.jsp").forward(request, response);
//					ServletContext application = session.getServletContext();
//					System.out.println(application.getRealPath("/"));
				}
			} else {
				String msg = "验证码错误！";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	}

}
