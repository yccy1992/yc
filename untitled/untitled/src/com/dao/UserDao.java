package com.dao;

import java.util.List;
import java.util.Map;

import com.model.PageBean;
import com.model.User;

public interface UserDao {
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public boolean delUserById(int id);
	/**
	 * 删除指定ids的记录信息
	 * @param ids
	 * @return
	 */
	public boolean delChoseUserByIds(int[] ids);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	/**
	 * 根据id查找用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	public List<User> getAllUser();
	/**
	 * 获取所有用户的数目
	 * @return
	 */
	public int countAllUser();
	/**
	 * 返回当前页记录的集合
	 * @param pagebean
	 * @return
	 */
	public List<User> findNowPageUser(PageBean pagebean);
	/**
	 * 返回满足查询条件的记录的个数
	 * @param conditions
	 * @return
	 */
	public int countAllUserByCondition(Map<String, String[]> conditions);
	/**
	 * 返回满足条件的当前页的记录的集合
	 * @param pagebean
	 * @param conditions
	 * @return
	 */
	public List<User> findNowPageUserByCondition(PageBean pagebean,Map<String, String[]> conditions);
}
