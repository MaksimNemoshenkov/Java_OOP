package test;

import java.io.*;


import db.HumanDAO;
import human.Human;

public class TestRead {

	public static void main(String[] args) throws IOException {
		HumanDAO humanDAO = new HumanDAO(new File("/home/maks/SaveGame/test.txt"));
		
		try {
			for(int number=0; number<3;number++) {
			Human human = humanDAO.read(number);
			System.out.print("name: "+human.getName()
			+ "\nSure name: " + human.getSurName()
			+ "\nData: "+ human.getDate()
			+ "\nSalary: " + human.getSalary()
			+ "\nPosition: " + human.getPosition());
			System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		RandomAccessFile in = new RandomAccessFile("/home/maks/SaveGame/test.txt", "r");
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		in.seek(217);
		byte[] b = new byte[1];
		for(int i=0; i<50; i++) {
			in.read(b);
			if((int)b[0]==0)
				break;
			result.write(b, 0, 1);
		}
	System.out.println(result.toString());
		in.close();
		*/
	}
}
