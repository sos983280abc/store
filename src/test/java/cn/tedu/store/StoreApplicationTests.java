package cn.tedu.store;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	public DataSource dataSource;
	
	@Test
	public void getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		System.err.println(conn);
	}
	
	@Test
	public void md5() {
		String salt = UUID.randomUUID().toString();
		String password = "123";
		String md5Password = DigestUtils.md5DigestAsHex((password+salt).getBytes());
		System.err.println(md5Password);
	}
	
	@Test
	public void md5x() {
		String salt = UUID.randomUUID().toString();
		String password ="123";
		for (int i = 0; i < 5; i++) {
			password = DigestUtils.md5DigestAsHex((password+salt).getBytes());
			System.err.println(password);
		}
	}
}
