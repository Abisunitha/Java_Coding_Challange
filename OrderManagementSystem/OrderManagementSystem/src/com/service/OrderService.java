package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDao;
import com.dao.UserDao;
import com.daoImpl.OrderDaoImpl;
import com.daoImpl.UserDaoImpl;
import com.exception.ResourceNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Order;

public class OrderService {
OrderDao dao=new OrderDaoImpl();
UserDao userdao=new UserDaoImpl();
	public int insert(Order order) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		
		return dao.save(order);
	}
	public void softDeleteByid(int order_id) throws SQLException, UserNotFoundException, ResourceNotFoundException {
		// TODO Auto-generated method stub
	boolean orderid=dao.orderexits(order_id);
	 if (!orderid) {
	        throw new UserNotFoundException("order id not found.");
	    }

	
		dao.softDeletebyid(order_id);
	}
	public List<Order> findAll() throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	public boolean findorderid(int order_id) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		boolean orderexists=dao.orderexits(order_id);
	    if (!orderexists) {
	        throw new UserNotFoundException("order id not found.");
	    }

	    return orderexists;
		
	}
	public List<Order> findorders(int user_id)throws SQLException,UserNotFoundException {
		// TODO Auto-generated method stub
		boolean useridvalid=userdao.userexits(user_id);
		if(!useridvalid) {
			throw new UserNotFoundException("user id invalid");
		}
		return dao.findorders(user_id);
	}

}
