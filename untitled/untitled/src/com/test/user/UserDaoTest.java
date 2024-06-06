package com.test.user;

import com.model.User;
import org.junit.Test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class UserDaoTest {
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("����");
		user.setGender("��");
		user.setAge(20);
		user.setAddress("����");
		user.setQq("9208653");
		user.setEmail("9208653@qq.com");
		UserDao udao = new UserDaoImpl();
		boolean flag = udao.addUser(user);
		assert flag==true;
		System.out.println(flag);
	}
}
