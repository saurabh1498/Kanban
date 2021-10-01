package com.cg.kanban.model;


public class ProjectTask {

	private int id; 
	private String projectSequence;
	private String summary;
	private String acceptanceCriteria;
	private String status;
	private String priority;
	private String dueDate;//Date
	private String projectIdentifier;
	private String createdAt;//Date
	private String updatedAt; //Date
	private Backlog backlog;
	
	
	
	
	public ProjectTask() {
		super();
	}




	public ProjectTask(int id, String projectSequence, String summary, String acceptanceCriteria, String status,
			String priority, String dueDate, String projectIdentifier, String createdAt, String updatedAt,
			Backlog backlog) {
		super();
		this.id = id;
		this.projectSequence = projectSequence;
		this.summary = summary;
		this.acceptanceCriteria = acceptanceCriteria;
		this.status = status;
		this.priority = priority;
		this.dueDate = dueDate;
		this.projectIdentifier = projectIdentifier;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.backlog = backlog;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getProjectSequence() {
		return projectSequence;
	}




	public void setProjectSequence(String projectSequence) {
		this.projectSequence = projectSequence;
	}




	public String getSummary() {
		return summary;
	}




	public void setSummary(String summary) {
		this.summary = summary;
	}




	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}




	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getPriority() {
		return priority;
	}




	public void setPriority(String priority) {
		this.priority = priority;
	}




	public String getDueDate() {
		return dueDate;
	}




	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}




	public String getProjectIdentifier() {
		return projectIdentifier;
	}




	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}




	public String getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}




	public String getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}




	public Backlog getBacklog() {
		return backlog;
	}




	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}




	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", projectSequence=" + projectSequence + ", summary=" + summary
				+ ", acceptanceCriteria=" + acceptanceCriteria + ", status=" + status + ", priority=" + priority
				+ ", dueDate=" + dueDate + ", projectIdentifier=" + projectIdentifier + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", backlog=" + backlog + "]";
	}

	


	
	
	
}
