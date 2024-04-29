package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDao;

import com.exception.UserNotFoundException;

import com.model.Order;
import com.utility.DBConnection;




public class OrderDaoImpl implements OrderDao {

	@Override
	public int save(Order order) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO orders (orderId,userId) VALUES(?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setInt(1, order.getOrder_id());
		pstmt.setInt(2, order.getUser_id());
		
		
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public boolean findpresent(int user_id, int order_id) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "select *from orders where user_id = ? and order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		pstmt.setInt(2, order_id);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();
		
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public void softDeletebyid(int order_id) throws SQLException,UserNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="update orders SET isActive='no' where orderId=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, order_id);
		pstmt.executeUpdate();
		DBConnection.dbClose();
	}

	@Override
	public List<Order> findAll() throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="SELECT*from orders";
		PreparedStatement pstmt= con.prepareStatement(sql);

		ResultSet rst=pstmt.executeQuery();
		List<Order> list =new ArrayList<>();
		while(rst.next()==true) {
			int order_id=rst.getInt("orderId");
			int user_id=rst.getInt("userId");
			
			
	        Order order = new Order(order_id,user_id);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;
		
	}

	@Override
	public boolean orderexits(int order_id) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select orderId from orders where orderId=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, order_id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public List<Order> findorders(int user_id) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="SELECT*from orders where userId=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, user_id);
		ResultSet rst=pstmt.executeQuery();
		List<Order> list =new ArrayList<>();
		while(rst.next()==true) {
			int order_id=rst.getInt("orderId");
			int userid=rst.getInt("userId");
			
			
	        Order order = new Order(order_id,userid);
			list.add(order);
		}
		DBConnection.dbClose();
		return list;
		
	}

}
