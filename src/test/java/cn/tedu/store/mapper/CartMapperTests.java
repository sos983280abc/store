package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {

	@Autowired
	CartMapper cartMapper;
	
	@Test
	public void insert() {
		Cart cart = new Cart();
		cart.setUid(9);
		cart.setPid(10000002);
		cart.setNum(1);
		cart.setPrice(200l);
		Integer rows = cartMapper.insert(cart);
		System.err.println(rows);
	}
	
	@Test
	public void updateNum() {
		Integer cid = 1;
		Integer num = 2;
		String modifiedUser = "root";
		Integer rows = cartMapper.updateNum(cid, num, modifiedUser, new Date());
		System.err.println(rows);
	}
	
	@Test
	public void findByUidAndPid() {
		Integer uid = 9;
		Integer pid = 10000002;
		Cart result = cartMapper.findByUidAndPid(uid, pid);
		System.err.println(result);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 9;
		List<CartVo> cart = cartMapper.findByUid(uid);
		for (CartVo cartVo : cart) {
			System.err.println(cartVo);
		}
	}
	
	@Test
	public void findByCid() {
		Integer cid = 5;
		Cart result = cartMapper.findByCid(cid);
		System.err.println(result);
	}
	
	@Test
	public void findByCids() {
		Integer[] cids = {5,6};
		List<CartVo> result = cartMapper.findByCids(cids);
		for (CartVo cartVo : result) {
			System.err.println(cartVo);
		}
	}
}
