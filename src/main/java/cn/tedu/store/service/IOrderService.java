package cn.tedu.store.service;

import cn.tedu.store.entity.Order;

/**
 * 订单和订单商品业务层接口
 * @author soft01
 *
 */
public interface IOrderService {

	Order createOrder(Integer aid, Integer[] cids, Integer uid, String username);
	
}
