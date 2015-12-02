package library.entities;

public class Author {

	private int id;
	private String firstName;
	private String lastName;
	private String info;
	private String photo;

	public Author() {
	}

	public Author(int id, String firstName, String lastName, String info, String photo) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.info = info;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
