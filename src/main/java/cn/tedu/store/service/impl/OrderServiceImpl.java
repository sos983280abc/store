package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItme;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVo;

/**
 * 处理订单和订单商品业务层的实现类
 * @author soft01
 *
 */
@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	OrderMapper orderMapper;

	@Autowired
	IAddressService addressService;

	@Autowired
	ICartService cartService;

	@Override
	@Transactional
	public Order createOrder(Integer aid, Integer[] cids, Integer uid, String username) {
		//通过aid参数查询收货地址数据
		Address result = addressService.getByAid(aid);
		//检查数据归属是否正确
		if(!result.getUid().equals(uid)) {
			throw new AccessDeniedException("非法访问");
		}

		//通过参数cids查询购物车数据，得到List<CartVo>
		List<CartVo> cart = cartService.getdByCids(cids, uid);
		//遍历List<CartVo>,计算商品的总价
		Long totalPrice = 0l;
		for (CartVo cartVo : cart) {
			totalPrice += cartVo.getRealPrice() * cartVo.getNum();
		}
		
		//创建当前时间对象
		Date date = new Date();
		
		//创建Order对象
		Order order = new Order();
		//封装Order属性：uid
		order.setUid(uid);
		//封装Order属性：recv_???
		order.setRecvName(result.getName());
		order.setRecvProvince(result.getProvinceName());
		order.setRecvCity(result.getCityName());
		order.setRecvArea(result.getAreaName());
		order.setRecvAddress(result.getAddress());
		order.setRecvPhone(result.getPhone());
		//封装Order属性：total_price（以上计算的商品总价）
		order.setTotalPrice(totalPrice);
		//封装Order属性：status(0)
		order.setStatus(0);
		//封装Order属性：order_time(now)
		order.setOrderTime(date);
		//封装Order属性：pay_type(null),pay_time(null)
		order.setPayType(null);
		order.setPayTime(null);
		//封装Order属性：4向日志
		order.setCreatedUser(username);
		order.setCreatedTime(new Date());
		order.setModifiedUser(username);
		order.setModifiedTime(new Date());
		//向t_order表中插入数据saveOrder(Order order)
		saveOrder(order);


		//遍历List<CartVo>
		for (CartVo cartVo : cart) {
			//--创建OrderItme对象
			OrderItme orderItme = new OrderItme();
			//--封装OrderItme属性:oid(order.getOid())
			orderItme.setOid(order.getOid());
			//--封装OrderItme属性:pid,title,image,price,num
			orderItme.setPid(cartVo.getPid());
			orderItme.setTitle(cartVo.getTitle());
			orderItme.setImage(cartVo.getImage());
			orderItme.setPrice(cartVo.getPrice());
			orderItme.setNum(cartVo.getNum());
			//--封装OrderItme属性:4向日志
			orderItme.setCreatedUser(username);
			orderItme.setCreatedTime(new Date());
			orderItme.setModifiedUser(username);
			orderItme.setModifiedTime(new Date());
			//--向t_order_itme表中插入若干条数据:saveOrderItme(OrderItme oderItme)
			saveOrderItme(orderItme);
		}
		//返回order对象，返回之前可以将部分数据设置为null
		order.setCreatedUser(null);
		order.setCreatedTime(null);
		order.setModifiedUser(null);
		order.setModifiedTime(null);
		return order;
	}

	private void saveOrder(Order order) {
		Integer rows = orderMapper.saveOrder(order);
		if(rows != 1) {
			throw new InsertException("插入订单出现错误");
		}
	}

	private void saveOrderItme(OrderItme orderItme) {
		Integer rows = orderMapper.saveOrderItme(orderItme);
		if(rows != 1) {
			throw new InsertException("插入产品出现错误");
		}
	}

}
