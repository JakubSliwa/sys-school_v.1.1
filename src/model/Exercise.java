package model;

public class Exercise {
	private int id;
	private String title;
	private String decription;

	public Exercise(int id, String title, String decription) {
		this.id = id;
		this.title = title;
		this.decription = decription;
	}

	public Exercise(String title, String decription) {
		this.title = title;
		this.decription = decription;
	}

	public Exercise() {

	}

	@Override
	public String toString() {
		return "Tytuł zadania o id: " + id + ", to: " + title + ". Treść zadania: " + decription;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

}