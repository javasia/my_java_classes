package lesson4.checkpoint1.Frame_4_1_8;

public class Student {

	private String name;
	private String secondName;

	public Student() {

	}

	public Student(String name, String secondName) {
		this.name = name;
		this.secondName = secondName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public String toString() {
		return name + " " + secondName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null){
			return false;
		}
		if (obj instanceof Student){
			return this.toString().equalsIgnoreCase(((Student)obj).toString());
		}		
		return false;
	}

}
