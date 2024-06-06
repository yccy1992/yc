package com.service;

import com.model.Admin;

public interface AdminService {
	/**
	 * ?????????
	 * @param username
	 * @param password
	 * @return
	 */
	public int login(String username,String password);
	/**
	 * ?????????????????
	 * @param username
	 * @return
	 */
	public Admin getUserByUserName(String username);
	/**
	 * ????????????
	 * @param oldpwd
	 * @param newpwd
	 * @param adminId
	 * @return
	 */
	public boolean resetPwd(String oldpwd,String newpwd,String adminId);
	public boolean updateAdmin(Admin admin);
}
