package com.petrych.screenshotteruser.service;

import com.petrych.screenshotteruser.persistence.model.ScreenshotterUser;

public interface IUserService {
	
	ScreenshotterUser findByUserName(String userName);
	
}
