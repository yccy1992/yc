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

*/
/**
 * Servlet Filter implementation class WebCodeFilter
 *//*

@WebFilter("/*")
public class WebCodeFilter implements Filter {

    */
/**
     * Default constructor. 
     *//*

    public WebCodeFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
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
