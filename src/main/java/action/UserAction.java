package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bl.UserService;
import pojo.User;
import util.Encrypter;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 用于接收form表单传来的userName，由Struts2框架自动注入
	 */
	// private String userName;
	/**
	 * 用于接收form表单传来的password，由Struts2框架自动注入
	 */
	// private String password;
	private User user;

	private static final long serialVersionUID = 1L;

	private UserService userService = UserService.getImplement();

	public String login() {
		String userName = user.getUserName();
		String password = user.getPassword();
		if (userService.login(userName, Encrypter.encrypt(password, userName))) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String register() {
		String userName = user.getUserName();
		String password = user.getPassword();
		if (userService.register(userName, Encrypter.encrypt(password, userName)))
			return SUCCESS;
		return ERROR;
	}

	@Override
	public User getModel() {
		if (user == null)
			user = new User();
		return user;
	}

	// public String getPassword() {
	// return password;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
	// }
	//
	// public String getUserName() {
	// return userName;
	// }
	//
	// public void setUserName(String userName) {
	// this.userName = userName;
	// }

}
