package com.github.skanfa.skanfa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.skanfa.skanfa.model.Status;
import com.github.skanfa.skanfa.model.User;

import lombok.Data;

/**
 * DTO class for user requests by ROLE_ADMIN
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String status;

	public User toUser() {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setStatus(Status.valueOf(status));
		return user;
	}

	public static AdminUserDto fromUser(User user) {
		AdminUserDto adminUserDto = new AdminUserDto();
		adminUserDto.setId(user.getId());
		adminUserDto.setUsername(user.getUsername());
		adminUserDto.setFirstName(user.getFirstName());
		adminUserDto.setLastName(user.getLastName());
		adminUserDto.setEmail(user.getEmail());
		adminUserDto.setStatus(user.getStatus().name());
		return adminUserDto;
	}
}
