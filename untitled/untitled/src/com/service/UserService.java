package com.service;

import java.util.List;
import java.util.Map;

import com.model.PageBean;
import com.model.User;

public interface UserService {
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	public boolean delUserById(String id);
	/**
	 * ɾ��ѡ���û���Ϣ
	 * @param ids
	 * @return
	 */
	public boolean delChoseUserByIds(String[] ids);
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	/**
	 * ����id��ȡָ���û�����Ϣ
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
	 * ���������ѯ�����ĵ�ǰҳ��¼�ļ���
	 * @param pagebean
	 * @param conditions
	 * @return
	 */
	public PageBean<User> getNowPageUserByCondition(Map<String, String[]> conditions);
	/**
	 * �������м�¼�ļ���
	 * @return
	 */
	public List<User> findAllUser();
}
