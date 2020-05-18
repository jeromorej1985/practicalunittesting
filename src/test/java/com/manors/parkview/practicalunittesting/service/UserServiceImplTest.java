package com.manors.parkview.practicalunittesting.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.manors.parkview.practicalunittesting.model.User;
import com.manors.parkview.practicalunittesting.repository.UserDAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserServiceImplTest {
	private UserServiceImpl userServiceImpl;
	private UserDAO userDAO = mock(UserDAO.class);
	private SecurityService securityService = mock(SecurityService.class);
	private User user = mock(User.class);

	@Before
	public void setup(){
		userServiceImpl = new UserServiceImpl(userDAO, securityService);
	}

	@Test
	public void userShouldReceiveANewMd5PasswordWhenRequested() throws Exception {
		String nonMd5Password = "nonMd5Password";
		String passwordMd5 = "passwordMd5";
		
		when(user.getPassword()).thenReturn(nonMd5Password);
		when(securityService.md5(Mockito.anyString())).thenReturn(passwordMd5);

		userServiceImpl.assignPassword(user);
		verify(user).setPassword(eq(passwordMd5));
		verify(userDAO).updateUser(user);
	}

	@Test
	public void testUserServiceImpl() throws Exception {

	}

}
