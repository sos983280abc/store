package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IProductService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVo;
/**
 * 购物车业务层实现类
 * @author soft01
 *
 */
@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private CartMapper cartMapper;

	@Autowired
	private IProductService productService;

	@Override
	public void addToCart(Integer uid, Integer pid, Integer num, String usernamer) {
		// 根据参数uid和pid查询数据
		Cart result = findByUidAndPid(uid, pid);
		// 判断查询结果是否为null
		if(result == null) {
			// -- 是
			// -- -- 通过productService查出商品价格
			Product price = productService.getById(pid);
			// -- -- 执行添加
			Cart cart = new Cart();
			cart.setUid(uid);
			cart.setPid(pid);
			cart.setNum(num);
			cart.setPrice(price.getPrice());
			cart.setCreatedUser(usernamer);
			cart.setCreatedTime(new Date());
			cart.setModifiedUser(usernamer);
			cart.setModifiedTime(new Date());
			insert(cart);
		}else {
			// -- 否
			// -- -- 从查询结果中获取原数量，和参数num相加，得到新数量
			Integer newNum = result.getNum() + num;
			// -- -- 执行更新数量
			updateNum(result.getCid(), newNum, usernamer, new Date());
		}
	}

	@Override
	public List<CartVo> findByUid(Integer uid) {
		return getByUid(uid);
	}

	@Override
	public Integer addNum(Integer cid, Integer uid, String username) {
		//根据参数cid查询购物车数据
		Cart result = addNum(cid);
		//判断查询结果是否为null:是CartNotFoundException
		if(result == null) {
			throw new CartNotFoundException("没有购物车数据");
		}

		//判断查询结果中的uid与参数uid是否不一致：是AccessDeniedException
		if(!result.getUid().equals(uid)) {
			throw new AccessDeniedException("非法访问");
		}
		
		//从查询结果中取出num，并加1
		Integer num = result.getNum()+1;
		//执行更新数量
		updateNum(cid, num, username, new Date());
		//返回新的数量
		return num;
	}
	
	@Override
	public List<CartVo> getdByCids(Integer[] cids, Integer uid) {
		//执行查询
		List<CartVo> list = findByCids(cids);
		////遍历查询结果，溢出非当前uid的数据
		Iterator<CartVo> it = list.iterator();
		while(it.hasNext()) {
			CartVo item = it.next();
			if(!item.getUid().equals(uid)) {
				System.err.println("找到数据归属的错误将移出"+item);
				it.remove();
			}
		}
		return list;
	}
	
	private List<CartVo> findByCids(Integer[] cids){
		return cartMapper.findByCids(cids);
	}

	private Cart addNum(Integer cid) {
		return cartMapper.findByCid(cid);
	}

	private List<CartVo> getByUid(Integer uid) {
		return cartMapper.findByUid(uid);
	}


	private void insert(Cart cart) {
		Integer rows = cartMapper.insert(cart);
		if(rows != 1) {
			throw new InsertException("添加购物车数据出现错误");
		}
	}

	private void updateNum(Integer cid, Integer num, String modifiedUser, Date modifiedTime) {
		Integer rows = cartMapper.updateNum(cid, num, modifiedUser, modifiedTime);
		if(rows != 1) {
			throw new InsertException("更新购物车数据出现错误");
		}
	}

	private Cart findByUidAndPid(Integer uid, Integer pid) {
		Cart cart = cartMapper.findByUidAndPid(uid, pid);
		return cart;
	}


}
