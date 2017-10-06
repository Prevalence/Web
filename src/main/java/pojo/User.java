package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	/**
	 * 账户名
	 */

	private String userName;
	/**
	 * 密码（加密后）
	 */
	private String password;

	@Id
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
	}

}
