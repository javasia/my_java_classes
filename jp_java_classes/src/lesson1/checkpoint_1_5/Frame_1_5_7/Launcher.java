package lesson1.checkpoint_1_5.Frame_1_5_7;

public class Launcher {
	private static Catalogue cat = new Catalogue();
	private static Book[] books;
	private static Sampledata sp = new Sampledata();
	private static int page = 0;
	private final static int ITEMS_PER_SCREEN = 5;

	public static void main(String[] args) {

		generateInitData();

		System.out.println(
				"Searching for Author: " + books[0].getAuthorNameSurname() + ". Name: " + books[0].getBookName());
		cat.searchAuthorName(books[0].getAuthorSurname(), books[0].getAuthorName(), books[0].getBookName(), true, true);
		System.out.println("Demonstration of non-strict match: ");
		cat.searchAuthorName(books[0].getAuthorSurname(), books[0].getAuthorName() + "No", books[0].getBookName(), true,
				true);

		System.out.println();

		System.out.println("Searching for genre: " + books[0].getGenre() + "\n");
		cat.searchGenre(books[0].getGenre(), page++, ITEMS_PER_SCREEN);
		cat.searchGenre(books[0].getGenre(), page++, ITEMS_PER_SCREEN);
		cat.searchGenre(books[0].getGenre(), page++, ITEMS_PER_SCREEN);
		cat.searchGenre(books[0].getGenre(), page++, ITEMS_PER_SCREEN);
	}

	private static void generateInitData() {
		
		books = sp.returnSampleData();

		System.out.println("Printing sample database... \n");

		for (Book b : books) {
			if (b != null) {
				System.out.print(b.getAuthorName() + " ");
				System.out.print(b.getAuthorSurname() + ": ");
				System.out.print("\"" + b.getBookName() + "\" ");
				System.out.println(b.getGenre() + ".");
				cat.add(b);
			}
		}
		System.out.println();
	}

}
