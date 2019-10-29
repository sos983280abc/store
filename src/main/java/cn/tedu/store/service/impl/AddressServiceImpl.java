package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.controller.ex.DistrictController;
import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.AddressSizeLimitException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
/**
 * 处理地址数据业务层的实现类
 * @author soft01
 *
 */
@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	public AddressMapper addressMapper;
	
	@Autowired
	public IDistrictService districtService;
	
	@Override
	public void addnew(Address address, Integer uid, String username) {
		//根据参数uid获取该用户的收货地址数据的数量
		Integer count = addressMapper.countByUid(uid);
		//判断数量是否大于或这等与限制值
		if(count > MAX_COUNT) {
			//是：抛出AddressSizeLimitException异常
			throw new AddressSizeLimitException("收货地址数量过大");
		}
		
		//判断收货地址数据的数量是否为0
		if(count.equals(0)) {
			//是：即将插入的收货地址是默认的 idDefault=1
			address.setIsDefault(1);
		}else {
			//否：即将插入的收货地址不是默认的 idDefault=0
			address.setIsDefault(0);
		}
		//补全数据：将idDefault封装到参数address中
		//补全数据：将参数uid封装到参数address中
		address.setUid(uid);
		//补全数据：将参数username封装为参数address中的createdUser和modifiedUser属性值
		address.setCreatedUser(username);
		address.setModifiedUser(username);
		//补全书锯：创建当前时间对象，封装为参数address中的createdTime和modifiedTime属性值
		address.setCreatedTime(new Date());
		address.setModifiedTime(new Date());
		//补全省市区的名称
		address.getProvinceCode();
		District province = districtService.getByCode(address.getProvinceCode());
		if(province != null) {
			address.setProvinceName(province.getName());
		}
		District city = districtService.getByCode(address.getCityCode());
		if(city != null) {
			address.setCityName(city.getName());
		}
		District area = districtService.getByCode(address.getAreaCode());
		if(city != null) {
			address.setAreaName(area.getName());
		}
		//执行插入数据，并获取返回值
		Integer rows = addressMapper.insert(address);
		//判断返回值是否不为1
		if(rows != 1) {
			//是：抛出InsertException异常
			throw new InsertException("系统异常");
		}
	}

	@Override
	public List<Address> getByUid(Integer uid) {
		List<Address> list = addressMapper.findByUid(uid);
		for (Address address : list) {
			address.setCreatedTime(null);
			address.setCreatedUser(null);
			address.setModifiedTime(null);
			address.setModifiedUser(null);
		}
		return addressMapper.findByUid(uid);
	}

	@Override
	@Transactional
	public void setDefault(Integer aid, Integer uid, String username) {

		//根据参数aid查询收货地址
		Address result = addressMapper.findByAid(aid);
		//判断收货地址数据是否为null
		if(result == null) {
			//是：抛出AddressNotFoundException
			throw new AddressNotFoundException("收货地址数据为空");
		}
		
		//判断查询结果中的uid和参数uid是否不一致，使用eq
		if(!result.getUid().equals(uid)) {
			//是：抛出AccessDeniedException
			throw new AccessDeniedException("数据不存在");
		}
		
		//将当前用户的所有收货地址设置成非默认
		Integer rows = addressMapper.updateNonDefault(uid);
		if(rows < 1 ) {
			throw new UpdateException("更新数据是出现错误");
		}
		
		//将指定的收货地址设置为默认
		updateDefault(aid, username, new Date());
	}

	@Override
	@Transactional
	public void delete(Integer uid, Integer aid, String username) {
		
		// 根据参数aid查询收货地址数据
		Address result = addressMapper.findByAid(aid);
	    // 判断查询结果是否为null：AddressNotFoundException
		if(result == null) {
			throw new AddressNotFoundException("收货地址不存在");
		}

	    // 判断查询结果中的uid与参数uid是否不匹配：AccessDeniedException
		if(!result.getUid().equals(uid)) {
			throw new AccessDeniedException("拒绝访问，列入尝试访问他人的数据");
		}
		
	    // 执行删除，并获取返回值
		Integer del = addressMapper.deleteByAid(aid);
	    // 判断受影响行数是否不为1：DeleteException
		if(del != 1) {
			throw new DeleteException("删除失败");
		}

	    // 判断查询结果中的isDefault是否为0
		if(result.getIsDefault().equals(0)) {
			// 删除的不是默认收货地址，可直接结束：return;
			return;
		}

	    // 调用countByUid(uid)统计当前用户的收货地址数量
		Integer count = addressMapper.countByUid(uid);
	    // 判断数量是否为0
		if(count == 0) {
			// 当前用户已经没有收货地址，可直接结束：return;
			return;
		}

	    // 调用findLastModified(uid)找出最后修改的收货地址
		Address address = addressMapper.findLastModified(uid);
	    // 基于以上查询结果中的aid，将该收货地址设置为默认，并获取返回值
		updateDefault(address.getAid(), username, new Date());
	    // 判断返回值是否不为1：UpdateException
		
	}
	
	@Override
	public Address getByAid(Integer aid) {
		//检查查询结果是否为null，
		Address result = addressMapper.findByAid(aid);
		if(result == null) {
			throw new AddressNotFoundException("收货地址不存在");
		}
		return result;
	}

	private void updateDefault(Integer aid, String modifiedUser, Date modifiedTime) {
		Integer rows = addressMapper.updateDefault(aid, modifiedUser, modifiedTime);
		if(rows != 1 ) {
			throw new UpdateException("更新数据是出现错误");
		}
	}
}
