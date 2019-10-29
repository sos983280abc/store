package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void reg() {
		try {
			User user = new User();
			user.setUsername("root");
			user.setPassword("1234");
			userService.reg(user);
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void login() {
		try {
			String username = "root";
			String password = "1234";
			User result = userService.login(username, password);
			System.err.println(result);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changePassword() {
		try {
			Integer uid = 9;
			String username = "root";
			String oldPassword = "12345";
			String newPassword = "1234";
			userService.changePassword(uid, username, oldPassword, newPassword);
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		try {
			Integer uid = 8;
			User result = userService.getByUid(uid);
			System.err.println(result);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeInfo() {
		try {
			User user = new User();
			Integer uid = 9;
			String username = "root";
			user.setEmail("123@123.123");
			userService.changeInfo(uid, username, user);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changeAvatar() {
		Integer uid = 9;
		String username = "root";
		String avatar = "头像";
		userService.changeAvatar(uid, username, avatar);
		System.err.println("ok");
	}
	
}
