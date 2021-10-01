package com.cg.kanban.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import com.cg.kanban.model.ProjectTask;
import com.cg.kanban.util.Dbutil;

public class ProjectTaskDao {
	Connection con;
	public boolean addProjectTask(ProjectTask projectTask) throws SQLException, ParseException
	{
		
	
		con=Dbutil.getConnection();
		String insertCmd="insert into task_tbl values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insertCmd);
		ps.setInt(1,projectTask.getId());
		ps.setString(2,projectTask.getProjectSequence());
		ps.setString(3, projectTask.getSummary());
		ps.setString(4, projectTask.getAcceptanceCriteria());
		ps.setString(5, projectTask.getStatus());
		ps.setString(6, projectTask.getPriority());
		ps.setString(8, projectTask.getProjectIdentifier());
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		

		java.util.Date date = sdf1.parse(projectTask.getDueDate());
		java.sql.Date sqlDueDate = new java.sql.Date(date.getTime());  
		ps.setDate(7, sqlDueDate);

//Created At
		
		date = sdf1.parse(projectTask.getCreatedAt());
		java.sql.Date sqlCreatedAt = new java.sql.Date(date.getTime());  
		ps.setDate(9, sqlCreatedAt);

//Updated At		
		date = sdf1.parse(projectTask.getUpdatedAt());
		java.sql.Date sqlUpdatedAt = new java.sql.Date(date.getTime());  
		ps.setDate(10, sqlUpdatedAt);
		
				
		
		int n=ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();
		if(n>0)
		{
			return true;
		}return false;
	}
	
	
	
	public boolean updateProjectTask(ProjectTask projectTask) throws SQLException, ParseException
	{
		
	
		con=Dbutil.getConnection();
		String insertCmd="update task_tbl set project_sequence=?,task_summary=?,task_acceptance_criteria=?,task_status=?,task_priority=?,task_due_date=?,project_identifier=?,task_created_at=?,task_updated_at=? where task_id=?";
		PreparedStatement ps=con.prepareStatement(insertCmd);
		ps.setInt(1,projectTask.getId());
		ps.setString(2,projectTask.getProjectSequence());
		ps.setString(3, projectTask.getSummary());
		ps.setString(4, projectTask.getAcceptanceCriteria());
		ps.setString(5, projectTask.getStatus());
		ps.setString(6, projectTask.getPriority());
		ps.setString(8, projectTask.getProjectIdentifier());
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		

		java.util.Date date = sdf1.parse(projectTask.getDueDate());
		java.sql.Date sqlDueDate = new java.sql.Date(date.getTime());  
		ps.setDate(7, sqlDueDate);

//Created At
		
		date = sdf1.parse(projectTask.getCreatedAt());
		java.sql.Date sqlCreatedAt = new java.sql.Date(date.getTime());  
		ps.setDate(9, sqlCreatedAt);

//Updated At		
		date = sdf1.parse(projectTask.getUpdatedAt());
		java.sql.Date sqlUpdatedAt = new java.sql.Date(date.getTime());  
		ps.setDate(10, sqlUpdatedAt);
		
				
		
		int n=ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();
		if(n>0)
		{
			return true;
		}return false;
	}
	
	public ProjectTask getProjectTask(int id) throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		String select="select * from task_tbl where task_id=?";
		PreparedStatement ps=con.prepareStatement(select);
		ps.setInt(1, id);
		
		 ResultSet rs = ps.executeQuery();
		 ProjectTask projectTask=new ProjectTask();
		  while(rs.next()) 
		  {
   
		        projectTask.setId(rs.getInt("task_id"));
		        projectTask.setProjectSequence(rs.getString("project_sequence"));
		        projectTask.setSummary(rs.getString("task_summary"));
		        projectTask.setAcceptanceCriteria(rs.getString("task_acceptance_criteria"));
		        projectTask.setStatus(rs.getString("task_status"));
		        projectTask.setPriority(rs.getString("task_priority"));
		        projectTask.setDueDate(rs.getDate("task_due_date").toString());
		        projectTask.setCreatedAt(rs.getDate("task_created_at").toString());
		        projectTask.setUpdatedAt(rs.getDate("task_updated_at").toString());
		       
		        
		  
		  	}
		  	rs.close();
			ps.close();
			con.commit();
			con.close();
		 return projectTask;
	}
	
	
	
	public ArrayList<ProjectTask> getAllProjectTask() throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
	
		 ResultSet rs = stmt.executeQuery("select * from project_task_tbl");
		 ArrayList<ProjectTask> projectTaskList = new ArrayList<ProjectTask>();
		
		  while(rs.next()) 
		  {
			  	ProjectTask projectTask=new ProjectTask();
		        projectTask.setId(rs.getInt("task_id"));
		        projectTask.setProjectSequence(rs.getString("project_sequence"));
		        projectTask.setSummary(rs.getString("task_summary"));
		        projectTask.setAcceptanceCriteria(rs.getString("task_acceptance_criteria"));
		        projectTask.setStatus(rs.getString("task_status"));
		        projectTask.setPriority(rs.getString("task_priority"));
		        projectTask.setDueDate(rs.getDate("task_due_date").toString());
		        projectTask.setCreatedAt(rs.getDate("task_created_at").toString());
		        projectTask.setUpdatedAt(rs.getDate("task_updated_at").toString());
		       
		        
		  
		  	}
			rs.close();
			
			con.close();
		 return projectTaskList;
	}
	
	
	
	
	
	public void deleteProjectTask(int id) throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		String select="delete from task_tbl where task_id=?";
		PreparedStatement ps=con.prepareStatement(select);
		ps.setInt(1, id);
		
		ps.executeQuery();
		 
		ps.close();
		con.commit();
		con.close();
		  
	}
	
	
}
