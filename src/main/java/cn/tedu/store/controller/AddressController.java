package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.util.JsonResult;
/**
 * 处理地址数据相关请求的控制器类
 * @author soft01
 *
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{

	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(path="addnew")
	public JsonResult<Void> addnew(Address address, HttpSession session){
		//从session中获取uid和username
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		//执行增加
		addressService.addnew(address, uid, username);
		//响应成功
		return new JsonResult<>(SUCCESS);
	}
	
	@GetMapping("/")
	public JsonResult<List<Address>> getByUid(HttpSession session){
		//从session中获取uid
		Integer uid = getUidFromSession(session);
		//调用业务层对象查询数据
		List<Address> data = addressService.getByUid(uid);
		return new JsonResult<List<Address>>(SUCCESS, data);
	}
	
	@RequestMapping(path="{aid}/set_default")
	public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		addressService.setDefault(aid, uid, username);
		return new JsonResult<>(SUCCESS);
	}
	
	@RequestMapping(path="{aid}/delete")
	public JsonResult<Void> delete(HttpSession session,@PathVariable("aid") Integer aid){
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		addressService.delete(uid, aid, username);
		return new JsonResult<>(SUCCESS);
	}
}
