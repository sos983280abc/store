package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.User;

/**
 * User 数据库接口 处理用户数据的持久层接口
 * 
 * @author soft01
 *
 */
public interface UserMapper {

	/**
	 * 插入用户数据 添加用户信息
	 * 
	 * @param user
	 *            用户数据
	 * @return 首影响的行数
	 */
	Integer insert(User user);

	/**
	 * 根据用户名查询用户数据 查询用户名是否正确
	 * 
	 * @param username
	 *            用户名
	 * @return 匹配的用户数据，如果没有匹配的数据则返回null
	 */
	User findByUsername(String username);
	
	/**
	 * 修改密码
	 * @param uid 用户id
	 * @param password 用户密码
	 * @param salt 用户加密密码
	 * @param modifiedUser	修改人
	 * @param modifiedTime 修改时间
	 * @return 返回行数
	 */
	Integer updatePassword(
			@Param("uid") Integer uid, 
			@Param("password") String password, 
			@Param("modifiedUser") String modifiedUser, 
			@Param("modifiedTime") Date modifiedTime);

	/**
	 * 根据用户id查询用户数据
	 * @param uid 用户id
	 * @return
	 */
	User findByUid(Integer uid);
	
	/**
	 * 根据用户id修改个人资料
	 * @param user 用户属性
	 * @return 返回行数
	 */
	Integer updateInfo(User user);
	
	/**
	 * 上传头像
	 * @param uid 用户id
	 * @param avatar 用户头像
	 * @param modifiedUser 修改人
	 * @param modifiedTime 修改时间
	 * @return 返回行数
	 */
	Integer updateAvatar(@Param("uid") Integer uid,
			@Param("avatar") String avatar,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
}
