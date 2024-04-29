package com.dao;

import java.sql.SQLException;
import java.util.List;


import com.exception.UserNotFoundException;
import com.model.Order;

public interface OrderDao {

	int save(Order order)throws SQLException,UserNotFoundException;

	boolean findpresent(int user_id, int order_id)throws SQLException,UserNotFoundException;

	void softDeletebyid(int order_id)throws SQLException,UserNotFoundException;

	List<Order> findAll()throws SQLException,UserNotFoundException;

	boolean orderexits(int order_id)throws SQLException,UserNotFoundException;

	List<Order> findorders(int user_id)throws SQLException,UserNotFoundException;

}
