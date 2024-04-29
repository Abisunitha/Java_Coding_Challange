package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ProductDao;
import com.daoImpl.ProductDaoImpl;
import com.exception.ResourceNotFoundException;
import com.model.Product;

public class ProductService {
    ProductDao dao=new ProductDaoImpl();

	public List<Product> findAll() throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		return dao.findAll();
	}

	public int insert(Product product)throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(product);
	}
	

}
