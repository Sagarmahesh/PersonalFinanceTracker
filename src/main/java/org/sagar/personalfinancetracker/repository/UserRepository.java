package org.sagar.personalfinancetracker.repository;

import org.sagar.personalfinancetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
