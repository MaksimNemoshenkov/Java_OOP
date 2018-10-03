package studentslist;


import java.util.ArrayList;
import java.util.Date;

import javax.swing.SingleSelectionModel;

public class Main {

	private static ArrayList<Integer> listPocitionStudents;
	private static StudentList studentList;
	public static void main(String[] args) {
		studentList = new StudentList();
		
		studentList.addStudent(new Student("Vasya", "Pupkin", new Date(1970, 3, 28)));
		studentList.addStudent(new Student("Vova","Ivanov",new Date(1970, 3, 28)));
		studentList.addStudent(new Student("Ira","Ivanova",new Date(1970, 3, 28)));
		studentList.addStudent(new Student("Sveta","Paraskovna",new Date(1970, 3, 28)));
		studentList.addStudent(new Student("Vika","Ivanov",new Date(1970, 3, 28)));
		studentList.addStudent(new Student("Sasha","Grey",new Date(1988, 3, 14)));
		studentList.addStudent(new Student("Vova","Ivanov2",new Date(1970, 3, 28)));
		studentList.addStudent(new Student("Vova","Ivanov",new Date(1970, 3, 28)));
		
		System.out.println("Find by date");
		findStudentDate();
		System.out.println("Find by name");
		findStudentName();
		System.out.println("Find by surename");
		findStudentsSureame();
		
		
	}
	
	private static void findStudentName (){
		listPocitionStudents = studentList.getPisitionStudentName("Vova");	
		if(listPocitionStudents.size()>0) {
			Student student;
	for(Integer pocition: listPocitionStudents) {
		student = studentList.getStudent(pocition);
		System.out.println("Name: "+student.getName() +"; Surename: "+ student.getSurname() +"; Birth date: "+ student.getBirth());
			}
		}
	}
	private static void findStudentsSureame (){	
		listPocitionStudents = studentList.getPisitionStudentSurename("Ivanov");	
		if(listPocitionStudents.size()>0) {
			Student student;
	for(Integer pocition: listPocitionStudents) {
		student = studentList.getStudent(pocition);
		System.out.println("Name: "+student.getName() +"; Surename: "+ student.getSurname() +"; Birth date: "+ student.getBirth());
			}
		}
	}
	private static void findStudentDate (){	
		listPocitionStudents = studentList.getPisitionStudentBirth(new Date(1988, 3, 14));	
		if(listPocitionStudents.size()>0) {
			Student student;
	for(Integer pocition: listPocitionStudents) {
		student = studentList.getStudent(pocition);
		System.out.println("Name: "+student.getName() +"; Surename: "+ student.getSurname() +"; Birth date: "+ student.getBirth());
			}
		}
	}
}
