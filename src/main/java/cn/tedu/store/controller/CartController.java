package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.service.ICartService;
import cn.tedu.store.util.JsonResult;
/**
 * 处理购物车相关请求的控制器类
 * @author soft01
 *
 */
import cn.tedu.store.vo.CartVo;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController{

	@Autowired
	private ICartService cartService;
	
	@RequestMapping(path="add")
	public JsonResult<Void> addToCart(Integer pid, Integer num, HttpSession session){
		Integer uid = getUidFromSession(session);
		String usernamer = getUsernameFromSession(session);
		cartService.addToCart(uid, pid, num, usernamer);
		return new JsonResult<>(SUCCESS);
	}
	
	@GetMapping(path="/")
	public JsonResult<List<CartVo>> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<CartVo> data = cartService.findByUid(uid);
		return new JsonResult<>(SUCCESS, data);
	}
	
	@RequestMapping(path="{cid}/add_num")
	public JsonResult<Integer> getAddNum(@PathVariable("cid") Integer cid, HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		Integer data = cartService.addNum(cid, uid, username);
		return new JsonResult<>(SUCCESS, data);
	}
	
	@GetMapping(path="get_by_cids")
	public JsonResult<List<CartVo>> getByCids(Integer[] cids,HttpSession session){
		Integer uid = getUidFromSession(session);
		List<CartVo> data = cartService.getdByCids(cids, uid);
		return new JsonResult<>(SUCCESS, data);
	}
}
