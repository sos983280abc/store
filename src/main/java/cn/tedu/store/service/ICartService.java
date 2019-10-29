package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.vo.CartVo;

/**
 * 购物车的业务层接口
 * @author soft01
 *
 */
public interface ICartService {

	/**
	 * 添加购物车
	 * @param uid 用户id
	 * @param pid 产品id
	 * @param num 购物车数量
	 * @param usernamer 用户名
	 */
	void addToCart(Integer uid, Integer pid, Integer num, String usernamer);

	/**
	 * 查询某用户的购物车数据别表
	 * @param uid 用户id
	 * @return 返回购物车数据
	 */
	List<CartVo> findByUid(Integer uid);

	/**
	 * 将购物车中指定数据的商品数量增加1
	 * @param cid 购物车id
	 * @param uid 用户名id
	 * @param username 用户名
	 * @return 新的修改数量
	 */
	Integer addNum(Integer cid, Integer uid, String username);

	/**
	 * 根据若干个购物车数据id查询数据
	 * @param cids 若干个购物车id
	 * @param uid 用户id
	 * @return 匹配的购物车数据的列表
	 */
	List<CartVo> getdByCids(Integer[] cids, Integer uid);
	
}
