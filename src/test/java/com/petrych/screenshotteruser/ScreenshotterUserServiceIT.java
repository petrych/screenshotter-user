package com.petrych.screenshotteruser;

import com.petrych.screenshotteruser.persistence.model.ScreenshotterUser;
import com.petrych.screenshotteruser.service.IUserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Sql("/data.sql")
public class ScreenshotterUserServiceIT {
	
	@Autowired
	IUserService userService;
	
	@Value("${server.port}")
	private static String serverPort;
	
	@Value("${server.servlet.contextPath}")
	private static String contextPath;
	
	private static final String USERNAME_EXISTS = "richard";
	
	private static final String USERNAME_NOT_EXISTS = "alex";
	
	private static String baseUrl;
	
	private static WebTestClient client;
	
	
	@BeforeAll
	public static void init() {
		
		baseUrl = getBaseUrl();
		
		client = WebTestClient
				.bindToServer()
				.baseUrl(baseUrl)
				.responseTimeout(Duration.ofMillis(30000))
				.build();
		
	}
	
	@Test
	public void givenUserExists_whenfindByName_thenSuccess() {
		
		ScreenshotterUser screenshotterUser = userService.findByUserName(USERNAME_EXISTS);
		
		assertEquals(USERNAME_EXISTS, screenshotterUser.getUserName());
	}
	
	@Test
	public void givenUserNotExists_whenfindByName_thenNull() {
		
		ScreenshotterUser screenshotterUser = userService.findByUserName(USERNAME_NOT_EXISTS);
		
		assertNull(screenshotterUser);
	}
	
	
	private static String getBaseUrl() {
		
		return "http://localhost:" + serverPort +
				"/" + contextPath +
				"/users";
	}
	
}
