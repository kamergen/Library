package library.entities;

public class NewBook {

	int id;
	String title;
	String publishingHouse;
	int years;
	int pageNumber;

	public NewBook(){
		
	}
	
	public NewBook(int id, String title, String publishingHouse, int years, int pageNumber) {
		this.id = id;
		this.title = title;
		this.publishingHouse = publishingHouse;
		this.years = years;
		this.pageNumber = pageNumber;
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

	
}
