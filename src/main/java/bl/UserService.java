package bl;

public interface UserService {
	public boolean login(String userName, String password);

	public static UserService getImplement() {
		return new Userbl();
	}

	public boolean register(String userName, String password);
}
