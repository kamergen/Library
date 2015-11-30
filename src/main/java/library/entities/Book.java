package library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	private @Id @GeneratedValue int id;
	private String title;
	private String publishingHouse;
	private int years;
	private int pageNumber;
	private int idBook;
	
	public Book(int idBook, String title, String publishingHouse, int years, int pageNumber) {	
		this.idBook = idBook;
		this.title = title;
		this.publishingHouse = publishingHouse;
		this.years = years;
		this.pageNumber = pageNumber;
	}
	
/*	Book(int id,String idBook, String title, String publishingHouse, String years, String pageNumber) {	
		this.id = id;
		this.idBook = Integer.valueOf(idBook);
		this.title = title;
		this.publishingHouse = publishingHouse;
		this.years = Integer.valueOf(years);
		this.pageNumber = Integer.valueOf(pageNumber);
	}
*/	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getIdBook() {
		return idBook;
	}
	
	public int getId() {
		return id;
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
