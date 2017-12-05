package bl;

import java.util.List;

import data.UserDataService;
import pojo.User;

/**
 * 用户逻辑实现类
 * 
 * @author njdx
 *
 */
public class Userbl implements UserService {
	/**
	 * 用户数据层接口对象
	 */
	private static UserDataService userDataService = null;

	public Userbl() {
		if (userDataService == null) {
			userDataService = UserDataService.getImplement();
		}
	}

	@Override
	public boolean login(String userName, String password) {
		boolean result = userDataService.login(userName, password);
		return result;
	}

	@Override
	public boolean register(String userName, String password) {
		boolean result = userDataService.register(userName, password);
		return result;
	}

	@Override
	public List<User> getUserList() {
		return userDataService.getUserList();
	}

}
