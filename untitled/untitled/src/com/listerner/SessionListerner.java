package com.listerner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.model.Admin;

/**
 * Application Lifecycle Listener implementation class SessionListerner
 *
 */
//@WebListener
public class SessionListerner implements HttpSessionListener, HttpSessionAttributeListener {
	private List<Admin> list = new ArrayList<Admin>();
    /**
     * Default constructor. 
     */
    public SessionListerner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub    	
    	String name = arg0.getName();
    	Admin value = null;
    	if("admin".equals(name)) {
    		value = (Admin)arg0.getValue();
    		HttpSession session = arg0.getSession();
        	ServletContext application = session.getServletContext();
        	list = (List)application.getAttribute("onLineAdmins");
        	//�ж�ServletContext����������onLineAdmins�����߹���Ա������
        	if(list==null) {
        		list = new ArrayList<Admin>();
        		list.add(value);
        		application.setAttribute("onLineAdmins", list);
        	}else {
        		if(!list.contains(value)) {
        			list.add(value);
        			application.setAttribute("onLineAdmins", list);
        		}
        	}
    	}
    	
//    	
//    	
//    	System.out.println("name:"+name);
//    	System.out.println(value);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	String name = arg0.getName();
    	HttpSession session = arg0.getSession();
    	ServletContext application = session.getServletContext();
    	if("admin".equals(name)) {
    		//System.out.println("�û��˳���");
    		Admin value = (Admin)arg0.getValue();
    		list = (List)application.getAttribute("onLineAdmins");
    		Iterator<Admin> it = list.iterator();
    		while(it.hasNext()) {
    			Admin admin = it.next();
    			if(value.getUsername().equals(admin.getUsername())) {
    				it.remove();
    				break;
    			}
    		}
    		application.setAttribute("onLineAdmins", list);
    		
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
