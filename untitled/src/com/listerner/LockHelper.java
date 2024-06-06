package com.listerner;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.model.Admin;


public class LockHelper {
	public static Map<String,HttpSession> map = new HashMap<String,HttpSession>();
	public static void putSession(HttpSession session) {
		ServletContext sc = session.getServletContext();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin!=null) {
			map.put(admin.getUsername(), session);
			sc.setAttribute("onlineAdmins", map);
		}
	}
	public static void moveSession(HttpSession session) {
		ServletContext sc = session.getServletContext();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin!=null) {
			map.remove(admin.getUsername());
			sc.setAttribute("onlineAdmins", map);
		}
	}
	public static void destroyedSession(Admin admin) {
		if(admin!=null) {
			HttpSession session = map.get(admin.getUsername());
			if(session!=null) {
				LockHelper.moveSession(session);
				session.invalidate();
				session.setMaxInactiveInterval(0);
			}
		}
	}
	public static boolean destroyedSession(String username) {
		if(username!=null) {
			HttpSession session = map.get(username);
			if(session!=null) {
				LockHelper.moveSession(session);
				session.invalidate();
				session.setMaxInactiveInterval(0);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
