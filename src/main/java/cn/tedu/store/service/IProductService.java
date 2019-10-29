package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Product;

/**
 * 产品数据的业务层接口
 * @author soft01
 *
 */
public interface IProductService {

	/**
	 * 查询产品列表
	 * @return 产品列表
	 */
	List<Product> getHotList();
	
	/**
	 * 根据id查询产品列表
	 * @param id 
	 * @return 产品列表
	 */
	Product getById(Integer id);
}
