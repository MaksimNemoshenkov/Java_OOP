package db;

import java.io.*;
import java.text.*;
import java.util.*;

import human.Human;

public class HumanDAO {

	private final int LENGHT_HUMAN = 217;
	private File file;

	public HumanDAO(File file) {
		this.file = file;
	}

	public List<Integer> betweenSalary(Double smoolSalary, Double bigSalary)
			throws FileNotFoundException, IOException, ParseException {
		List<Integer> list = new LinkedList<>();
		int seek = 208;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			/*
			 * if (smoolSalary == bigSalary) { for (int number = 0; seek < in.length();
			 * number++) { in.seek(seek); Double readSalary = in.readDouble(); if
			 * (smoolSalary == readSalary) list.add(number); seek += LENGHT_HUMAN; } return
			 * list; }
			 */

			for (int number = 0; seek < in.length(); number++) {
				in.seek(seek);
				Double readSalary = in.readDouble();
				if (smoolSalary < bigSalary) {
					if (smoolSalary < readSalary && readSalary < bigSalary)
						list.add(number);
				} else {
					if (smoolSalary > readSalary && readSalary > bigSalary)
						list.add(number);
				}
				seek += LENGHT_HUMAN;
			}
		}
		return list;
	}

	public List<Integer> lessSalary(Double salary) throws FileNotFoundException, IOException, ParseException {
		List<Integer> list = new LinkedList<>();
		int seek = 208;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			for (int number = 0; seek < in.length(); number++) {
				in.seek(seek);
				Double readSalary = in.readDouble();
				if (salary > readSalary)
					list.add(number);
				seek += LENGHT_HUMAN;
			}
		}
		return list;
	}

	public List<Integer> moreSalary(Double salary) throws FileNotFoundException, IOException, ParseException {
		List<Integer> list = new LinkedList<>();
		int seek = 208;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			for (int number = 0; seek < in.length(); number++) {
				in.seek(seek);
				Double readSalary = in.readDouble();
				if (salary < readSalary)
					list.add(number);
				seek += LENGHT_HUMAN;
			}
		}
		return list;
	}

	public List<Integer> searchByPosition(String name) throws FileNotFoundException, IOException {
		List<Integer> list = new LinkedList<>();
		int seek = 0;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			for (int number = 0; seek < in.length(); number++) {
				String s = readFixedString(100, in, 108 + seek);
				if (s.equalsIgnoreCase(name))
					list.add(number);
				seek += LENGHT_HUMAN;
			}
		}
		return list;
	}

	public List<Integer> between(Date dateStart, Date dateEnd)
			throws FileNotFoundException, IOException, ParseException {
		List<Integer> list = new LinkedList<>();
		int seek = 0;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {

			if (dateStart.equals(dateEnd)) {
				for (int number = 0; seek < in.length(); number++) {
					Date dateRead = readDate(in, 100 + seek);
					if (dateStart.equals(dateRead))
						list.add(number);
					seek += LENGHT_HUMAN;
				}
				return list;
			}

			for (int number = 0; seek < in.length(); number++) {
				Date dateRead = readDate(in, 100 + seek);
				if (dateStart.before(dateEnd)) {// если первая дата раньше второй
					if (dateStart.before(dateRead) && dateEnd.after(dateRead)) {
						list.add(number);
					}
				} else {
					if (dateStart.after(dateRead) && dateEnd.before(dateRead))
						list.add(number);
				}
				seek += LENGHT_HUMAN;
			}
		}
		return list;
	}

	public List<Integer> before(Date date) throws FileNotFoundException, IOException, ParseException {
		List<Integer> list = new LinkedList<>();
		int seek = 0;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			for (int number = 0; seek < in.length(); number++) {
				Date dateRead = readDate(in, 100 + seek);
				if (date.after(dateRead))
					list.add(number);
				seek += LENGHT_HUMAN;
			}
		}
		return list;
	}

	public List<Integer> after(Date date) throws FileNotFoundException, IOException, ParseException {
		List<Integer> list = new LinkedList<>();
		int seek = 0;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			for (int number = 0; seek < in.length(); number++) {
				Date dateRead = readDate(in, 100 + seek);
				if (date.before(dateRead))
					list.add(number);
				seek += LENGHT_HUMAN;
			}
		}
		return list;
	}

	public List<Integer> searchByNameSurename(String name, String surename) throws FileNotFoundException, IOException {
		List<Integer> list = new LinkedList<>();
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			for (Integer i : searchByName(name)) {
				String s = readFixedString(50, in, 50 + i * LENGHT_HUMAN);
				if (s.equalsIgnoreCase(surename))
					list.add(i);
			}
		}
		return list;
	}

	public List<Integer> searchByName(String name) throws FileNotFoundException, IOException {
		List<Integer> list = new LinkedList<>();
		int seek = 0;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			for (int number = 0; seek < in.length(); number++) {
				String s = readFixedString(50, in, seek);
				if (s.equalsIgnoreCase(name))
					list.add(number);
				seek += LENGHT_HUMAN;
			}
		}
		return list;
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
			writeFixedString(human.getName(), 50, out);
			writeFixedString(human.getSurName(), 50, out);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String date = formatter.format(human.getDate());
			out.write(date.getBytes());
			writeFixedString(human.getPosition(), 100, out);
			writer.writeDouble(human.getSalary());// записуємо Double
			writer.writeBoolean(false);
		}
	}

	// читаємо Humana із бази
	public Human read(int numberHuman) throws FileNotFoundException, IOException, ParseException {
		int seekPosition = numberHuman * LENGHT_HUMAN;
		try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
			String name = readFixedString(50, in, seekPosition);
			String sureName = readFixedString(50, in, (50 + seekPosition));
			String position = readFixedString(100, in, 108 + seekPosition);
			in.seek(208 + seekPosition);
			Double Salary = in.readDouble();
			return new Human(name, sureName, readDate(in, 100 + seekPosition), position, Salary);
		}
	}

	private Date readDate(RandomAccessFile in, int seek) throws ParseException, IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.parse(readFixedString(8, in, seek));
	}

	public void validateString(String str, int max, String name) throws IOException {
		byte[] bytes = str.getBytes();
		if (bytes.length > max) {
			throw new IOException(String.format(
					"Неправильная длина поля \"%s\": %d байт." + "Максимально допустимое значение: 50 байт.", name,
					bytes.length, max));
		}
	}

	// читання фіксованої довжини
	public static String readFixedString(int size, RandomAccessFile in, int seekPosition) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] b = new byte[1];
		in.seek(seekPosition);
		for (int i = 0; i < size; i++) {
			in.read(b);
			if ((int) b[0] == 0)
				break;
			result.write(b, 0, 1);
		}
		return result.toString();
	}

	// запис фіксованої довжини
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

	@Override
	public String toString() {
		return "AbsolutePath " + file.getAbsolutePath();
	}

}
