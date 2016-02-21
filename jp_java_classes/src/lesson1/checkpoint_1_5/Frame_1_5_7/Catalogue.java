package lesson1.checkpoint_1_5.Frame_1_5_7;

import java.util.Arrays;

public class Catalogue {

	private Author author;
	private Genre genre;
	private Author[] authorDatabase;
	private Genre[] genreDatabase;

	public Catalogue() {
		authorDatabase = new Author[500];
		genreDatabase = new Genre[500];
	}

	public Catalogue(Book book) {
		this();
		add(book);
	}

	public String searchAuthorName(String authorSurname, String authorName, String bookName,
			boolean isStricktMatchNameSurname, boolean printResult) {

		Book[] booksByAuthor = getBooksByAuthor(authorSurname, authorName, isStricktMatchNameSurname);

		if (booksByAuthor != null) {

			String res = null;

			for (int i = 0; booksByAuthor[i] != null && i < booksByAuthor.length; i++) {

				if (booksByAuthor[i].getBookName().equals(bookName)) {
					res = booksByAuthor[i].getAuthorNameSurname() + ": \"" + booksByAuthor[i].getBookName()
							+ "\". Genre: " + booksByAuthor[i].getGenre();

					if (printResult == true) {
						System.out.println(res);
					}

					return res;
				}
			}
		}
		return null;
	}

	private Book[] getBooksByAuthor(String authorSurname, String authorName, boolean isStricktMatchNameSurname) {

		Book[] booksByAuthor = null;

		for (int i = 0; authorDatabase[i] != null && i < authorDatabase.length; i++) {

			String surname = authorDatabase[i].getSurname();
			String name = authorDatabase[i].getName();

			if (isStricktMatchNameSurname == true) {
				if (surname.equals(authorSurname) && name.equals(authorName)) {
					return authorDatabase[i].getBooksByAuthor();
				}
			}

			System.out.println("Cannot find author's name strict match! Trying surname only...");

			if (surname.equals(authorSurname)) {
				booksByAuthor = authorDatabase[i].getBooksByAuthor();
				break;
			}
		}
		return booksByAuthor;
	}

	public void searchGenre(String genre, int page, int itemsPerScreen) {
		String[] bookByGenre = formSerchGenreResult(genre, page, itemsPerScreen);
		printBookByGenre(bookByGenre);
	}

	private String[] formSerchGenreResult(String genre, int page, int itemsPerScreen) {

		Book[] booksByGenre = getBooksByGenre(genre);

		if (booksByGenre != null) {

			String[] res = new String[booksByGenre.length];
			for (int i = page * itemsPerScreen; booksByGenre[i] != null && i < booksByGenre.length
					&& i < (page + 1) * itemsPerScreen; i++) {
				res[i] = booksByGenre[i].getAuthorNameSurname() + ": \"" + booksByGenre[i].getBookName() + "\"";
			}

			return res;
		}
		return null;
	}

	private void printBookByGenre(String[] bookByGenre) {

		String res = "";

		for (String str : bookByGenre) {
			if (str != null) {
				res += str + "\n";
			}
		}

		System.out.println(res);
	}

	private Book[] getBooksByGenre(String genre) {

		Book[] booksByGenre = null;

		for (int i = 0; genreDatabase[i] != null && i < genreDatabase.length; i++) {
			if (genreDatabase[i].getGenre().equals(genre)) {
				booksByGenre = genreDatabase[i].getBooksGenre();
			}
		}

		return booksByGenre;
	}

	private int addGenre() {
		int idx = returnIdx(genre);
		genreDatabase[idx] = genre;
		return idx;
	}

	private int addAuthor() {
		int idx = returnIdx(author);
		authorDatabase[idx] = author;
		return idx;
	}

	private int returnIdx(Genre genre) {
		int idx = 0;
		while (idx < genreDatabase.length) {
			if (genreDatabase[idx] == null) {
				return idx;
			}
			idx++;
		}

		increaseStorageSpace(genre);
		return idx + 1;
	}

	private int returnIdx(Author author) {
		int idx = 0;

		while (idx < authorDatabase.length) {
			if (authorDatabase[idx] == null) {
				return idx;
			}
			idx++;
		}

		increaseStorageSpace(author);
		return idx + 1;
	}

	private void increaseStorageSpace(Genre genre) {
		genreDatabase = Arrays.copyOf(genreDatabase, (int) (genreDatabase.length * 1.3));
	}

	private void increaseStorageSpace(Author author) {
		authorDatabase = Arrays.copyOf(authorDatabase, (int) (authorDatabase.length * 1.3));
	}

	public void delete(Book book) {
		setAuthor(book);
		setGenre(book);
		author.deleteBook(book);
		genre.deleteBook(book);
	}

	public void add(Book book) {

		setAuthor(book);
		setGenre(book);
		author.addBook(book);
		genre.addBook(book);

	}

	private int returnAuthorDatabaseIdx(Book book) {

		int idx = -1;

		for (int i = 0; i < authorDatabase.length; i++) {
			if (authorDatabase[i] != null && authorDatabase[i].getNameSurname().equals(book.getAuthorNameSurname())) {
				return i;
			}
		}
		return idx;
	}

	private void setAuthor(Book book) {
		int authorDatabaseIdx = returnAuthorDatabaseIdx(book);

		if (authorDatabaseIdx == -1) {
			author = new Author();
			authorDatabaseIdx = addAuthor();
		} else {
			author = authorDatabase[authorDatabaseIdx];
		}
	}

	private void setGenre(Book book) {

		int genreDatabaseIdx = returnGenreDatabaseIdx(book);

		if (genreDatabaseIdx == -1) {
			genre = new Genre();
			genreDatabaseIdx = addGenre();
		} else {
			genre = genreDatabase[genreDatabaseIdx];
		}
	}

	private int returnGenreDatabaseIdx(Book book) {

		int idx = -1;

		for (int i = 0; i < genreDatabase.length; i++) {
			if (genreDatabase[i] != null && genreDatabase[i].getGenre().equals(book.getGenre())) {
				return i;
			}
		}
		return idx;
	}
}
