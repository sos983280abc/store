package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {

	
	@Autowired IAddressService iAddressService;
	
	@Test
	public void addnew() {
		try {
			Integer uid = 3;
			String username = "root";
			Address address = new Address();
			address.setUid(2);
			address.setName("asd");
			iAddressService.addnew(address, uid, username);
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void setDefault() {
		try {
			Integer aid = 36;
			Integer uid = 9;
			String username = "root22";
			iAddressService.setDefault(aid, uid, username);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void delete() {
		try {
			Integer uid = 9;
			Integer aid = 35;
			String username = "root";
			iAddressService.delete(uid, aid, username);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
