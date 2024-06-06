package com.dao;

import com.model.Admin;


public interface AdminDao {
	/**
	 * 管理登录验证
	 * @param username
	 * @param password
	 * @return
	 */
	public int login(String username,String password);
	/**
	 * 通过用户名获取用户信息
	 * @param username
	 * @return
	 */
	public Admin getUserByUserName(String username);
	/**
	 * 管理员修改密码
	 * @param oldpwd
	 * @param newpwd
	 * @param adminId
	 * @return
	 */
	public boolean resetPwd(String oldpwd,String newpwd,int adminId);
	
	public boolean updateAdmin(Admin admin);
}
