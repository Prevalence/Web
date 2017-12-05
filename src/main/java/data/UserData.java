package data;

import java.util.ArrayList;
import java.util.List;

import pojo.User;
import util.HQLTools;

public class UserData implements UserDataService {

	@Override
	public boolean login(String userName, String password) {
		@SuppressWarnings("unchecked")
		String rightPassword = ((ArrayList<String>) HQLTools
				.find("select password from User where userName='" + userName + "'")).get(0);
		if (rightPassword.equals(password))
			return true;
		return false;
	}

	@Override
	public boolean register(String userName, String password) {
		User user = new User(userName, password);
		HQLTools.add(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		return (List<User>) (HQLTools.find("from User"));
	}

}
