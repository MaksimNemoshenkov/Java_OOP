package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import db.HumanDAO;
import human.Human;

public class TestRead {

	public static void main(String[] args) {
		HumanDAO humanDAO = new HumanDAO(new File("/home/maks/SaveGame/test.txt"));
		try {
			Human human = humanDAO.read();
			System.out.println("name: "+human.getName()
			+ "\nSure name: " + human.getSurName()
			+ "\nData: "+ human.getDate()
			+ "\nSalary: " + human.getSalary()
			+ "\nPosition: " + human.getPosition());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
