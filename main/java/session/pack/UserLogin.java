package session.pack;

public class UserLogin {
	private String userName;
	private String userPassword;
	/**
	 * @param userName
	 * @param userPassword
	 */
	public UserLogin(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	

}
