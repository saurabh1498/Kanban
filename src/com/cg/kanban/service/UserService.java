package com.cg.kanban.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.kanban.dao.UserDao;
import com.cg.kanban.model.User;

public class UserService {

	UserDao userDao=new UserDao();
	public boolean addUser(User user) throws SQLException
	{
		
		boolean flag=userDao.addUser(user);
		return flag;
	}
	
	public void deleteUser(int id) throws SQLException
	{
		userDao.deleteUser(id);
	}
	public User getUser(int id) throws SQLException
	{
		return userDao.getUser(id);
	}
	public boolean updateUser(User user) throws SQLException
	{
		
		boolean flag=userDao.updateUser(user);
		return flag;
	}
	public List<User> getAllUsers() throws SQLException
	{
		return userDao.getAllUsers();
	}
	
	
}
