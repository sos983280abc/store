package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Product;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.util.JsonResult;
/**
 * 处理产品数据相关请求的控制器类
 * @author soft01
 *
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{

	@Autowired
	private IProductService productService;
	
	@GetMapping(path="hot")
	public JsonResult<List<Product>> getHotList(){
		List<Product> data = productService.getHotList();
		return new JsonResult<List<Product>>(SUCCESS, data);
	}
	
	@GetMapping(path="{id}/details")
	public JsonResult<Product> getById(@PathVariable("id") Integer id){
		Product data = productService.getById(id);
		return new JsonResult<Product>(SUCCESS, data);
	}
}
