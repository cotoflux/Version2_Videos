package misVideos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User {
	
	private String name;
	private String surname;
	private String userName;
	private String password;
	private Calendar dateRegister;
	List<Video>listVideosForUser = new ArrayList<Video>();
	
	public List<Video> getListVideosForUser() {
		return listVideosForUser;
	}

	public void setListVideosForUser(List<Video> listVideosForUser) {
		this.listVideosForUser = listVideosForUser;
	}

	public void addVideoToUser(Video video) {
		this.listVideosForUser.add(video);
	}
	
	public User(String name, String surname, String userName, String password, Calendar dateRegister) {
		
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
		this.dateRegister = dateRegister;
		this.listVideosForUser= new ArrayList<Video>();
		
	}
	public User(String name, String surname, String userName, String password) {
		
		this.name = name;
		this.surname = surname;
		this.userName = userName;
		this.password = password;
		this.listVideosForUser= new ArrayList<Video>();
		
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listVideosForUser == null) ? 0 : listVideosForUser.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (listVideosForUser == null) {
			if (other.listVideosForUser != null)
				return false;
		} else if (!listVideosForUser.equals(other.listVideosForUser))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	

}
