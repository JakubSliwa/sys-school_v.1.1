package model;

public class User {

	private Integer id;
	private Integer userGroupId;
	private String name;
	private String mail;
	private String password;

	public User() {

	}

	public User(Integer id, String name, String mail, String password, Integer userGroupId) {
		this.id = id;
		this.userGroupId = userGroupId;
		this.name = name;
		this.mail = mail;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
