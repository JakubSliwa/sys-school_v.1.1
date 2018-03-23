package model;

import java.util.Date;

public class Solution {
	private int id;
	private Date created;
	private Date updated;
	private String description;
	private int exerciseId;
	private int userId;

	@Override
	public String toString() {
		return "Rozwiązanie o id: " + id + ", utworzone: " + created + ", zaktualizowane: " + updated
				+ ". Treść tego zadania to: " + description + ". Zadanie jest przypisane do zadania o id: " + exerciseId
				+ " i do użytkwonika o id: " + userId;
	}

	public Solution(int id, Date created, Date updated, String description, int excerciseId, int userId) {
		this.id = id;
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.exerciseId = excerciseId;
		this.userId = userId;
	}

	public Solution(String description, int userGroupId, int exerciseId, Date created, Date updated) {

		this.description = description;
		this.userId = userGroupId;
		this.exerciseId = exerciseId;
		this.setCreated(created);
		this.setUpdated(updated);
	}

	public Solution(String description, int userGroupId, int exerciseId) {
		this.description = description;
		this.userId = userGroupId;
		this.exerciseId = exerciseId;
		this.setCreated(created);
		this.setUpdated(updated);
	}

	public Solution() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExcerciseId() {
		return exerciseId;
	}

	public void setExcerciseId(int excerciseId) {
		this.exerciseId = excerciseId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}