package cn.tedu.store.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.tedu.store.entity.Address;

/**
 * 处理收货地址的业务接口
 * @author soft01
 *
 */
public interface IAddressService {

	/**
	 * 每个用户最多允许创建的收货地址的数量
	 */
	int MAX_COUNT = 20;
	
	/**
	 * 添加收货地址
	 * @param address 收货地址数据
	 * @param uid 用户id
	 * @param username 用户名
	 */
	void addnew(Address address, Integer uid, String username);
	
	/**
	 * 根据用户id查询收货地址详情
	 * @param uid 用户id
	 * @return 该用户的收货地址列表
	 */
	List<Address> getByUid(Integer uid);
	
	/**
	 * 将指定的地址设置为默认地址
	 * @param aid 地址id
	 * @param uid 用户id
	 * @param username 用户名
	 */
	void setDefault(Integer aid, Integer uid, String username);
	
	/**
	 * 删除指定地址
	 * @param uid 用户id
	 * @param aid 地址id
	 * @param username 用户名
	 */
	void delete(Integer uid, Integer aid, String username);
	
	/**
	 * 根据aid获取地址信息
	 * @param aid 地址id
	 * @return 地址详情
	 */
	Address getByAid(Integer aid);
}
