package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Product;
/**
 * 产品数据的持久层接口
 * @author soft01
 *
 */
public interface ProductMapper {

	/**
	 * 查询产品列表
	 * @return 产品列表
	 */
	List<Product> findHotList();
	
	/**
	 * 根据id查询产品列表
	 * @param id 
	 * @return 产品列表
	 */
	Product findById(Integer id);
	
}
