package bl;

import data.UserDataService;

public class Userbl implements UserService {
	private static UserDataService userDataService = null;

	public Userbl() {
		if (userDataService==null) {
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

}
