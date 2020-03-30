package it.dstech.annotationscustom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.annotationscustom.service.TaskService;
import it.dstech.annotationscustom.model.Task;
import it.dstech.annotationscustom.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task save(Task task) {
		// TODO Auto-generated method stub
		return  taskRepository.save(task);
	}

	@Override
	public Task findByID(Long id) {
		// TODO Auto-generated method stub
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()) {
            return task.get();
        } else {
            return null;
        }
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return (List<Task>) taskRepository.findAll();
	}

}