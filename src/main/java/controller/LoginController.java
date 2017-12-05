package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bl.UserService;
import pojo.User;

public class LoginController extends ActionSupport implements ModelDriven<User> {
	private List<User> userList;
	private User user = new User();
	String userName;
	String password;
	private static final long serialVersionUID = 1L;
	private UserService userService = UserService.getImplement();

	@Override
	public String execute() throws Exception {
		if (userService.login("123", "456")) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String register() {
		System.out.println(userName);
		System.out.println(password);
		if (userService.register(userName, password))
			return SUCCESS;
		return ERROR;
	}

	public String updateUserList() {
		userList = userService.getUserList();
		return SUCCESS;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String testMethod() {
		return "success";
	}

}
