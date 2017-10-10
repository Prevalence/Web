package data;

import java.util.ArrayList;

import pojo.User;
import util.HQLTools;

public class UserData implements UserDataService {

	@Override
	public boolean login(String userName, String password) {
		@SuppressWarnings("unchecked")
		String rightPassword = ((ArrayList<String>) HQLTools
				.find("select password from User where userName='" + userName + "'")).get(0);
		System.out.println(password);
		System.out.println("right:" + rightPassword);
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

}
