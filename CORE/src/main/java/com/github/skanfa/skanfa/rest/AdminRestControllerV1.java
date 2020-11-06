package com.github.skanfa.skanfa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.skanfa.skanfa.dto.AdminUserDto;
import com.github.skanfa.skanfa.model.User;
import com.github.skanfa.skanfa.service.UserService;

/**
 * REST controller for ROLE_ADMIN requests.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {

	private final UserService userService;

	@Autowired
	public AdminRestControllerV1(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "users/{id}")
	public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
		User user = userService.findById(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		AdminUserDto result = AdminUserDto.fromUser(user);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
