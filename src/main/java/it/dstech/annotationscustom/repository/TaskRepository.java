package it.dstech.annotationscustom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dstech.annotationscustom.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}