package library.entities;

public class Book {

	private int id;
	private String title;
	private String publishingHouse;
	private int years;
	private int pageNumber;
	private String author;
	private String nameStatus;
	
	public Book(int id, String title, String author, String publishingHouse, int years, int pageNumber, String nameStatus) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.years = years;
		this.pageNumber = pageNumber;
		this.nameStatus = nameStatus;
	}
	
	public Book(int id, String title, String author, String publishingHouse, int years, int pageNumber) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.years = years;
		this.pageNumber = pageNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public Book() {

	}
}
