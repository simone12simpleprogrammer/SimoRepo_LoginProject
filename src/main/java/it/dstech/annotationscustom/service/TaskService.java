package it.dstech.annotationscustom.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.dstech.annotationscustom.model.Task;
import it.dstech.annotationscustom.repository.TaskRepository;
import it.dstech.annotationscustom.model.User;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
@Transactional
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    
    public Task findById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
    
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
    
    public List<Task> findByUser(User user) {
        return taskRepository.findByUser(user);
    }
}