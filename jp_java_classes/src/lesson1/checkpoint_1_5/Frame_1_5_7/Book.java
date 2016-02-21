package lesson1.checkpoint_1_5.Frame_1_5_7;

public class Book {
	private String bookName;
	private String authorName;
	private String authorSurname;

	private String genre;

	public Book(String bookName, String authorName, String authorSurname, String genre) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.authorSurname = authorSurname;
		this.genre = genre;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public String getAuthorNameSurname() {
		return authorName + " " + authorSurname;
	}

	public String getGenre() {
		return genre;
	}

}
