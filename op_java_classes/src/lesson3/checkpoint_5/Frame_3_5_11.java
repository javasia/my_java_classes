package lesson3.checkpoint_5;

public class Frame_3_5_11 {

	/**
	 * @version 2.1 added service echoes added usrInterdace
	 * mark input check format added
	 */

	// forming database from sample data sets
	// database String[n][][] is array of String[n][j] where:
	// "n" (0..2) is index of student names, subjects, marks databases
	// "i" is index of data inside subjects, marks or students databases
	// j is index of corresponding arrays of data in students and subject
	// databases
	// marks are defined by String divided by comas

	final static int MAX_STUDENTS = 100;
	final static int MAX_SUBJECTS = 50;
	final static int MAX_MARKS = 200;

	static boolean echo = false;

	static String[][][] data = buildDatabase();

	public static void main(String[] args) throws Exception {

		setServiceEcho(false); // turn on/off service messages
		writeSampleData(); // for demonstration purposes only
		usrInterface(); // please type into console

	}

	static void setServiceEcho(boolean set) {
		echo = set;
	}

	static String[][][] buildDatabase() {

		String[][] arStudents = new String[MAX_STUDENTS][];
		for (int i = 0; i < MAX_STUDENTS; i++) {
			arStudents[i] = new String[1];
		}

		String[][] arSubjects = new String[MAX_STUDENTS][];
		for (int i = 0; i < arSubjects.length; i++) {
			arSubjects[i] = new String[MAX_SUBJECTS];
		}

		String[][] arMarks = new String[MAX_STUDENTS][];
		for (int i = 0; i < arMarks.length; i++) {
			arMarks[i] = new String[MAX_SUBJECTS];
		}

		String[][][] data = new String[3][][];
		data[0] = arStudents;
		data[1] = arSubjects;
		data[2] = arMarks;

		return data;
	}

	static void writeSampleData() {

		// sample list of marks -- for demonstration purposes only
		String[][] arMarks = new String[5][];
		arMarks[0] = new String[] { "2", "2", "5", "5", "5", "4", "5" };
		arMarks[1] = new String[] { "2", "2", "5", "5", "5" };
		arMarks[2] = new String[] { "2", "2", "5", "5", "5", "4", "5", "3" };
		arMarks[3] = new String[] { "1", "1", "1", "5", "5", "4", "5", "2", "3", "4" };
		arMarks[4] = new String[] { "1", "1", "2", "5", "4", "5", "2", "3", "4" };

		// sample list of students -- for demonstration purposes only
		String[][] arStud = new String[5][];
		arStud[0] = new String[] { "Captain America" };
		arStud[1] = new String[] { "John Doe" };
		arStud[2] = new String[] { "Joanah Doe" };
		arStud[3] = new String[] { "Paul Newman" };
		arStud[4] = new String[] { "John Armstrong" };

		// sample list of subjects -- for demonstration purposes only
		String[][] arSubj = new String[5][];
		arSubj[0] = new String[] { "Math (40)", "Physics (40)", "Literature (40)", "English (40)", "Arts" };
		arSubj[1] = new String[] { "Joga (40)", "Athletics (40)", "Swimming (40)", "Running, (40)" };
		arSubj[2] = new String[] { "Electronics (40)", "Programming (40)", "System Administration (40)",
				"Algorithms (40)", "Operationg systems (40)", "Networks, (40)" };
		arSubj[3] = new String[] { "Building (40)", "Math (40)", "Home electrics, (40)" };
		arSubj[4] = new String[] { "Space (40)", "Planetology (40)", "Rocket engines (40)", "Astronomy, (40)" };

		for (int i = 0; i < arStud.length; i++) {
			for (String subj : arSubj[i]) {
				for (String mark : arMarks[i]) {
					writeDataBase(arStud[i][0], subj, mark);
				}
			}
		}

	}

