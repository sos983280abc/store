package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

	@Autowired
	UserMapper userMapper;
	
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123");
		Integer rows = userMapper.insert(user);
		System.err.println(rows);
	}
	
	@Test
	public void findByUsername() {
		String username = "service123213";
		User result = userMapper.findByUsername(username);
		System.err.println(result);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 7;
		User result = userMapper.findByUid(uid);
		System.out.println(result);
	}
	
	@Test
	public void updatePassword() {
		Integer uid = 7;
		String password = "1234";
		String modifiedUser = "root";
		Integer rows = userMapper.updatePassword(uid, password, modifiedUser, new Date());
		System.err.println(rows);
	}
	
	@Test
	public void updateInfo() {
		User user = new User();
		user.setUid(9);
		user.setPhone("123456");
		user.setGender(0);
		user.setModifiedTime(new Date());
		Integer rows = userMapper.updateInfo(user);
		System.err.println(rows);
	}
	
	@Test
	public void updateAvatar() {
		Integer uid = 9;
		String avatar = "123";
		String modifiedUser = "root";
		Integer rows = userMapper.updateAvatar(uid, avatar, modifiedUser, new Date());	
		System.err.println(rows);
	}
}
