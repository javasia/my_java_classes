package lesson4.checkpoint1.Frame_4_1_8;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

	List<Student> students = new ArrayList<>();

	public Classroom(Student student) {
		enter(student);
	}

	public Classroom(List<Student> students) {
		this.students = new ArrayList<>(students);
	}

	public Classroom(Student[] students) {
		for (Student s : students) {
			enter(s);
		}
	}

	public List<Student> getStudents() {
		return new ArrayList<>(students);
	}

	public void enter(Student student) {
		students.add(student);
		System.out.println("Student " + student + " entered.");
	}

	public void leave(Student student) {
		students.remove(student);
		System.out.println("Student " + student + " left.");
	}

	public int getStudetCount() {
		System.out.println(students.size());
		return students.size();
	}

	public boolean isPresent(Student student) {
		return students.contains(student);
	}

	public void printStudentInfo() {
		for (Student s : students) {
			if (s != null) {
				System.out.println(s);
			}
		}
	}
	
	
		
	

}