	static void writeDataBase(String student, String subject, String mark) {

		// writeDataBase ("name and surname of a student", "subject (hours NN)",
		// "marks") if a new student name or a new subject name is entered, new
		// element will be added to database

		if (echo == true) {
			System.out.println("Writing...");
		}

		int studidx = 0;
		for (int i = 0; data[0][i] != null && data[0][i][0] != null && i < data[0].length; i++) {
			if (data[0][i][0].compareToIgnoreCase(student) == 0) {
				if (echo == true) {
					System.out.println("found stdidx: " + studidx);
				}
				break;
			}
			studidx = i + 1;
		}

		data[0][studidx] = new String[] { student };

		if (echo == true) {
			System.out.println("studidx: " + studidx);
			System.out.print("Student name: ");
			System.out.println(data[0][studidx][0]);
		}

		int subjidx = 0;
		for (int i = 0; data[1][studidx] != null && i < data[1][studidx].length && data[1][studidx][i] != null; i++) {
			if (data[1][studidx][i].compareToIgnoreCase(subject) == 0) {
				if (echo == true) {
					System.out.println("found subjidx: " + subjidx);
				}
				break;
			}
			subjidx = i + 1;
		}
		if (data[1][studidx] != null) {
			data[1][studidx][subjidx] = subject;
		} else {
			data[1][studidx] = new String[MAX_SUBJECTS];
			data[1][studidx][0] = subject;

		}

		if (echo == true) {
			System.out.println("subjidx: " + subjidx);
			System.out.print("Subject: ");
			System.out.println(data[1][studidx][subjidx]);

		}

		if (data[2][studidx] == null) {
			data[2][studidx] = new String[MAX_MARKS];
		}

		if (data[2][studidx][subjidx] != null) {
			data[2][studidx][subjidx] = data[2][studidx][subjidx] + mark + ", ";
		} else {
			data[2][studidx][subjidx] = mark + ", ";
		}

		if (echo == true) {
			System.out.print("Mark: ");
			System.out.println(data[2][studidx][subjidx]);
			System.out.println();
		}

	}

	static void printDataRange(String[][][] range) {

		if (range == null) {
			if (echo == true) {
				System.out.println("printDataRange(" + range + "): error - null parameter received!");
			}
		} else {
			for (int i = 0; range[1][i] != null && range[2][i] != null && range[0][i][0] != null
					&& i < range[1][i].length; i++) {
				System.out.println(range[0][i][0] + ":");
				for (int j = 0; range[1][i][j] != null && j < range[2][i].length; j++) {
					System.out.print(range[1][i][j] + ": ");
					System.out.print(range[2][i][j].substring(0, range[2][i][j].lastIndexOf(",")) + "\n");
				}
				System.out.println();
			}
		}
	}

	static String[][][] returnRange(String range, String value) {

		if (range != null && range.length() > 0 && value != null && value.length() > 0) {

			if (range.compareToIgnoreCase("student") == 0) {

				int idx = -1;

				for (int i = 0; i < data[0].length && data[0][i] != null && data[0][i][0] != null; i++) {
					if (value.compareToIgnoreCase(data[0][i][0]) == 0) {
						idx = i;
					}
				}

				if (idx != -1) {

					String[][][] res = new String[3][][];
					res[0] = new String[MAX_STUDENTS][];
					res[1] = new String[MAX_STUDENTS][];
					res[2] = new String[MAX_STUDENTS][];

					res[0][0] = data[0][idx];
					res[1][0] = data[1][idx];
					res[2][0] = data[2][idx];

					return res;
				}

				else {
					System.out.println("Error: no such student \"" + value + "\"");
					return null;
				}

			}

			else if (range.compareToIgnoreCase("subject") == 0) {

				int resIdx = 0;
				boolean foundSubj = false;
				String[][][] res = new String[3][][];
				res[0] = new String[MAX_STUDENTS][];
				res[1] = new String[MAX_STUDENTS][];
				res[2] = new String[MAX_STUDENTS][];

				for (int i = 0; i < data[0].length; i++) {
					for (int j = 0; j < data[1][i].length; j++)

						if (data[1][i][j] != null && data[1][i][j].indexOf("(") != -1 && value.compareToIgnoreCase(
								data[1][i][j].substring(0, data[1][i][j].indexOf("(")).trim()) == 0) {
							foundSubj = true;
							res[0][resIdx] = new String[1];
							res[0][resIdx][0] = data[1][i][j];
							res[1][resIdx] = new String[data[1].length];
							res[1][resIdx][0] = data[0][i][0];
							res[2][resIdx] = new String[data[2].length];
							res[2][resIdx++] = data[2][i];
						}
				}
				if (foundSubj == true) {
					return res;
				}

				else {
					System.out.println("Error: no such subject \"" + value + "\"");
					return null;
				}
			} else {
				if (echo == true) {
					System.out.println(
							"Illegal range parameters " + "String \"" + range + "\", " + "String \"" + value + "\"");
				}
				return null;
			}

		} else {
			if (echo == true) {
				System.out.println("returnRange(String \"" + range + "\", String \"" + value
						+ "\"): error - null and empty paraters are not allowed!");
			}
			return null;
		}
	}

