package lesson4.checkpoint1.Frame_4_1_8;

public class Demo {

	public static void main(String[] args) {

		Student student0 = new Student("Ivan", "Ivanov");
		Student student1 = new Student("Sergey", "Sergeev");
		Student student2 = new Student("Roman", "Romanov");
		Student student3 = new Student("Dmitry", "Dmitriev");
		Student student4 = new Student("Petr", "Petrov");
		Student student5 = new Student("Oleg", "Olegov");

		Student[] students = new Student[6];
		students[0] = student0;
		students[1] = student1;
		students[2] = student2;
		students[3] = student3;
		students[4] = student4;
		students[5] = student5;

		Classroom classroom = new Classroom(students);

		classroom.leave(new Student("Dmitry", "Dmitriev"));
		classroom.getStudetCount();
		System.out.println(classroom.isPresent(new Student("Oleg", "Olegov")));
		classroom.printStudentInfo();
		
	}

}
