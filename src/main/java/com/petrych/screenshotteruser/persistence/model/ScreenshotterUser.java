package com.petrych.screenshotteruser.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ScreenshotterUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(unique = true, updatable = false)
	private final String userName;
	
	
	public ScreenshotterUser(String userName) {
		
		this.userName = userName;
	}
	
	// For Hibernate only
	private ScreenshotterUser() {
		
		this.userName = null;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		
		if (o == null || getClass() != o.getClass())
			return false;
		
		ScreenshotterUser screenshotterUser = (ScreenshotterUser) o;
		
		return userId.equals(screenshotterUser.userId) && userName.equals(screenshotterUser.userName);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(userId, userName);
	}
	
	@Override
	public String toString() {
		
		return "ScreenshotterUser{" +
				"userName='" + userName + '\'' +
				'}';
	}
	
	public String toLogString() {
		
		return "ScreenshotterUser{" +
				"id=" + userId +
				", userName='" + userName + '\'' +
				'}';
	}
	
	public Long getUserId() {
		
		return userId;
	}
	
	public void setUserId(Long userId) {
		
		this.userId = userId;
	}
	
	public String getUserName() {
		
		return userName;
	}
	
}
