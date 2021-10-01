package com.cg.kanban.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cg.kanban.dao.BacklogDao;
import com.cg.kanban.model.Backlog;
import com.cg.kanban.model.Project;

public class BacklogService {

	BacklogDao backlogDao=new BacklogDao();
	public boolean addBacklog(Backlog backlog) throws SQLException, ParseException
	{
		
		boolean flag=backlogDao.addBacklog(backlog);
		return flag;
	}
	
	public List<Backlog> getAllBacklogs() throws SQLException
	{
		return backlogDao.getAllBacklogs();
	}
	
}
