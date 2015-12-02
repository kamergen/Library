package library.entities;

public class AuthorLists {

	private int id;
	private int idBook;
	private int idAuthor;

	public AuthorLists() {
	}

	public AuthorLists(int id, int idBook, int idAuthor) {
		this.id = id;
		this.idBook = idBook;
		this.idAuthor = idAuthor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

}
