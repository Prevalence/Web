package web;

import java.io.Serializable;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mailAdd;
	private boolean email;

	public Email(String mailAdd) {
		super();
		this.mailAdd = mailAdd;
	}

	public Email() {
		super();
	}

	public boolean isEmail() {
		String regex = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
		if (mailAdd.matches(regex)) {
			email = true;
		}
		return email;
	}

	public String getMailAdd() {
		return mailAdd;
	}

	public void setMailAdd(String mailAdd) {
		this.mailAdd = mailAdd;
	}

}
