package lesson4.checkpoint1.Frame_4_1_5;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

	List<Student> students = new ArrayList<>();

	public Classroom(Student student) {
		enter(student);
	}

	public Classroom(List<Student> students) {
		this.students = students;
	}

	public Classroom(Student[] students) {
		for (Student s : students) {
			this.students.add(s);
		}
	}

	public List<Student> getStudents() {
		return students;
	}

	public void enter(Student student) {
		students.add(student);
		System.out.println("Student " + student.name + " " + student.secondName + " added.");
	}

	public void leave(Student student) {
		students.remove(student);
		System.out.println("Student " + student.name + " " + student.secondName + " left.");
	}

	public int getStudetCount() {
		System.out.println(students.size());
		return students.size();
	}

	public boolean isPresent(String name, String secondName) {
		for (Student s : students) {
			if (s.name.equals(name) && s.secondName.equals(secondName)) {
				System.out.println("Student " + s.name + " " + s.secondName + " is presnet.");
				return true;
			}
		}
		System.out.println("Student " + name + " " + secondName + " is not presnet.");
		return false;
	}

	public void printStudentInfo() {
		for (Student s : students) {
			if (s != null) {
				System.out.println(s.name + " " + s.secondName);
			}
		}
	}

}
