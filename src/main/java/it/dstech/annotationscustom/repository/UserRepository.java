package it.dstech.annotationscustom.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dstech.annotationscustom.model.User;

@Repository
public interface UserRepository extends JpaRepository < User, Long > {
    public User findByEmail(String email);
   
}