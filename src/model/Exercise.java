package model;

public class Exercise {
	private int id;
	private String title;
	private String description;

	public Exercise(int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Exercise(String title, String decription) {
		this.title = title;
		this.description = decription;
	}

	public Exercise() {

	}

	@Override
	public String toString() {
		return "Tytuł zadania o id: " + id + ", to: " + title + ". Treść zadania: " + description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String decription) {
		this.description = decription;
	}

}