package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTests {

	@Autowired
	private IDistrictService districtService;
	
	@Test
	public void getByparent() {
		try {
			String parent = "120100";
			districtService.getByParent(parent);
			System.err.println("Ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByCode() {
		try {
			String code = "110111";
			District data = districtService.getByCode(code);
			System.err.println(data);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
