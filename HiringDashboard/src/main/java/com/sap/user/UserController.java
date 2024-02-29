package com.sap.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping()
	public User createTower(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping()
	public List<User> getAllUsers() {
		List<User> users = userService.getAll();
		return users;
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable long id) {
		User user = userService.getById(id);
		return user;
	}

	@GetMapping("/email/{email}")
	public User getByEmail(@PathVariable String email) {
		User user = userService.getByEmail(email);
		return user;
	}
}
