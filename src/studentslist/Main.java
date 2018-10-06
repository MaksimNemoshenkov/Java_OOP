package studentslist;

import java.util.Date;

public class Main {

	private static StudentList studentList;

	public static void main(String[] args) {
		studentList = new StudentList();

		studentList.add(new Student("Vasya", "Pupkin", new Date(1970, 3, 28)));
		studentList.add(new Student("Vova", "Ivanov", new Date(1970, 3, 28)));
		studentList.add(new Student("Ira", "Ivanova", new Date(1970, 3, 28)));
		studentList.add(new Student("Sveta", "Paraskovna", new Date(1970, 3, 28)));
		studentList.add(new Student("Vika", "Ivanov", new Date(1970, 3, 28)));
		studentList.add(new Student("Sasha", "Grey", new Date(1988, 3, 14)));
		studentList.add(new Student("Vova", "Ivanov2", new Date(1970, 3, 28)));
		studentList.add(new Student("Vova", "Ivanov", new Date(1970, 3, 28)));

		Student student;

		System.out.println("Find by name");
		int[] findName = studentList.find("Vova");
		if (findName != null) {
			for (int position : findName) {
				student = studentList.get(position);
				System.out.println("Name: " + student.getName() + "; Surename: " + student.getSurname()
						+ "; Birth date: " + student.getBirth());
			}
		} else
			System.out.println("search by name without results");

		System.out.println("Find by surename");
		int[] findSurename = studentList.findSurname("Grey");
		if (findSurename != null) {
			for (int position : findSurename) {
				student = studentList.get(position);
				System.out.println("Name: " + student.getName() + "; Surename: " + student.getSurname()
						+ "; Birth date: " + student.getBirth());
			}
		} else
			System.out.println("search by surename without results");

		System.out.println("Find by date");
		int[] findDate = studentList.findDateBirth(new Date(1970, 3, 28));
		if (findDate != null) {
			for (int position : findDate) {
				student = studentList.get(position);
				System.out.println("Name: " + student.getName() + "; Surename: " + student.getSurname()
						+ "; Birth date: " + student.getBirth());
			}
		} else
			System.out.println("search by date without results");
	}

}
