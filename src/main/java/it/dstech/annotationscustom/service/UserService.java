package it.dstech.annotationscustom.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import it.dstech.annotationscustom.model.User;
import it.dstech.annotationscustom.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}