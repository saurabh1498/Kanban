package com.cg.kanban.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cg.kanban.dao.ProjectDao;
import com.cg.kanban.model.Project;

public class ProjectService {

	ProjectDao projectDao=new ProjectDao();
	public boolean addProject(Project project) throws SQLException, ParseException
	{
		
		boolean flag=projectDao.addProject(project);
		return flag;
	}
	
	public void deleteProject(int id) throws SQLException
	{
		projectDao.deleteProject(id);
	}
	public Project getProject(int id) throws SQLException
	{
		return projectDao.getproject(id);
	}
	public boolean updateProject(Project project) throws SQLException, ParseException
	{
		
		boolean flag=projectDao.updateProject(project);
		return flag;
	}
	public List<Project> getAllProjects() throws SQLException
	{
		return projectDao.getAllProject();
	}
	
	
}
