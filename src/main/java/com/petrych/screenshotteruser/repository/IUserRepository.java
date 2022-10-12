package com.petrych.screenshotteruser.repository;

import com.petrych.screenshotteruser.persistence.model.ScreenshotterUser;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface IUserRepository extends PagingAndSortingRepository<ScreenshotterUser, Long> {
	
	Optional<ScreenshotterUser> findByUserName(String userName);
	
}
