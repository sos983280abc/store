package cn.tedu.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItme;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTests {

	@Autowired
	OrderMapper orderMapper;
	
	@Test
	public void saveOrder() {
		Order order = new Order();
		order.setUid(9);
		order.setRecvName("长孙");
		order.setRecvPhone("123123123");
		Integer rows = orderMapper.saveOrder(order);
		System.err.println(rows);
	}
	
	@Test
	public void saveOrderItme() {
		OrderItme orderItme = new OrderItme();
		orderItme.setOid(1);
		orderItme.setPid(10000005);
		orderItme.setPrice(123123l);
		Integer rows = orderMapper.saveOrderItme(orderItme);
		System.err.println(rows);
	}
}
