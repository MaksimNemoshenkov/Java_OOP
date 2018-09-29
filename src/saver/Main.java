package saver;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		SaveGame sg = new SaveGame();
		//Створюємо екземпляр класу SaveGame();
		
		System.out.println("l = load, s = Save, e = exit");
		
		 //hh
		do{ 
		switch(in.nextLine()) {
		
		case "s":
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hallo!");
		list.add("Say hallo!"); // для прикладу додаємо просто текст
		System.out.println("enter file name for save:");
		if(sg.userSaveGame(list, in.nextLine())) 
			//метод повертає boolean та чекає на вхід ArrayList та String
			System.out.println("GameSave");
		break;
		
		case "l":
			for (File file: new File(sg.getAdres()).listFiles()) 
				System.out.println(file.getName());
			/*
			 * виводимо на екран вміст папки де ми здійснюємо збереження
			 */
			System.out.println("enter file name for load:");
		for (String s : sg.loadStateGame(in.nextLine())) 
		    System.out.println(s);
		break;
		
		case"e":
		flag=!flag; //для виходу із програми використовуємо флаг
		System.out.println("Exit");
		
		default:
		}
	} while(flag);		
		in.close();
	}
}
		/*
		 //сотворення файлу
		try {
			PrintWriter out = new PrintWriter("/home/maks/SaveGame/Name.txt", "UTF-8"); //сотворення файлу
			out.print("hallo!"); //запис тексту в файл
			out.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/


		/*
		try (Scanner in = new Scanner(new BufferedReader(new FileReader("/home/maks/SaveGame/Name.txt")))) {
		
			in.useDelimiter("");
			while (in.hasNext()) {
				System.out.println(in.findInLine(in.next()));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try {
			Scanner in = new Scanner (Paths.get("/home/maks/SaveGame/Name.txt"),"UTF-8"); 
			while (in.hasNext()) {
				System.out.println(in.next());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		

		
		
		

