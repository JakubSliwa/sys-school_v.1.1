package model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

	private String name;
	private String email;
	private String password;
	private int userGroupId;
	private int id;

	public User() {

	}

	public User(String name, String email, String password, int userGroupId) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.userGroupId = userGroupId;
	}

	public User(String name, String email, String password, int userGroupId, int id) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.userGroupId = userGroupId;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Imię użytkownika to: " + name + ", email to: " + email + ", id to: " + id + ", id jego groupy to: "
				+ userGroupId;

	}

	public int getId() {
		return id;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setMail(String mail) {
		this.email = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

}
