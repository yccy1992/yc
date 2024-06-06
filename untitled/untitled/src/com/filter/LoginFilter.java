/*
package cg.studentInfo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cg.studentInfo.model.Admin;

*/
/**
 * Servlet Filter implementation class FilterDemo1
 *//*

@WebFilter("/*")
public class LoginFilter implements Filter {

    */
/**
     * Default constructor. 
     *//*

    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	*/
/**
	 * @see Filter#destroy()
	 *//*

	public void destroy() {
		// TODO Auto-generated method stub
	}

	*/
/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 *//*

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req =(HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse)response;
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		// /userManagerSys/index.jsp;/userManagerSys/checkCodeServlet;/userManagerSys/login
		if(requestURI.contains("/index.jsp")||requestURI.contains("/checkCodeServlet")
				||requestURI.contains("/login")||requestURI.contains("/layui")) {
			chain.doFilter(request, response);
		}else if(admin!=null) {
			chain.doFilter(request, response);
		}else {
			//resp.sendRedirect(contextPath+"/index.jsp");
			String msg = "Î´µÇÂ¼£¬ÇëÖØÐÂµÇÂ¼£¡";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}	
		
		
		//System.out.println("FilterDemo1 end");
	}

	*/
/**
	 * @see Filter#init(FilterConfig)
	 *//*

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
*/
