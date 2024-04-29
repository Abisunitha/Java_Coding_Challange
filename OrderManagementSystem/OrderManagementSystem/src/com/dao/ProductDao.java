package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.ResourceNotFoundException;
import com.model.Product;

public interface ProductDao {

	

	List<Product> findAll()throws SQLException,ResourceNotFoundException;

	int save(Product product)throws SQLException;

}
