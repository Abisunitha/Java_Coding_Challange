package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.ResourceNotFoundException;
import com.exception.UserNotFoundException;
import com.model.Order;
import com.model.Product;
import com.model.User;
import com.service.OrderService;
import com.service.ProductService;
import com.service.UserService;

public class MainModule {
public static void main(String[] args) throws ResourceNotFoundException, UserNotFoundException {
	ProductService productService=new ProductService();
	OrderService orderService=new OrderService();
	UserService userService=new UserService();
	Scanner sc=new Scanner(System.in);
	
	while(true) {
		System.out.println("---------- OrderManagementSystem-------------");
		System.out.println("Press 1. FindAll Products ");
		System.out.println("Press 2. Create order");
		System.out.println("press 3. Cancel order");
		System.out.println("press 4: Create product");
		System.out.println("press 5: Create user");
		System.out.println("press 6: Getorderbyuser");
		System.out.println("press 0: Exit");
		int input=sc.nextInt();
		if(input==0) {
			System.out.println("Exiting Order Module..");
			break;
		}
		switch(input) {
		case 1:
			try {
				
;				List<Product> list=productService.findAll();
				for(Product a :list) {
					System.out.println(a);
					
				}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
		case 2:
			try {
			Random random =new Random();
			int randomNumber = random.nextInt();
			int order_id=randomNumber<0?randomNumber*-1:randomNumber;
			System.out.println("order_id:" +order_id);
			
			
			System.out.println("Enter user_id");
			int user_id=sc.nextInt();
		    userService.isUserIdPresent(user_id);
			
		    Order order=new Order(order_id,user_id);
		    int status=orderService.insert(order);
		    if(status==1)
		    	System.out.println("Artist record added to DB");
		    else
		    	System.out.println("Insert operation failed");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}catch(UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		    
		    
			break; 
		case 3:
			try {
			List<Order> list=orderService.findAll();
			for(Order a :list) {
				System.out.println(a);
				
			}
			
			System.out.println("enter order id");
			int order_id=sc.nextInt();
			
			orderService.findorderid(order_id);
			
			
				orderService.softDeleteByid(order_id);
				System.out.println("order record de-activated");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}catch(ResourceNotFoundException e) {
				System.out.println(e.getMessage());
			
			}catch(UserNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			try {
				Random random =new Random();
				int randomNumber = random.nextInt();
				int product_id=randomNumber<0?randomNumber*-1:randomNumber;
				System.out.println("order_id:" +product_id);
				
				System.out.println("enter product name:");
				sc.nextLine();
				String productname=sc.nextLine();
				
				System.out.println("enter description");
				String description=sc.nextLine();
			
				System.out.println("enter price");
				double price=sc.nextDouble();
				System.out.println("enter quantity in stock");
				int quantity=sc.nextInt();
				sc.nextLine();
				System.out.println("enter type");
				String type=sc.nextLine();
				
			
				
			    Product product=new Product(product_id,productname,description,price,quantity,type);
			    int status=productService.insert(product);
			    if(status==1)
			    	System.out.println("Artist record added to DB");
			    else
			    	System.out.println("Insert operation failed");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				
			}
			break;
		case 5:
			try {
				Random random =new Random();
				int randomNumber = random.nextInt();
				int user_id=randomNumber<0?randomNumber*-1:randomNumber;
				System.out.println("userid:" +user_id);
				
				System.out.println("enter user name:");
				sc.nextLine();
				String username=sc.nextLine();
				
				System.out.println("enter password");
				String password=sc.nextLine();
			
				System.out.println("enter role");
				String role=sc.nextLine();
				
				
			    User user=new User(user_id,username,password,role);
			    int status=userService.insert(user);
			    if(status==1)
			    	System.out.println("Artist record added to DB");
			    else
			    	System.out.println("Insert operation failed");
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				
			}
			break;
		case 6:
			try {
				System.out.println("enter user id");
				int user_id=sc.nextInt();
			
				List<Order> list=orderService.findorders(user_id);
				for(Order a :list) {
					System.out.println(a);
					
				}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(UserNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			}
				
		}

sc.close();
}
}