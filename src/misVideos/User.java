package misVideos;

public class User {
	
	private String name;
	private String surname;
	private String userName;
	private String password;
	private String logInUserName;
	private String logInPassword;
	
	public User(String name, String surname, String userName, String password) {
		
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
		
	}
	
	public User(String logInUserName, String logInPassword) {
		this.logInUserName = logInUserName;
		this.logInPassword = logInPassword;
	}

	public String getLogInUserName() {
		return logInUserName;
	}

	public void setLogInUserName(String logInUserName) {
		this.logInUserName = logInUserName;
	}

	public String getLogInPassword() {
		return logInPassword;
	}

	public void setLogInPassword(String logInPassword) {
		this.logInPassword = logInPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "The user name is:  " + this.name + " " + this.surname + ", Created with the user name of: " +this.userName + ", with password: " + this.password;
		}
	

}
