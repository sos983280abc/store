package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {

	@Autowired
	IOrderService orderService;
	
	@Test
	public void addnew() {
		try {
			Integer aid = 53;
			Integer[] cids = {5,6};
			Integer uid = 9;
			String username = "root";
			orderService.createOrder(aid, cids, uid, username);
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
