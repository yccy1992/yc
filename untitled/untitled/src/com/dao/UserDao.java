package com.dao;

import java.util.List;
import java.util.Map;

import com.model.PageBean;
import com.model.User;

public interface UserDao {
	/**
	 * ����û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	/**
	 * ����idɾ���û�
	 * @param id
	 * @return
	 */
	public boolean delUserById(int id);
	/**
	 * ɾ��ָ��ids�ļ�¼��Ϣ
	 * @param ids
	 * @return
	 */
	public boolean delChoseUserByIds(int[] ids);
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	/**
	 * ����id�����û���Ϣ
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	
	/**
	 * ��ѯ���е��û���Ϣ
	 * @return
	 */
	public List<User> getAllUser();
	/**
	 * ��ȡ�����û�����Ŀ
	 * @return
	 */
	public int countAllUser();
	/**
	 * ���ص�ǰҳ��¼�ļ���
	 * @param pagebean
	 * @return
	 */
	public List<User> findNowPageUser(PageBean pagebean);
	/**
	 * ���������ѯ�����ļ�¼�ĸ���
	 * @param conditions
	 * @return
	 */
	public int countAllUserByCondition(Map<String, String[]> conditions);
	/**
	 * �������������ĵ�ǰҳ�ļ�¼�ļ���
	 * @param pagebean
	 * @param conditions
	 * @return
	 */
	public List<User> findNowPageUserByCondition(PageBean pagebean,Map<String, String[]> conditions);
}
