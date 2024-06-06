package com.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.model.PageBean;
import com.model.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}
	@Override
	public boolean delUserById(String id) {
		// TODO Auto-generated method stub
		int id_int = 0;
		if(id!=null || id!="") {
			id_int =Integer.parseInt(id);
		}		
		return dao.delUserById(id_int);
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}
	@Override
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		int _id = 0;
		if(id!=null && !"".equals(id)) {
			_id = Integer.parseInt(id);
		}
		return dao.getUserById(_id);
	}
	@Override
	public PageBean getNowPageUser(String page,String limit) {
		// TODO Auto-generated method stub
		int totalCount = dao.countAllUser();//总记录数
		int _page = 0;//当前页
		int _limit = 0;//每页显示的记录数
		if(page!=null && !"".equals(page)) {
			_page = Integer.parseInt(page);
		}
		if(limit!=null && !"".equals(limit)) {
			_limit = Integer.parseInt(limit);
		}
		PageBean<User> pagebean = new PageBean<User>(totalCount,_page,_limit);
		List<User> list = dao.findNowPageUser(pagebean);//返回当前页记录的集合
		pagebean.setList(list);
		return pagebean;
	}
	@Override
	public PageBean<User> getNowPageUserByCondition(Map<String, String[]> conditions) {
		// TODO Auto-generated method stub
		/**
		 * 1.获得满足查询条件的总记录数
		 * 2.获得当前页信息
		 * 3.获得每页显示的记录数信息
		 */
		int totalCount = dao.countAllUserByCondition(conditions);//where
		String page = conditions.get("page")[0];
		String limit = conditions.get("limit")[0];
		int _page = 0;//当前页
		int _limit = 0;//每页显示的记录数
		if(page!=null && !"".equals(page)) {
			_page = Integer.parseInt(page);
		}
		if(limit!=null && !"".equals(limit)) {
			_limit = Integer.parseInt(limit);
		}
		PageBean<User> pagebean = new PageBean<User>(totalCount,_page,_limit);
		List<User> list = dao.findNowPageUserByCondition(pagebean, conditions);
		pagebean.setList(list);
		return pagebean;
	}
	@Override
	public boolean delChoseUserByIds(String[] ids) {
		// TODO Auto-generated method stub
		int[] _ids = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
		return dao.delChoseUserByIds(_ids);
	}

}
