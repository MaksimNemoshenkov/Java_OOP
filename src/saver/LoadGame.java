package saver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadGame {

	private String name;
	private String address;
	
	public LoadGame(String name, String address){
		this.name = name;
		this.address=address;
		PrintFileSave();
	}

	void PrintFileSave() {
		for (File f: new File(address).listFiles()) {
			System.out.println(f.getName());
		}
	}
	
	ArrayList<String> LoadStateGame() {
		ArrayList<String> list = new ArrayList<String>();
	try {
		Scanner in = new Scanner (Paths.get(address+name+".txt"),"UTF-8"); 
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
}
