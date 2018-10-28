package test;

import java.io.*;


import db.HumanDAO;
import human.Human;

public class TestRead {

	public static void main(String[] args) {
		
		
		HumanDAO humanDAO = new HumanDAO(new File("/home/maks/SaveGame/test.txt"));
		try {
			for(int number=0; number<3;number++) {
			Human human = humanDAO.read(number);
			System.out.print(human);
			System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
