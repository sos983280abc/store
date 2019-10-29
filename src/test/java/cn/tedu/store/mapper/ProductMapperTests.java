package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {

	@Autowired
	ProductMapper productMapper;
	
	@Test
	public void findHotList() {
		List<Product> result = productMapper.findHotList();
		for (Product product : result) {
			System.err.println(product);
		}
	}
	
	@Test
	public void findById() {
		Integer id = 10000002;
		Product result = productMapper.findById(id);
		System.err.println(result);
	}
}
