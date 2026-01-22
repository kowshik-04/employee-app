package com.company.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.employee.model.User;
import com.company.employee.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository repo;

    public User authenticate(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
}
