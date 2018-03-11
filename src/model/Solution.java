package model;

import java.util.Date;

public class Solution {
	private Integer id;
	private Date created;
	private Date updated;
	private String description;
	private Integer excerciseId;
	private Integer userId;

	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", excerciseId=" + excerciseId + ", userId=" + userId + "]";
	}

	public Solution(Integer id, Date created, Date updated, String description, Integer excerciseId, Integer userId) {
		super();
		this.id = id;
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.excerciseId = excerciseId;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getExcerciseId() {
		return excerciseId;
	}

	public void setExcerciseId(Integer excerciseId) {
		this.excerciseId = excerciseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}