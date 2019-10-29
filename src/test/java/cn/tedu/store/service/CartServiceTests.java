package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.vo.CartVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {

	@Autowired
	private ICartService cartService;
	
	@Test
	public void addnew() {
		try {
			Integer uid = 1;
			Integer pid = 10000004;
			Integer num = 1;
			String usernamer = "root";
			cartService.addToCart(uid, pid, num, usernamer);
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		try {
			Integer uid = 9;
			List<CartVo> cart = cartService.findByUid(uid);
			for (CartVo cartVo : cart) {
				System.err.println(cartVo);
			}
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void addNum() {
		try {
			Integer cid = 5;
			Integer uid = 9;
			String username = "root1";
			Integer rows = cartService.addNum(cid, uid, username);
			System.err.println(rows);
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByCids() {
		try {
			Integer[] cids = {5,6};
			Integer uid = 9;
			List<CartVo> result = cartService.getdByCids(cids, uid);
			for (CartVo cartVo : result) {
				System.err.println(cartVo);
			}
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
