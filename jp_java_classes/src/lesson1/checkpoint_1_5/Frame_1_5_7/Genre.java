package lesson1.checkpoint_1_5.Frame_1_5_7;

import java.util.Arrays;

public class Genre {

	private Book[] booksByGenre;
	private String genre;

	public Genre() {
		booksByGenre = new Book[500];
	}

	public Book[] getBooksGenre() {
		return booksByGenre;
	}

	public String getGenre() {
		return genre;
	}

	public void addBook(Book book) {
		int idx = returnIdx();
		booksByGenre[idx] = book;
		this.genre = book.getGenre();
	}

	private int returnIdx() {
		int idx = 0;

		while (idx < booksByGenre.length) {
			if (booksByGenre[idx] == null) {
				return idx;
			}
			idx++;
		}

		increaseStorageSpace();
		return idx + 1;
	}

	private void increaseStorageSpace() {
		booksByGenre = Arrays.copyOf(booksByGenre, (int) (booksByGenre.length * 1.3));
	}

	public boolean deleteBook(Book book) {

		for (Book b : booksByGenre) {
			if (b == book) {
				b = null;
				return true;
			}
		}

		return false;
	}
}
