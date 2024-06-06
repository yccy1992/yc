package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dao.UserDao;
import com.db.DBUtils;
import com.model.PageBean;
import com.model.User;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql = "";
	private int row = 0;
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		con = DBUtils.getConnection();
		sql = "insert into user_info(name,gender,age,address,qq,email)values(?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getGender());
			psmt.setInt(3, user.getAge());
			psmt.setString(4, user.getAddress());
			psmt.setString(5, user.getQq());
			psmt.setString(6, user.getEmail());
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
	public boolean delUserById(int id) {
		// TODO Auto-generated method stub
		sql = "delete from user_info where id=?";
		con = DBUtils.getConnection();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
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
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		con = DBUtils.getConnection();
		sql = "update user_info set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getGender());
			psmt.setInt(3, user.getAge());
			psmt.setString(4, user.getAddress());
			psmt.setString(5, user.getQq());
			psmt.setString(6, user.getEmail());
			psmt.setInt(7, user.getId());
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
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user = new User();
		sql = "select * from user_info where id = ?";
		con = DBUtils.getConnection();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setQq(rs.getString("qq"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		con = DBUtils.getConnection();
		List<User> list = new ArrayList<User>();
		sql = "select * from user_info";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setQq(rs.getString("qq"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return list;
	}

	@Override
	public int countAllUser() {
		// TODO Auto-generated method stub
		con = DBUtils.getConnection();
		sql="select count(*) from user_info";
		int count = 0;// 获取总记录数
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return count;
	}

	@Override
	public List<User> findNowPageUser(PageBean pagebean) {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		sql="select * from user_info limit ?,?";//第一个问号是记录开始的位置，第二个问号是取得记录数
		con = DBUtils.getConnection();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, pagebean.getStart());
			psmt.setInt(2, pagebean.getLimitPage());
			rs = psmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setQq(rs.getString("qq"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return list;
	}

	@Override
	public int countAllUserByCondition(Map<String, String[]> conditions) {
		// TODO Auto-generated method stub
		//condition:page,limit,name,address,email
		//sql = "select * from user_info where 1=1  "
		//sql = "select * from user_info where 1=1 and name like ? and address like ?"
		int count = 0;
		List<String> params = new ArrayList<String>();
		con = DBUtils.getConnection();
		sql = "select count(*) from user_info where 1=1 ";
		StringBuffer buff = new StringBuffer(sql);
		Set<String> set = conditions.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if("page".equals(key) || "limit".equals(key)) {
				continue;
			}else {
				String value = conditions.get(key)[0];
				if(value!=null && !"".equals(value)) {
					buff.append(" and "+ key + " like ? ");
					params.add("%"+value+"%");
					// and name like "%李%";"%李%"
				}
				
			}
		}
		//sql = "select * from user_info where 1=1 and name = ? and address = ? and email = ?"
		try {
			psmt = con.prepareStatement(buff.toString());
			for(int i = 0;i<params.size();i++) {
				psmt.setString(i+1, params.get(i));
			}
			//System.out.println("psmt:"+psmt);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return count;
	}

	@Override
	public List<User> findNowPageUserByCondition(PageBean pagebean, Map<String, String[]> conditions) {
		// TODO Auto-generated method stub
		con = DBUtils.getConnection();
		List<User> list_user = new ArrayList<User>();
		List<String> params = new ArrayList<String>();
		//sql = "select * from user_info where 1=1 and name like ? and address like ? limit ?,?"
		sql = "select * from user_info where 1=1 ";
		StringBuffer buff = new StringBuffer(sql);
		Set<String> set = conditions.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if("page".equals(key) || "limit".equals(key)) {
				continue;
			}else {
				String value = conditions.get(key)[0];
				if(value!=null && !"".equals(value)) {
					buff.append(" and "+ key + " like ? ");
					params.add("%"+value+"%");
					// and name like "%李%";"%李%"
				}
				
			}
		}
		//sql = "select * from user_info where 1=1 and name like ? and address like ? and email like ?"
		buff.append(" limit ?,? ");
		//sql = "select * from user_info where 1=1 and name like ? and address like ? and email like ? limit ?,?"
		try {
			psmt = con.prepareStatement(buff.toString());
			for(int i = 0;i<params.size();i++) {
				psmt.setString(i+1, params.get(i));
			}
			psmt.setInt(params.size()+1, pagebean.getStart());
			psmt.setInt(params.size()+2, pagebean.getLimitPage());
			//System.out.println("psmt:"+psmt);
			rs = psmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setQq(rs.getString("qq"));
				user.setEmail(rs.getString("email"));
				list_user.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_user;
	}

	@Override
	public boolean delChoseUserByIds(int[] ids) {
		// TODO Auto-generated method stub
		//delete from user_info where 1=1 and (id=?)
		//delete from user_info where 1=1 and (id=? or id=? or ...or id=?)
		boolean flag = false; //标识数据库操作是否成功
		sql = "delete from user_info where 1=1 and ( ";
		StringBuffer buff = new StringBuffer(sql);
		if(ids.length==1) {
			buff.append(" id = ? ) ");
		}else {
			for(int i=0;i<ids.length;i++) {
				if(i==ids.length-1) {
					buff.append(" id = ? ) ");
				}else {
					buff.append(" id = ? or ");
				}
				
			}
		}
		con = DBUtils.getConnection();		
		try {
			con.setAutoCommit(false);
			psmt = con.prepareStatement(buff.toString());
			for(int i=0;i<ids.length;i++) {
				psmt.setInt(i+1, ids[i]);
			}
			row = psmt.executeUpdate();
			if(row == ids.length) {
				con.commit();
				flag = true;
			}else {
				con.rollback();
				flag = false;
			}
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, psmt, con);
		}
		return flag;
	}

}
