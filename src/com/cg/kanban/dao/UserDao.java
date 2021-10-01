package com.cg.kanban.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.kanban.model.User;
import com.cg.kanban.util.Dbutil;

public class UserDao {
	
	Connection con;
	public boolean addUser(User user) throws SQLException
	{
		
		
		con=Dbutil.getConnection();
		String insertCmd="insert into user_tbl values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insertCmd);
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getContact());
		ps.setString(5, user.getLoginname());
		ps.setString(6, user.getPassword());
		ps.setString(7, user.getStatus());
		ps.setString(8, user.getRole());
		
		int n=ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();
		if(n>0)
		{
			return true;
		}return false;
	}
	
	public boolean updateUser(User user) throws SQLException
	{
		
		
		con=Dbutil.getConnection();
		String updateCmd="update user_tbl set user_name=?,user_email=?,user_contact=?,user_loginname=?,user_password=?,user_status=?,user_role=?  where user_id=?";
		PreparedStatement ps=con.prepareStatement(updateCmd);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getContact());
		ps.setString(4, user.getLoginname());
		ps.setString(5, user.getPassword());
		ps.setString(6, user.getStatus());
		ps.setString(7, user.getRole());
		ps.setInt(8, user.getId());
		int n=ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();
		if(n>0)
		{
			return true;
		}return false;
	}
	
	
	
	public void deleteUser(int id) throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		String select="delete from user_tbl where user_id=?";
		PreparedStatement ps=con.prepareStatement(select);
		ps.setInt(1, id);
		
		ps.executeQuery();
		 
		ps.close();
		con.commit();
		con.close();
		  
	}
	
	
	
	
	
	public User getUser(int id) throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		String select="select * from user_tbl where user_id=?";
		PreparedStatement ps=con.prepareStatement(select);
		ps.setInt(1, id);
		
		 ResultSet rs = ps.executeQuery();
		 User user=new User();
		  while(rs.next()) 
		  {
		        
		        //create table user(user_id int,user_name varchar(20),user_email varchar(20),user_contact varchar(10),user_loginname varchar(20),user_password varchar(20),user_status varchar(20),user_role varchar(20))
		      //int id, String name, String email, String contact, String loginname, String password, String status,String role
		        user.setId(rs.getInt("user_id"));
		        user.setName(rs.getString("user_name"));
		        user.setContact(rs.getString("user_contact"));
		        user.setEmail(rs.getString("user_email"));
		        user.setLoginname(rs.getString("user_loginname"));
		        user.setPassword(rs.getString("user_password"));
		        user.setStatus(rs.getString("user_status"));
		        user.setRole(rs.getString("user_role"));
		        
		  
		  	}
			ps.close();
			con.commit();
			con.close();
		 return user;
	}
	
	public List<User> getAllUsers() throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("select * from user_tbl");
		  ArrayList<User> userList = new ArrayList<>();
		  while(rs.next()) 
		  {
		        User user=new User();
		        //create table user(user_id int,user_name varchar(20),user_email varchar(20),user_contact varchar(10),user_loginname varchar(20),user_password varchar(20),user_status varchar(20),user_role varchar(20))
		      //int id, String name, String email, String contact, String loginname, String password, String status,String role
		        user.setId(rs.getInt("user_id"));
		        user.setName(rs.getString("user_name"));
		        user.setContact(rs.getString("user_contact"));
		        user.setEmail(rs.getString("user_email"));
		        user.setLoginname(rs.getString("user_loginname"));
		        user.setPassword(rs.getString("user_password"));
		        user.setStatus(rs.getString("user_status"));
		        user.setRole(rs.getString("user_role"));
		        userList.add(user);
		  
		  	}
			rs.close();
			
			con.close();
		 return userList;

	}
}
