package com.petrych.screenshotteruser.web.controller;

import com.petrych.screenshotteruser.persistence.model.ScreenshotterUser;
import com.petrych.screenshotteruser.service.IUserService;
import com.petrych.screenshotteruser.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	public UserController(IUserService userService) {
		
		this.userService = userService;
	}
	
	// find - one
	
	@GetMapping("/by-username")
	public UserDto findByUserName(@RequestParam(name = "userName", defaultValue = "") String userName) {
		
		ScreenshotterUser screenshotterUser = userService.findByUserName(userName);
		
		return convertToDto(screenshotterUser);
	}
	
	// helper methods
	
	private UserDto convertToDto(ScreenshotterUser entity) {
		
		return new UserDto(entity.getUserId(), entity.getUserName());
	}
	
}
