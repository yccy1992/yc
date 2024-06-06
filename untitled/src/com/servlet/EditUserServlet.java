package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.model.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/editUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
		User user = new User();
		PrintWriter out = response.getWriter();
		Map<String, String[]> map = request.getParameterMap();
		boolean flag = false;
		try {
			BeanUtils.populate(user, map);
			UserService userv = new UserServiceImpl();
			flag = userv.updateUser(user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag) {
			//��ʾ���³ɹ���Ȼ�������Ϣ����
			out.print("<script>alert('���³ɹ���')</script>");
			response.setHeader("refresh", "3;URL=/login/getUserServlet?id="+user.getId());
		}else {
			//��ʾ����ʧ�ܣ��ٴε����������û���Ϣҳ��
			out.print("<script>alert('����ʧ�ܣ�')</script>");
			response.setHeader("refresh", "3;URL=/login/getUserServlet?id="+user.getId());
		}
		
		
	}

}
