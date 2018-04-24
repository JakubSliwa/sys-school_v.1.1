package model;

import java.sql.Timestamp;
import java.util.Date;

public class Message {

	private int id;
	private int targetUserId;
	private Timestamp date;
	private String addedBy;
	private String text;

	public Message(int targetUserId, String addedBy, String text) {
		this.targetUserId = targetUserId;
		this.addedBy = addedBy;
		this.text = text;
	}

	public Message(int id, int targetUserId, Timestamp date, String addedBy, String text) {
		this.id = id;
		this.targetUserId = targetUserId;
		this.date = date;
		this.addedBy = addedBy;
		this.text = text;
	}

	public int getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(int targetUserId) {
		this.targetUserId = targetUserId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId() {
		return id;
	}

}
