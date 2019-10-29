package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.IDistrictService;
/**
 * 处理省市区数据业务层的实现类
 * @author soft01
 *
 */
@Service
public class DistrictServiceImpl implements IDistrictService{

	@Autowired
	private DistrictMapper districtMapper;
	
	@Override
	public List<District> getByParent(String parent) {
		
		return districtMapper.findByParent(parent);
	}

	@Override
	public District getByCode(String code) {
		return districtMapper.findByCode(code);
	}

}
