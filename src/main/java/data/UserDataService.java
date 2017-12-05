package data;

import java.util.List;

import pojo.User;

/**
 * 用户数据层接口
 * 
 * @author njdx
 *
 */
public interface UserDataService {
	/**
	 * 获取用户数据层实现对象
	 * 
	 * @return UserData对象
	 */
	public static UserDataService getImplement() {
		return new UserData();
	}

	/**
	 * 登陆验证
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 验证结果
	 */
	public boolean login(String userName, String password);

	/**
	 * 注册
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 注册结果
	 */
	public boolean register(String userName, String password);

	/**
	 * 获取已注册的用户列表
	 * 
	 * @return 用户列表
	 */
	public List<User> getUserList();

}
