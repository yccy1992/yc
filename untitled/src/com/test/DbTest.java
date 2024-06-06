package com.test;

import java.sql.Connection;
import java.sql.SQLException;


import com.dao.AdminDao;
import com.dao.UserDao;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.db.DBUtils;
import org.junit.Test;

public class DbTest {
	public static void main(String[] args) {
		Connection connection = DBUtils.getConnection();
		if (connection!=null){
			System.out.println("成功");
		}
else{
			System.out.println("失败");
		}
	}
	@Test
	public void connectionTest() {
		Connection con = DBUtils.getConnection();
		
		try {
			if(!con.isClosed()) {
				System.out.println("连接成功！");
			}else {
				System.out.println("连接失败！");
			}
			DBUtils.close(null, null, con);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	@Test
	public void loginTest() {
		AdminDao adao = new AdminDaoImpl();
		int flag = adao.login("zhangsan1", "111111");
		assert flag==3;
	}
	@Test
	public void delChoseUserByIds() {
		int[] ids = {23,24,25};
		UserDao dao = new UserDaoImpl();
		assert dao.delChoseUserByIds(ids)==true;

	}
	
	
}
