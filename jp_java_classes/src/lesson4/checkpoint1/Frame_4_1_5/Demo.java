package lesson4.checkpoint1.Frame_4_1_5;

public class Demo {

	public static void main(String[] args) {

		Student student0 = new Student("Ivan", "Ivanov");
		Student student1 = new Student("Sergey", "Sergeev");
		Student student2 = new Student("Roman", "Romanov");
		Student student3 = new Student("Dmitry", "Dmitriev");
		Student student4 = new Student("Petr", "Petrov");
		Student student5 = new Student("Oleg", "Olegov");

		Student[] students = new Student[5];
		students[0] = student0;
		students[1] = student1;
		students[2] = student2;
		students[3] = student3;
		students[4] = student4;

		Classroom classroom = new Classroom(students);

		classroom.enter(student5);
		classroom.leave(student0);
		classroom.getStudetCount();
		classroom.isPresent("Ivan", "Ivanov");
		classroom.isPresent("Sergey", "Sergeev");
		classroom.printStudentInfo();
	}

}
