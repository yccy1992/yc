package com.service;

import java.util.List;
import java.util.Map;

import com.model.PageBean;
import com.model.User;

public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public boolean delUserById(String id);
	/**
	 * 删除选择用户信息
	 * @param ids
	 * @return
	 */
	public boolean delChoseUserByIds(String[] ids);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	/**
	 * 根据id获取指定用户的信息
	 * @param id
	 * @return
	 */
	public User findUserById(String id);
	/**
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	public PageBean getNowPageUser(String page,String limit);
	/**
	 * 返回满足查询条件的当前页记录的集合
	 * @param pagebean
	 * @param conditions
	 * @return
	 */
	public PageBean<User> getNowPageUserByCondition(Map<String, String[]> conditions);
	/**
	 * 返回所有记录的集合
	 * @return
	 */
	public List<User> findAllUser();
}
