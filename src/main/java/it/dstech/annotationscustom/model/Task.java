package it.dstech.annotationscustom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;




@Entity
@Table(name = "task")
public class Task {

    public Task(String description) {
        this.description = description;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;

	@Column(name = "description")
    @NotEmpty(message = "*Please provide your task")
    private String description;
    
    @Column(name = "created_date")
    private Date createdDate;
    
    @Column(name = "due_date")
    private Date dueDate;
    
    @Column(name = "priority")
    private int priority;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    
    public Task() {
    	
    }
    public Task(@NotEmpty(message = "*Please provide your task") String description, Date createdDate, Date dueDate,
			int priority, User user) {
		super();
		this.description = description;
		this.createdDate = createdDate;
		this.dueDate = dueDate;
		this.priority = priority;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}