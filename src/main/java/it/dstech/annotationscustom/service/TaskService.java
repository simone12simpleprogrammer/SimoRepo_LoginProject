package it.dstech.annotationscustom.service;

import java.util.List;
import it.dstech.annotationscustom.model.Task;

public interface TaskService {
	
	Task save(Task task);

	Task findByID(Long id);

	void delete(Long id);

	List<Task> getAllTasks();
}