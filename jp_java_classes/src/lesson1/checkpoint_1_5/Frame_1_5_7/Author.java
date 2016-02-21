package lesson1.checkpoint_1_5.Frame_1_5_7;

import java.util.Arrays;

public class Author {

	private Book[] booksByAuthor;
	private String name;
	private String surname;

	private String nameSurname;

	public Author() {
		booksByAuthor = new Book[500];

	}

	public Book[] getBooksByAuthor() {
		return booksByAuthor;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getNameSurname() {
		return name + " " + surname;
	}

	public void addBook(Book book) {
		int idx = returnIdx();
		booksByAuthor[idx] = book;
		this.name = book.getAuthorName();
		this.surname = book.getAuthorSurname();
	}

	private int returnIdx() {
		int idx = 0;

		while (idx < booksByAuthor.length) {
			if (booksByAuthor[idx] == null) {
				return idx;
			}
			idx++;
		}

		increaseStorageSpace();
		return idx + 1;
	}

	private void increaseStorageSpace() {
		booksByAuthor = Arrays.copyOf(booksByAuthor, (int) (booksByAuthor.length * 1.3));
	}

	public boolean deleteBook(Book book) {

		for (Book b : booksByAuthor) {
			if (b == book) {
				b = null;
				return true;
			}
		}

		return false;
	}

}
