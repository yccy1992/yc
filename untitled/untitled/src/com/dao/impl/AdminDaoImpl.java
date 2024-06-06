package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.AdminDao;
import com.db.DBUtils;
import com.model.Admin;

public class AdminDaoImpl implements AdminDao {
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql ="";
	private int row = 0;
	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		int flag = 0;
		con = DBUtils.getConnection();
		sql = "select password from admin_info where username = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(password.equals(rs.getString("password"))) {
					flag = 1;
				}else {
					flag = 2;
				}
			}else {//ÓÃ»§Ãû´íÎó
				flag = 3;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return flag;
	}

	@Override
	public Admin getUserByUserName(String username) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		sql =" select * from admin_info where username = ?";
		con = DBUtils.getConnection();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			rs = psmt.executeQuery();
			if(rs.next()) {
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setPhone(rs.getString("phone"));
				admin.setBirthday(rs.getString("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return admin;
	}

	@Override
	public boolean resetPwd(String oldpwd, String newpwd, int adminId) {
		// TODO Auto-generated method stub
		sql = "update admin_info set password = ? where password = ? and admin_id = ?";
		con = DBUtils.getConnection();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, newpwd);
			psmt.setString(2, oldpwd);
			psmt.setInt(3, adminId);
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return row>0?true:false;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		sql = "update admin_info set username=?,phone=?,birthday=? where admin_id=?";
		con = DBUtils.getConnection();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, admin.getUsername());
			psmt.setString(2, admin.getPhone());
			psmt.setString(3, admin.getBirthday());
			psmt.setInt(4, admin.getAdmin_id());
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return row>0?true:false;
	}

}
