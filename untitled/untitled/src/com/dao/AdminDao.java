package com.dao;

import com.model.Admin;


public interface AdminDao {
	/**
	 * �����¼��֤
	 * @param username
	 * @param password
	 * @return
	 */
	public int login(String username,String password);
	/**
	 * ͨ���û�����ȡ�û���Ϣ
	 * @param username
	 * @return
	 */
	public Admin getUserByUserName(String username);
	/**
	 * ����Ա�޸�����
	 * @param oldpwd
	 * @param newpwd
	 * @param adminId
	 * @return
	 */
	public boolean resetPwd(String oldpwd,String newpwd,int adminId);
	
	public boolean updateAdmin(Admin admin);
}
