package model;

import java.sql.Timestamp;
import java.util.Date;

public class Message {

	private int id;
	private int targetUserId;
	private Timestamp date;
	private String addedBy;
	private String text;
	private boolean isReaded;


	public Message(int targetUserId, String addedBy, String text) {
		this.targetUserId = targetUserId;
		this.addedBy = addedBy;
		this.text = text;
		
		
	}

	public Message(Timestamp date, int id, int targetUserId, String addedBy, String text,boolean isReaded) {

		this.id = id;
		this.targetUserId = targetUserId;
		this.date = date;
		this.addedBy = addedBy;
		this.text = text;
		this.isReaded=isReaded;
	
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
	
	public boolean isReaded() {
		return isReaded;
	}

	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}

	


	@Override
	public String toString() {
		return "Message [id=" + id + ", targetUserId=" + targetUserId + ", date=" + date + ", addedBy=" + addedBy
				+ ", text=" + text + "]";
	}

}
