package com.service.impl;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.model.Admin;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao = new AdminDaoImpl();
	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username, password);
	}

	@Override
	public Admin getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return dao.getUserByUserName(username);
	}

	@Override
	public boolean resetPwd(String oldpwd, String newpwd, String adminId) {
		// TODO Auto-generated method stub
		int _adminId = 0;
		if(adminId!=null && !"".equals(adminId)) {
			_adminId=Integer.parseInt(adminId);
		}
		return dao.resetPwd(oldpwd, newpwd, _adminId);
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return dao.updateAdmin(admin);
	}

}
