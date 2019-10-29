package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.ProductMapper;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.ex.ProductNotFoundException;
/**
 * 处理产品数据业务层的实现类
 * @author soft01
 *
 */
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	ProductMapper productMapper;
	
	@Override
	public List<Product> getHotList() {
		List<Product> list = findHotList();
		for (Product product : list) {
			product.setCategoryId(null);
			product.setStatus(null);
			product.setPriority(null);
			product.setCreatedUser(null);
			product.setCreatedTime(null);
			product.setModifiedTime(null);
			product.setModifiedUser(null);
		}
		return list;
	}
	
	@Override
	public Product getById(Integer id) {
		Product product = findById(id);
		product.setCategoryId(null);
		product.setStatus(null);
		product.setPriority(null);
		product.setCreatedUser(null);
		product.setCreatedTime(null);
		product.setModifiedTime(null);
		product.setModifiedUser(null);
		return product;
	}
	
	private List<Product> findHotList(){
		return productMapper.findHotList();
	}

	private Product findById(Integer id) {
		Product product = productMapper.findById(id);
		if(product == null) {
			throw new ProductNotFoundException("商品不存在");
		}
		return product;
	}
	

}
