package db;

import java.io.*;
import java.time.LocalDate;

import human.Human;

public class HumanDAO {

	private File file;

	public HumanDAO(File file) {
		this.file = file;
	}

	public void validate(Human human) throws IOException {
			validateString(human.getName(), 50, "Имя");
			validateString(human.getSurName(), 50, "Фамилия");
			validateString(human.getPosition(), 100, "Должность");
	}

	//записує поверх файлу замість того, щоб записувати в кінець..
	public void write(Human human) throws IOException {
		validate(human);
		try (FileOutputStream out = new FileOutputStream(file)) {
			writeFixedString(human.getName(),25,out);
			writeFixedString(human.getSurName(),25,out);
			out.write((int)human.getDate().getYear());
			out.write((int)human.getDate().getMonthValue());
			out.write((int)human.getDate().getDayOfMonth());
			writeFixedString(human.getPosition(),50,out);
			out.write((byte)human.getSalary()); // записуємо Double 
			out.write((byte)1);//записуємо Boolean 
		}
	}
	
	//неправильно працює, 
	public Human read() throws FileNotFoundException, IOException {
		Human human;
		try(RandomAccessFile in = new RandomAccessFile(file, "r")){
		String name = readFixedString(25, in);
		String sureName = readFixedString(25, in);
		int Year = in.readInt();
		int Mont = in.readInt();
		int Day = in.readInt();
		String position = readFixedString(50, in);
		Double Salary = in.readDouble();
		human = new Human(name,sureName,LocalDate.of(Year, Mont, Day), position,Salary);
		}
		return human;
	}

	public void validateString(String str, int max, String name) throws IOException {
		byte[] bytes = str.getBytes();
		if (bytes.length > max) {
			throw new IOException(String.format(
					"Неправильная длина поля \"%s\": %d байт." + "Максимально допустимое значение: 50 байт.", name,
					bytes.length, max));
		}
	}
	//чомусь повертає китайські букви
	//читання фіксованої довжини
	public static String readFixedString(int size, DataInput in) throws IOException {
		StringBuilder b = new StringBuilder(size);
		int i = 0;
		boolean more = true;
		while (more && i < size) {
			char ch = in.readChar();
			i++;
			if (ch == 0)
				more = false;
			else
				b.append(ch);
		}
		in.skipBytes(2 * (size - i));
		System.out.println(b.toString());
		return b.toString();
	}

	//запис фіксованої довжини
	public static void writeFixedString(String s, int size, FileOutputStream out) throws IOException {
		StringBuilder b = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			char ch = 0;
			if (i < s.length())
				ch = s.charAt(i);
			b.append(ch);
		}
		out.write(b.toString().getBytes());
	}
}
