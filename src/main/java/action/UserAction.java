package action;

import com.opensymphony.xwork2.ActionSupport;

import bl.UserService;
import util.Encrypter;

public class UserAction extends ActionSupport {
	/**
	 * 用于接收form表单传来的userName，由Struts2框架自动注入
	 */
	private String userName;
	/**
	 * 用于接收form表单传来的password，由Struts2框架自动注入
	 */
	private String password;

	private static final long serialVersionUID = 1L;

	private UserService userService = UserService.getImplement();

	public String login() throws Exception {
		System.out.println("userName" + userName);
		System.out.println("password" + password);
		if (userService.login(userName, Encrypter.encrypt(password, userName))) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String register() {
		System.out.println("register");
		if (userService.register(userName, password))
			return SUCCESS;
		return ERROR;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
