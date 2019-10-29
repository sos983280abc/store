package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Product;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

	@Autowired
	IProductService productService;

	@Test
	public void getHotList() {
		try {
			List<Product> result = productService.getHotList();
			for (Product product : result) {
				System.err.println(product);
			}
		}catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getById() {
		try {
			Integer id = 1000000;
			Product result = productService.getById(id);
			System.err.println(result);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
