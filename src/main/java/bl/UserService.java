package bl;

import java.util.List;

import pojo.User;

/**
 * 
 * @author njdx 用户逻辑层接口
 */
public interface UserService {
	/**
	 * 登陆验证
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	public boolean login(String userName, String password);

	/**
	 * 获取实现类
	 * 
	 * @return Userbl对象
	 */
	public static UserService getImplement() {
		return new Userbl();
	}

	/**
	 * 注册
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	public boolean register(String userName, String password);

	/**
	 * 获取已经注册的用户名单
	 * 
	 * @return
	 */
	public List<User> getUserList();
}
