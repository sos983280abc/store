package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVo;

/**
 * 购物车持久层接口
 * @author soft01
 *
 */
public interface CartMapper {

	/**
	 * 添加购物车
	 * @param cart 购物车信息
	 * @return 受影响行数
	 */
	Integer insert(Cart cart);
	
	/**
	 * 根据cid来修改购物车数量
	 * @param cid cid
	 * @param num 购物车数量
	 * @param modifiedUser 修改人
	 * @param modifiedTime 修改时间
	 * @return 受影响行数
	 */
	Integer updateNum(@Param("cid") Integer cid, @Param("num") Integer num, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 根据用户id和商品id来查询购物车信息
	 * @param uid 用户id
	 * @param pid 商品id
	 * @return 返回购物车信息
	 */
	Cart findByUidAndPid(@Param("uid") Integer uid, @Param("pid") Integer pid);
	
	/**
	 * 查询某用户的购物车数据别表
	 * @param uid 用户id
	 * @return 返回购物车数据
	 */
	List<CartVo> findByUid(Integer uid);
	
	/**
	 * 根据购物车id查询购物车详情
	 * @param cid 购物车id
	 * @return 购物车详情
	 */
	Cart findByCid(Integer cid);
	
	/**
	 * 根据若干个购物车数据id查询数据
	 * @param cids 若干个购物车id
	 * @return 匹配的购物车数据的列表
	 */
	List<CartVo> findByCids(Integer[] cids);
	
}
