package studentslist;

import java.util.ArrayList;
import java.util.Date;

public class StudentList {

	private ArrayList<Student> listStudents = new ArrayList<>();
	
	
	StudentList (){	
	}
	
	
	public void addStudent(Student student) {
	listStudents.add(student);
	}
	public Student getStudent(int numberStudent) {
		return listStudents.get(numberStudent);
	}
	public ArrayList<Integer> getPisitionStudentName(String name) {
		String studentName;
		
		ArrayList<Integer> masivNumberStudent = new ArrayList<>();
		
	for (int numberStudent = 0; numberStudent < listStudents.size(); numberStudent++) {
		studentName = listStudents.get(numberStudent).getName();
	if (studentName.equalsIgnoreCase(name)) {
		masivNumberStudent.add(numberStudent);
	}
}
return masivNumberStudent;
}		
	public ArrayList<Integer> getPisitionStudentSurename(String surename) {
		String studentSurename;
		ArrayList<Integer> masivNumberStudent = new ArrayList<>();
		for (int numberStudent = 0; numberStudent < listStudents.size(); numberStudent++) {
			studentSurename = listStudents.get(numberStudent).getSurname();
		if (studentSurename.equalsIgnoreCase(surename)) {
			masivNumberStudent.add(numberStudent);
			}
		}
		return masivNumberStudent;
		}
	public ArrayList<Integer>  getPisitionStudentBirth(Date birth) {
		Date birtStudent;
		ArrayList<Integer> masivNumberStudent = new ArrayList<>();		
		for(int numberStudent = 0; numberStudent < listStudents.size(); numberStudent++) {
			birtStudent = listStudents.get(numberStudent).getBirth();
			if(birth.getDay()==birtStudent.getDay()&&birth.getMonth()==birtStudent.getMonth()
					&&birth.getYear()==birtStudent.getYear()) {
				masivNumberStudent.add(numberStudent);
			}
		}
		return masivNumberStudent;
		}
}
