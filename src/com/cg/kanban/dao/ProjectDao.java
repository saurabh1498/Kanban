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
import java.util.List;

import com.cg.kanban.model.Project;
import com.cg.kanban.model.User;
import com.cg.kanban.util.Dbutil;



public class ProjectDao {
	
	Connection con;
	public boolean addProject(Project project) throws SQLException, ParseException
	{
		
		//create table project_tbl(project_id number not null primary key ,project_name varchar(20),project_Identifier varchar(20) unique not null,project_description varchar(20) ,project_start_date date,project_end_date date,project_created_at date,project_updated_at date);
		con=Dbutil.getConnection();
		String insertCmd="insert into project_tbl values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insertCmd);
		ps.setInt(1,project.getId());
		ps.setString(2,project.getProjectName());
		ps.setString(3,project.getProjectIdentifier());
		ps.setString(4, project.getDescription());
		
//Start date		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf1.parse(project.getStartDate());
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
		ps.setDate(5, sqlStartDate);

		//End date		
		date = sdf1.parse(project.getEndDate());
		java.sql.Date sqlEndDate = new java.sql.Date(date.getTime());  
		ps.setDate(6, sqlEndDate);

//Created At		
		date = sdf1.parse(project.getCreatedAt());
		java.sql.Date sqlCreatedAt = new java.sql.Date(date.getTime());  
		ps.setDate(7, sqlCreatedAt);

//Updated At		
		date = sdf1.parse(project.getUpdatedAt());
		java.sql.Date sqlUpdatedAt = new java.sql.Date(date.getTime());  
		ps.setDate(8, sqlUpdatedAt);
		
				
		
		int n=ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();
		if(n>0)
		{
			return true;
		}return false;
	}
	
	public boolean updateProject(Project project) throws SQLException, ParseException
	{
		
		//create table project_tbl(project_id number,project_name varchar(20),project_Identifier varchar(20) NOT NULL,project_description varchar(20),project_start_date date,project_end_date date,project_created_at date,project_updated_at date, UNIQUE (project_Identifier) ;
		con=Dbutil.getConnection();
		String insertCmd="update project_tbl set project_name=?,project_Identifier=?,project_description=?,project_start_date=?,project_end_date=?,project_created_at=?,project_updated_at=? where project_id=?";
		PreparedStatement ps=con.prepareStatement(insertCmd);
		
		ps.setString(1,project.getProjectName());
		ps.setString(2,project.getProjectIdentifier());
		ps.setString(3, project.getDescription());
		
		
		
		//Start date		
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
				java.util.Date date = sdf1.parse(project.getStartDate());
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
				ps.setDate(4, sqlStartDate);

				//End date		
				date = sdf1.parse(project.getEndDate());
				java.sql.Date sqlEndDate = new java.sql.Date(date.getTime());  
				ps.setDate(5, sqlEndDate);

		//Created At		
				date = sdf1.parse(project.getCreatedAt());
				java.sql.Date sqlCreatedAt = new java.sql.Date(date.getTime());  
				ps.setDate(6, sqlCreatedAt);

		//Updated At		
				date = sdf1.parse(project.getUpdatedAt());
				java.sql.Date sqlUpdatedAt = new java.sql.Date(date.getTime());  
				ps.setDate(7, sqlUpdatedAt);
				
				ps.setInt(8,project.getId());	
		
		
	
		int n=ps.executeUpdate();
		ps.close();
		con.commit();
		con.close();
		if(n>0)
		{
			return true;
		}return false;
	}
	
	public void deleteProject(int id) throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		String select="delete from project_tbl where project_id=?";
		PreparedStatement ps=con.prepareStatement(select);
		ps.setInt(1, id);
		
		ps.executeQuery();
		 
		ps.close();
		con.commit();
		con.close();
		  
	}
	
	
	public Project getproject(int id) throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		String select="select * from project_tbl where project_id=?";
		PreparedStatement ps=con.prepareStatement(select);
		ps.setInt(1, id);
		
		 ResultSet rs = ps.executeQuery();
		 Project project=new Project();
		  while(rs.next()) 
		  {
   
		        project.setId(rs.getInt("project_id"));
		        project.setProjectName(rs.getString("project_name"));
		        project.setProjectIdentifier(rs.getString("project_identifier"));
		        project.setDescription(rs.getString("project_description"));
		        Date startDate=rs.getDate("project_start_date");
		        project.setStartDate(startDate.toString());
		        project.setEndDate(rs.getDate("project_end_date").toString()); 
		        project.setCreatedAt(rs.getDate("project_created_at").toString());
		        project.setUpdatedAt(rs.getDate("project_updated_at").toString());
		        
		        
		  
		  	}
			ps.close();
			con.commit();
			con.close();
		 return project;
	}
	

	public ArrayList<Project> getAllProject() throws SQLException
	{
		con=Dbutil.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from project_tbl");
		  ArrayList<Project> projectList = new ArrayList<Project>();
		
	
		  while(rs.next()) 
		  {		
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
		        projectList.add(project);
		        
		  
		  	}
			rs.close();
			
			con.close();
		 return projectList;
	}
	
	

}
