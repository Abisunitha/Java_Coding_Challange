package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.exception.UserNotFoundException;
import com.model.User;
import com.utility.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean userexits(int userId) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select userId from user where userID=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public int save(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO user (userId, userName, password,role) VALUES(?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setInt(1, user.getUser_id());
		pstmt.setString(2, user.getUser_name());
		pstmt.setString(3,user.getPassword());
		
		pstmt.setString(6,user.getRole());
		
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		
	}



}
