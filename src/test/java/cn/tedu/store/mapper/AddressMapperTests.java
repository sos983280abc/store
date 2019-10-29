package cn.tedu.store.mapper;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {

	@Autowired
	AddressMapper addressMapper;
	
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(3);
		address.setName("123");
		Integer rows = addressMapper.insert(address);
		System.err.println(rows);
	}
	
	@Test
	public void countByUid() {
		Integer uid = 3;
		Integer rows = addressMapper.countByUid(uid);
		System.out.println(rows);
	}
	
	@Test
	public void findByuid() {
		Integer uid = 9;
		List<Address> result = addressMapper.findByUid(uid );
		for (Address address : result) {
			System.err.println(address);
		}
	}
	
	@Test
	public void findByAid() {
		Integer aid = 30;
		Address result = addressMapper.findByAid(aid);
		System.err.println(result);
	}
	
	@Test
	public void updateNonDefault() {
		Integer uid = 9;
		Integer rows = addressMapper.updateNonDefault(uid);
		System.err.println(rows);
	}
	
	@Test
	public void updataDefault() {
		Integer aid = 31;
		String modifiedUser = "root2";
		Integer rows = addressMapper.updateDefault(aid, modifiedUser, new Date());
		System.err.println(rows);
	}
	
	@Test
	public void deleteByAid() {
		
		Integer aid = 32;
		Integer rows = addressMapper.deleteByAid(aid);
		System.err.println(rows);
	}
	
	@Test
	public void findLastModified() {
		Integer uid = 9;
		Address result = addressMapper.findLastModified(uid);
		System.err.println(result);
	}
}
