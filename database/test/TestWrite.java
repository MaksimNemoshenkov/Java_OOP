package test;

import java.io.*;
import java.time.LocalDate;

import db.HumanDAO;
import human.Human;

public class TestWrite {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		HumanDAO humanDAO = new HumanDAO(new File("/home/maks/SaveGame/test.txt"));
		Human human[] = new Human[3];
		human[0] = new Human("Sasha", "Grey",LocalDate.of(1988, 03, 14), "actress", 1000.10);
		human[1] = new Human("Jesse", "Jane", LocalDate.of(1980, 07, 16), "actress", 1000.20);
		human[2] = new Human("Gianna", "Mihcaels", LocalDate.of(1983, 06, 06), "actress", 1000.55);
			try {
				for (Human h : human)
				humanDAO.write(h);
				System.out.println("write - ok");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
