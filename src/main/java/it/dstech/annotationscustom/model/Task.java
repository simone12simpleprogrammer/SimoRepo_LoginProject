package it.dstech.annotationscustom.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task implements Runnable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long id;

    private String taskTitle;
	
	private String type;
	
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime expiredDate;
	
	private boolean isCarryOut;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDateTime expiredDate) {
		this.expiredDate = expiredDate;
	}

	public boolean isCarryOut() {
		return isCarryOut;
	}

	public void setCarryOut(boolean isCarryOut) {
		this.isCarryOut = isCarryOut;
	}
   
	@Override
	public void run() {
		System.out.println("prova");
	}
}