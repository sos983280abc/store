package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;

/**
 * address 数据库接口 处理收货地址的持久层接口
 * @author soft01
 *
 */
public interface AddressMapper {

	/**
	 * 插入收货地址
	 * @param assress 收货地址属性
	 * @return 受影响行数
	 */
	Integer insert(Address address);
	
	/**
	 * 根据用户id统计收货地址的数量
	 * @param uid 用户iu
	 * @return 受影响行数
	 */
	Integer countByUid(Integer uid);
	
	/**
	 * 根据用户id查询收货地址详情
	 * @param uid 用户id
	 * @return 该用户的收货地址列表
	 */
	List<Address> findByUid(Integer uid);
	
	/**
	 * 修改非默认地址为默认地址
	 * @param aid 地址id
	 * @param modifiedUser 修改人
	 * @param modifiedTime 修改时间
	 * @return 受影响行数
	 */
	Integer updateDefault(@Param("aid") Integer aid, @Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

	/**
	 * 修改默认地址为非默认地址
	 * @param uid 用户id
	 * @return 受影响行数
	 */
	Integer updateNonDefault(Integer uid);
	
	/**
	 * 根据地址id查询地址详情
	 * @param aid 地址id
	 * @return 返回地址详情
	 */
	Address findByAid(Integer aid);

	/**
	 * 根据地址id删除
	 * @param aid 地址id
	 * @return 受影响行数
	 */
	Integer deleteByAid(Integer aid);
	
	/**
	 * 根据用户id查询地址全部信息根据修改时间排序
	 * @param uid 
	 * @return 返回地址详细信息
	 */
	Address findLastModified(Integer uid);

}

