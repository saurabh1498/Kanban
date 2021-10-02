package com.cg.kanban.pi;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cg.kanban.model.Backlog;
import com.cg.kanban.model.Project;
import com.cg.kanban.model.User;
import com.cg.kanban.service.BacklogService;
import com.cg.kanban.service.ProjectService;
import com.cg.kanban.service.ProjectTaskService;
import com.cg.kanban.service.UserService;

public class Main {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
//		UserService service=new UserService();
//		ProjectService ser=new ProjectService();
//		System.out.println(service.getAllUsers());
//		
//		
//		User user=new User(3, "sanika", "sheetal@gmail.com", "7896133652", "sheetal30","zxcvbnm" , "active", "member"); 
//		
//		System.out.println( service.updateUser(user));
//		System.out.println(service.getUser(2));
//		service.deleteUser(2);
//		System.out.println(ser.getAllProjects());
//		System.out.println(ser.getProject(2));
//		
//		Project project=new Project(3,"petrol pump","pump mgmt","mgmt system","23-07-2021","23-09-2021","14-07-2021","20-07-2021");
//		System.out.println(ser.addProject(project));
		BacklogService bgService=new BacklogService();
		Backlog backlog=new Backlog(2, "kan234","kan_saurabh");
		//System.out.println(bgService.addBacklog(backlog));
		List<Backlog>bgList=bgService.getAllBacklogs();
		for(Backlog b : bgList)
		{
			System.out.println(b.getProject());
		}
//		ProjectTaskService projectTaskService=new ProjectTaskService();
//		System.out.println(projectTaskService.getAllProjectTasks());
//		
	}
	

}

