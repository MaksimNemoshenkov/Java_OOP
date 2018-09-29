package saver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveGame {
	private String address = "/home/maks/SaveGame/";
	
	public SaveGame(){	
	}
	
	void PrintFileSave() {
		for (File f: new File(address).listFiles()) {
			System.out.println(f.getName());
		}
	}

	/*
	 * метод приймає на вхід строку, а повертає АрейЛіст
	 * читаємо із файлу за заданою адресою, та заданим кодуванням
	 * читаємо в циклі строки доки вони будуть 
	 * нормально виключення не зміг обробити тому поки так
	 * 
	 */
	ArrayList<String> loadStateGame(String SaveName) {
		ArrayList<String> list = new ArrayList<String>();
	try {
		Scanner in = new Scanner (Paths.get(address+SaveName+".txt"),"UTF-8"); 
		while (in.hasNext()) {
			list.add(in.next());
		}
		in.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	list.trimToSize();
	return list;
	}

	
	
	boolean userSaveGame(ArrayList<String> list, String SaveName) {
		try {
			PrintWriter out = new PrintWriter(address+SaveName+".txt", "UTF-8");
			for(String s : list)
			out.println(s);
			out.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return true;
	}

	String getAdres() {
		return address;
	}
}
