package com.cg.kanban.model;


public class Backlog {
	
	private int id; 
	private String pTSequence;
	private String projectIdentifier;
	private Project project;
	private ProjectTask projectTasks;
	public Backlog() {
		super();
	}
	
	public Backlog(int id, String pTSequence, String projectIdentifier) {
		super();
		this.id = id;
		this.pTSequence = pTSequence;
		this.projectIdentifier = projectIdentifier;
	}

	public Backlog(int id, String pTSequence, String projectIdentifier, Project project, ProjectTask projectTasks) {
		super();
		this.id = id;
		this.pTSequence = pTSequence;
		this.projectIdentifier = projectIdentifier;
		this.project = project;
		this.projectTasks = projectTasks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpTSequence() {
		return pTSequence;
	}
	public void setpTSequence(String pTSequence) {
		this.pTSequence = pTSequence;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public ProjectTask getProjectTasks() {
		return projectTasks;
	}
	public void setProjectTasks(ProjectTask projectTasks) {
		this.projectTasks = projectTasks;
	}
	@Override
	public String toString() {
		return "Backlog [id=" + id + ", pTSequence=" + pTSequence + ", projectIdentifier=" + projectIdentifier
				+ ", project=" + project + ", projectTasks=" + projectTasks + "]";
	}
	
	
	
}
