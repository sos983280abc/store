package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTests {

	@Autowired
	private DistrictMapper districtMapper;
	
	@Test
	public void findByParent() {
		String parent = "120100";
		List<District> parents = districtMapper.findByParent(parent);
		System.err.println(parents.size());
		for (District district : parents) {
			System.out.println(district);
		}
	}
	
	@Test
	public void findByCode() {
		String code = "110101";
		 District parents = districtMapper.findByCode(code);
		System.err.println(parents);
	}
}
