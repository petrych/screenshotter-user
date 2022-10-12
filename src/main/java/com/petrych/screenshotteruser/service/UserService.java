package com.petrych.screenshotteruser.service;

import com.petrych.screenshotteruser.common.errorhandling.UserEntityNotFoundException;
import com.petrych.screenshotteruser.persistence.model.ScreenshotterUser;
import com.petrych.screenshotteruser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile({"gcp", "local", "test"})
public class UserService implements IUserService {
	
	@Autowired
	protected IUserRepository userRepo;
	
	
	public UserService(IUserRepository userRepo) {
		
		this.userRepo = userRepo;
	}
	
	@Override
	public ScreenshotterUser findByUserName(String userName) {
		
		Optional<ScreenshotterUser> userOptional = userRepo.findByUserName(userName);
		
		if (userOptional.isEmpty()) throw new UserEntityNotFoundException(userName);
		
		return userOptional.get();
	}
	
}
