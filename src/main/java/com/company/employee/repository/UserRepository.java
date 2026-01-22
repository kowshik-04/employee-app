package com.company.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.employee.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
