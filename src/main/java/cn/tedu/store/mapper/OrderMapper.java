package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItme;

/**
 * 订单和订单商品的持久层接口
 * @author soft01
 *
 */
public interface OrderMapper {

	/**
	 * 创建订单
	 * @param order 订单详情
	 * @return 受影响行数
	 */
	Integer saveOrder(Order order);
	
	/**
	 * 创建订单商品
	 * @param orderItme 订单商品详情
	 * @return 受影响行数
	 */
	Integer saveOrderItme(OrderItme orderItme);
}
