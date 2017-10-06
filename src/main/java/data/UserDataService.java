package data;

public interface UserDataService {
	public static UserDataService getImplement() {
		return new UserData();
	}

	public boolean login(String userName, String password);

	public boolean register(String userName, String password);

}
