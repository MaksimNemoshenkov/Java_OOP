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

	public void write(Human human) throws IOException {
		validate(human);
		try (FileOutputStream out = new FileOutputStream(file, true);
				DataOutputStream writer = new DataOutputStream(out)) {
			writeFixedString(human.getName(),50,out);
			writeFixedString(human.getSurName(),50,out);
			String date =""+human.getDate();
			date = date.substring(0,4)+
					date.substring(5, 7)+
					date.substring(8);
			out.write(date.getBytes());
			writeFixedString(human.getPosition(),100,out);
			writer.writeDouble(human.getSalary());// записуємо Double 
			writer.writeBoolean(false);
		}
	}
	
	//неправильно працює, 
	public Human read(int numberHuman) throws FileNotFoundException, IOException {
		int seekPosition = numberHuman*217;
		try(RandomAccessFile in = new RandomAccessFile(file, "r")){
		String name = readFixedString(50, in,seekPosition);
		String sureName = readFixedString(50, in,(50+seekPosition));
		String date = readFixedString(8, in, 100+seekPosition);
		int Year = Integer.parseInt(date.substring(0, 4));
		int Mont = Integer.parseInt(date.substring(4,6));
		int Day = Integer.parseInt(date.substring(6));
		String position = readFixedString(100, in,108+seekPosition);
		in.seek(208+seekPosition);
		Double Salary = in.readDouble();
		return new Human(name,sureName,LocalDate.of(Year, Mont, Day), position,Salary);
		}
	}

	public void validateString(String str, int max, String name) throws IOException {
		byte[] bytes = str.getBytes();
		if (bytes.length > max) {
			throw new IOException(String.format(
					"Неправильная длина поля \"%s\": %d байт." + "Максимально допустимое значение: 50 байт.", name,
					bytes.length, max));
		}
	}
	
	//читання фіксованої довжини
	public static String readFixedString(int size, RandomAccessFile in, int seekPosition) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] b = new byte[1];
		in.seek(seekPosition);
		for(int i=0; i<size; i++) {
			in.read(b);
			if((int)b[0]==0)
				break;
			result.write(b, 0, 1);
		}
		return result.toString();
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
