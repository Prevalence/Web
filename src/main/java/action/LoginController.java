package action;

import com.opensymphony.xwork2.ActionSupport;

import bl.UserService;
import util.Encrypter;

public class LoginController extends ActionSupport {
	private String userName;
	private String password;
	private static final long serialVersionUID = 1L;
	private UserService userService = UserService.getImplement();

	@Override
	public String execute() throws Exception {
		System.out.println("userName" + userName);
		System.out.println("password" + password);
		if (userService.login(userName, Encrypter.encrypt(password, userName))) {
			return SUCCESS;
		}
		System.out.println("error");
		return ERROR;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("222222222222");
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
