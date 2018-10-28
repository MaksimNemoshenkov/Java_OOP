package translate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Translate {

	static final String INPUT_STRING = "1";
	static final String EXIT = "0";
	static Map<String, String> slovar = createDictionary();
	static Scanner scanner = new Scanner(System.in);

	static String getInputString () {
		System.out.print("Enter string, please");
		String choice = scanner.nextLine();
        return choice;
	}
	
	public static void main(String[] args) {
		String choice = showMainMenu();
		String str = new String("Hello, world!");
		switch (choice) {
		case EXIT:
			return;
		case INPUT_STRING:
			str = getInputString();
	        String translated = translateStr(str);
	        System.out.println(translated);
		}
		
		String hW = "Hello, World!";
		String translated = translateStr(hW);
		System.out.println(translated);
	}

	static String showMainMenu() {
		System.out.println("Hello!");
		System.out.println("1. InputString to translate");
		System.out.println("0. Exit");
		while (true) {
			String choice = scanner.nextLine();
			switch (choice) {
			case INPUT_STRING:
			case EXIT:
				return choice;
			default:
				System.out.println("Wrong input. Try again!");
				break;
			}
		}
	}

	static String translateStr(String src) {
		String[] words = src.split(" ");
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			if (!word.isEmpty()) {
				char symbol = word.charAt(word.length() - 1);
				if (!Character.isAlphabetic(symbol)) {
					result.append(slovar.get(word.substring(0, word.length() - 1).toUpperCase())).append(symbol)
							.append(" ");
				} else {
					result.append(slovar.get(word.toUpperCase())).append(" ");
				}
			}
		}
		return result.toString();
	}

	static Map<String, String> createDictionary() {
		Map<String, String> slovar = new HashMap<>();
		slovar.put("Hello".toUpperCase(), "Привіт");
		slovar.put("World".toUpperCase(), "Світ");
		return slovar;
	}
}
