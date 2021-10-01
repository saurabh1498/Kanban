package com.cg.kanban.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cg.kanban.dao.ProjectTaskDao;
import com.cg.kanban.model.ProjectTask;

public class ProjectTaskService {

	ProjectTaskDao ProjectTaskDao=new ProjectTaskDao();
	public boolean addProjectTask(ProjectTask projectTask) throws SQLException, ParseException
	{
		
		boolean flag=ProjectTaskDao.addProjectTask(projectTask);
		return flag;
	}
	
	public void deleteProjectTask(int id) throws SQLException
	{
		ProjectTaskDao.deleteProjectTask(id);
	}
	public ProjectTask getProjectTask(int id) throws SQLException
	{
		return ProjectTaskDao.getProjectTask(id);
	}
	public boolean updateProjectTask(ProjectTask projectTask) throws SQLException, ParseException
	{
		
		boolean flag=ProjectTaskDao.updateProjectTask(projectTask);
		return flag;
	}
	public List<ProjectTask> getAllProjectTasks() throws SQLException
	{
		return ProjectTaskDao.getAllProjectTask();
	}
	
	
}
