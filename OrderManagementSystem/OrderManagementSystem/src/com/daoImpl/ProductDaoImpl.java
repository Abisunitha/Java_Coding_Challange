package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.ProductDao;
import com.exception.ResourceNotFoundException;

import com.model.Product;
import com.utility.DBConnection;

public class ProductDaoImpl implements ProductDao{

	/*@Override
	public boolean findOne(int product_id) throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select productId from product where productId=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, product_id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
		
	}*/

	@Override
	public List<Product> findAll() throws SQLException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select * from product ";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		List<Product> list =new ArrayList<>();
		while(rst.next()==true) {
			int id=rst.getInt("productId");
			String name=rst.getString("productname");
			String description=rst.getString("description");
			Double price=rst.getDouble("price");
			int quantityinstock=rst.getInt("quantityinstock");
			String type=rst.getString("type");
			
			Product product=new Product(id,name,description,price,quantityinstock,type);
			list.add(product);
		}
		DBConnection.dbClose();
		return list;
		
	}

	@Override
	public int save(Product product) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO product (productId, productName, description,price,quantityInStock,type) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setInt(1, product.getProduct_id());
		pstmt.setString(2, product.getProduct_name());
		pstmt.setString(3,product.getDescription());
		pstmt.setDouble(4,product.getPrice());
		pstmt.setInt(5, product.getStock_quantity());
		pstmt.setString(6,product.getType());
		
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		
	}

}
