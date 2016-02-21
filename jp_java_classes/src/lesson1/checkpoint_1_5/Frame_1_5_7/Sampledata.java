package lesson1.checkpoint_1_5.Frame_1_5_7;

public class Sampledata {

	private String[] genres = new String[] { "fantasy", "food", "computers", "fiction", "hystory", "theology",
			"philosophy", "drama", "western", "arts", "vocabulary" };
	private String[] bookNames = new String[] { "Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7", "Book8",
			"Book9", "Book10", "Book11", "Book12", "Book13", "Book14", "Book15", "Book16" };
	private final int name = 0;
	private final int surname = 1;
	private String[][] authors = new String[6][];
	private Book[] books = new Book[500];
	private Catalogue cat;

	Sampledata() {
		authors[0] = new String[2];
		authors[1] = new String[2];
		authors[2] = new String[2];
		authors[3] = new String[2];
		authors[4] = new String[2];
		authors[5] = new String[2];
		authors[0][name] = "John";
		authors[0][surname] = "Doe";
		authors[1][name] = "Luis";
		authors[1][surname] = "Armstrong";
		authors[2][name] = "Iven";
		authors[2][surname] = "Fomenkov";
		authors[3][name] = "Don Garcia";
		authors[3][surname] = "Markes";
		authors[4][name] = "Anna";
		authors[4][surname] = "Ahmetoff";
		authors[5][name] = "Karabas";
		authors[5][surname] = "Barabas";

	}

	public Book[] returnSampleData() {

		for (int i = 0, j = 0; i < authors.length; i++) {
			int rnd = (int) (Math.random() * 10);
			String genre = genres[rnd];
			for (String bookname : bookNames) {
				Book book = new Book(bookname, authors[i][name], authors[i][surname], genre);
				books[j++] = book;
			}
		}

		return books;
	}
}
