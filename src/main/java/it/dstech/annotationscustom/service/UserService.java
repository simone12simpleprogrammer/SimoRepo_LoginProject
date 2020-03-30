package it.dstech.annotationscustom.service;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import it.dstech.annotationscustom.dao.UserRegistrationDao;
import it.dstech.annotationscustom.model.User;
import it.dstech.annotationscustom.model.Task;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDao registration);
    
    Long count();
    
    void deleteById(Long userId);
    
    void addTasks(User user, List<Task> tasks);
	
}