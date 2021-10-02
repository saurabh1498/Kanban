package com.cg.kanban.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.kanban.model.Backlog;
import com.cg.kanban.model.Project;
import com.cg.kanban.model.ProjectTask;
import com.cg.kanban.model.User;
import com.cg.kanban.util.Dbutil;

public class BacklogDao {
	
	

	Connection con;
	public boolean addBacklog(Backlog backlog) throws SQLException
	{

		con=Dbutil.getConnection();
		String insertCmd="insert into backlog_tbl values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(insertCmd);
		ps.setInt(1, backlog.getId());
		ps.setString(2, backlog.getpTSequence());
		ps.setString(3, backlog.getProjectIdentifier());

		int n=ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();
		if(n>0)
		{
			return true;
		}return false;
	}
	

	public ArrayList<Backlog> getAllBacklogs() throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("select * from ((backlog_tbl b INNER JOIN project_tbl p ON b.project_identifier=p.project_identifier) INNER JOIN project_task_tbl pt ON b.project_identifier=pt.project_identifier)");
		//create table backlog_tbl(backlog_id number,pt_sequence varchar(20),project_identifier varchar(20),primary key(backlog_id ),constraint fk_backlog_project foreign key (project_identifier) references project_tbl(project_identifier));
		 //SELECT * FROM (backlog_tbl b INNER JOIN project_tbl p ON b.project_identifier=p.project_identifier)
		  ArrayList<Backlog> backlogList = new ArrayList<>();
		  while(rs.next()) 
		  {
			  	
			  	
		        Backlog backlog=new Backlog();
		        
		        backlog.setId(rs.getInt("backlog_id"));
		        backlog.setpTSequence(rs.getString("pt_sequence"));
		        backlog.setProjectIdentifier(rs.getString("project_identifier"));
		        
		        Project project=new Project();
		        project.setId(rs.getInt("project_id"));
		        project.setProjectName(rs.getString("project_name"));
		        project.setProjectIdentifier(rs.getString("project_identifier"));
		        project.setDescription(rs.getString("project_description"));
		        Date startDate=rs.getDate("project_start_date");
		        project.setStartDate(startDate.toString());
		        project.setEndDate(rs.getDate("project_end_date").toString()); 
		        project.setCreatedAt(rs.getDate("project_created_at").toString());
		        project.setUpdatedAt(rs.getDate("project_updated_at").toString());
		        backlog.setProject(project);
		        
		        ProjectTask projectTask=new ProjectTask();
		        projectTask.setId(rs.getInt("task_id"));
		        projectTask.setProjectSequence(rs.getString("project_sequence"));
		        projectTask.setSummary(rs.getString("task_summary"));
		        projectTask.setAcceptanceCriteria(rs.getString("task_acceptance_criteria"));
		        projectTask.setStatus(rs.getString("task_status"));
		        projectTask.setPriority(rs.getString("task_priority"));
		        projectTask.setDueDate(rs.getDate("task_due_date").toString());
		        projectTask.setProjectIdentifier(rs.getString("project_identifier"));
		        projectTask.setCreatedAt(rs.getDate("task_created_at").toString());
		        projectTask.setUpdatedAt(rs.getDate("task_updated_at").toString());
		        
		        backlog.setProjectTasks(projectTask);
		        
		        backlogList.add(backlog);
		  
		  	}
			rs.close();
			
			con.close();
		 return backlogList;

		 
	}
	
	
	

}