	static void usrInterface() throws Exception {

		start: while (true) {
			System.out.println(
					"Please enter \"read\" to read data or \"write\" to write data. Enter \"end\" or \"exit\" to terminate class.");

			String toDo = inputToString().toLowerCase();

			if (toDo.equals("read")) {

				input_read: while (true) {

					System.out.println("You would like to " + toDo + ". \n"
							+ "Would you like to see all database, data per student or data per subject? Please enter:"
							+ " \"all\" \"student\" \"subject\" respectively.");

					String toRead = inputToString().toLowerCase();

					if (toRead.equals("all")) {
						printDataRange(data);
					} else if (toRead.equals("student")) {
						System.out.println("You would like to " + toDo + " " + toRead + ".");
						System.out.println("Please enter student Name and Surname devided by space...");
						printDataRange(returnRange("student", inputToString()));
					} else if (toRead.equals("subject")) {
						System.out.println("You would like to " + toDo + " " + toRead + ".");
						System.out.println("Please enter the name of subject...");
						printDataRange(returnRange("subject", inputToString()));
					} else {
						System.out.println("Wrong input! Try again...");
						continue input_read;
					}

					ask_to_continue_read: while (true) {
						System.out.println();
						System.out.println("Would you like to " + toDo + " other data?");
						System.out.print("Yes/No: ");
						String askToContinue = inputToString().toLowerCase();
						if (askToContinue.equals("yes")) {
							continue input_read;
						} else if (askToContinue.equals("no")) {
							continue start;
						} else {
							System.out.println("Wrong input! Try again...");
							continue ask_to_continue_read;
						}
					}
				}

			} else if (toDo.equals("write")) {

				input_write: while (true) {
					System.out.println("You would like to " + toDo + ". \n");
					System.out.println("Please enter student's Name and Surname devided by space...");
					System.out.println("If there's no such student in database, new element will be created.");
					String student = inputToString();

					System.out.println("Please enter name of name of subject and hours.");
					System.out.println("Format: subjectName (hours). You can skip hours if not needed.");
					System.out.println("If there's no such subject for a given student in database, "
							+ "new element will be created.");
					String subject = inputToString();

					while (true) {
						System.out.println(
								"Please input a mark from 1 to 5, than press \"Enter\". To finish input press \"Enter\""
										+ " for empy input.");
						String mark = inputToString();
						if (mark.equals("1") || mark.equals("2") || mark.equals("3") || mark.equals("4")
								|| mark.equals("5")) {
							writeDataBase(student, subject, mark);
							continue;
						} else if (mark.equals("")) {
							break;
						} else {
							System.out.println("Wrong format of mark input!");
							continue;
						}
					}

					ask_to_continue_write: while (true) {
						System.out.println();
						System.out.println("Would you like to " + toDo + " other data?");
						System.out.print("Yes/No: ");
						String askToContinue = inputToString().trim().toLowerCase();
						if (askToContinue.equals("yes")) {
							continue input_write;
						} else if (askToContinue.equals("no")) {
							continue start;
						} else {
							System.out.println("Wrong input! Try again...");
							continue ask_to_continue_write;
						}

					}

				}
			} else if (toDo.equals("end") ||toDo.equals("exit")) {
				break start;
			} else {
				System.out.println("Wrong input! Try again...");
				continue start;
			}

		}

	}

	static String inputToString() throws Exception {

		byte[] byteInput = new byte[300];

		System.in.read(byteInput);

		String strInput = "";

		for (int i = 0; byteInput[i] != 0 && i < byteInput.length; i++) {
			strInput = strInput + String.valueOf((char) byteInput[i]);
		}

		return strInput.trim();
	}

}