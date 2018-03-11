package model;

public class Exercise {
	private Integer id;
	private String title;
	private String decription;

	public Exercise(Integer id, String title, String decription) {
		super();
		this.id = id;
		this.title = title;
		this.decription = decription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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