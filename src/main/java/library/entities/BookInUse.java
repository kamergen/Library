package library.entities;

import java.sql.Date;

public class BookInUse {

	int id;
	int id_user;
	int id_book;
	int bookStatus;
	Date startDate;
	Date endDate;

	public BookInUse(int id, int id_user, int id_book, int bookStatus, Date startDate, Date endDate) {

		this.id = id;
		this.id_user = id_user;
		this.id_book = id_book;
		this.bookStatus = bookStatus;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public BookInUse(int id_user, int id_book) {
		this.id_user = id_user;
		this.id_book = id_book;
	}

	public BookInUse() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public int getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(int bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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
		BookInUse other = (BookInUse) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
