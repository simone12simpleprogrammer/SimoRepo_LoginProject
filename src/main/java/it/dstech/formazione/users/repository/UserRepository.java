package it.dstech.formazione.users.repository;
import it.dstech.formazione.users.service.UserServiceImpl;
import it.dstech.formazione.users.model.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUserName(String userName);
}
