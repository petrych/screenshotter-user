package com.petrych.screenshotteruser.repository;

import com.petrych.screenshotteruser.persistence.model.ScreenshotterUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<ScreenshotterUser, Long> {
	
	ScreenshotterUser findByUserName(String userName);
	
}
