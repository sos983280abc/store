package cn.tedu.store.service;

import cn.tedu.store.entity.User;
/**
 * 处理用户数据的业务接口
 * @author soft01
 *
 */
public interface IUserService {

	/**
	 * 用户注册
	 * @param user 新用户数据
	 */
	void reg(User user);
	
	/**
	 * 用户登入
	 * @param username 用户名
	 * @param password	密码
	 * @return 成功登入用户的数据
	 */
	User login(String username, String password);
	
	/**
	 * 修改密码
	 * @param uid 用户id
	 * @param username 用户名
	 * @param oldPassword 用户原密码
	 * @param newPassword 用户新密码
	 */
	void changePassword(Integer uid, String username, String oldPassword,String newPassword);

	/**
	 * 根据用户id查询用户资料
	 * @param uid 用户id
	 * @return 返回用户资料如果没有匹配的数据返回null
	 */
	User getByUid(Integer uid);
	
	/**
	 *修改用户资料
	 * @param uid 用户id
	 * @param username 用户名
	 * @param user 新的用户资料
	 */
	void changeInfo(Integer uid, String username, User user);

	/**
	 * 上传头像
	 * @param uid 用户id
	 * @param username 用户名
	 * @param avatar 用户头像
	 */
	void changeAvatar(Integer uid, String username, String avatar);
}
