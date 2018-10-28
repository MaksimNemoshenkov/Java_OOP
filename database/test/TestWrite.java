package test;

import java.io.*;
import java.util.Date;

import db.HumanDAO;
import human.Human;

public class TestWrite {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		HumanDAO humanDAO = new HumanDAO(new File("/home/maks/SaveGame/test.txt"));
		Human human[] = new Human[3];
		human[0] = new Human("Sasha", "Grey",new Date(1988, 03, 14), "actress", 1000.10);
		human[1] = new Human("Jesse", "Jane",new Date(1980, 07, 16), "actress", 1000.20);
		human[2] = new Human("Gianna", "Mihcaels",new Date(1983, 06, 06), "actress", 1000.55);
			try {
				for (Human h : human)
				humanDAO.write(h);
				System.out.println("write - ok");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
