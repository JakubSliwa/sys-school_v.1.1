package model;

public class UserGroup {

	private int id;
	private String userGroupName;

	public UserGroup() {

	}

	public UserGroup(int id, String name) {
		this.id = id;
		this.userGroupName = name;
	}

	public UserGroup(String name) {
		this.userGroupName = name;
	}

	@Override
	public String toString() {
		return "Nazwa grupy to " + userGroupName + ", a jej id to: " + id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}
}
