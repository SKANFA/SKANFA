package com.github.skanfa.skanfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.skanfa.skanfa.model.User;

/**
 * Repository interface that extends {@link JpaRepository} for class
 * {@link User}.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String name);
}
