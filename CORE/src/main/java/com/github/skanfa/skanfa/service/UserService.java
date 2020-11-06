package com.github.skanfa.skanfa.service;

import java.util.List;

import com.github.skanfa.skanfa.model.User;

/**
 * Service interface for class {@link User}.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface UserService {

	User register(User user);

	List<User> getAll();

	User findByUsername(String username);

	User findById(Long id);

	void delete(Long id);
}
