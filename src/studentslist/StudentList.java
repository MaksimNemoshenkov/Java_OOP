package studentslist;

import java.util.Arrays;
import java.util.Date;

public class StudentList {
	private Student[] list = new Student[100];
	private int p = 0;

	public void add(Student s) {
		if (p == list.length - 1) 
			list = Arrays.copyOf(list, list.length + 100);
			list[p++] = s;
	}

	public Student get(int n) {
		return list[n];
	}

	public int[] find(String name) {
		int[] position = new int[p];
		int masivPosition = -1;

		for (int i = 0; i < p; i++)
			if (list[i].getName().equalsIgnoreCase(name))
				position[++masivPosition] = i;
		if (masivPosition >= 0)
			return Arrays.copyOf(position, ++masivPosition);
		return null;
	}

	public int[] findSurname(String surename) {
		int[] position = new int[p];
		int masivPosition = -1;
		for (int i = 0; i < p; i++)
			if (list[i].getSurname().equalsIgnoreCase(surename))
				position[++masivPosition] = i;
		if (masivPosition >= 0)
			return Arrays.copyOf(position, ++masivPosition);
		return null;
	}

	public int[] findDateBirth(Date birth) {
		int[] position = new int[p];
		int masivPosition = -1;
		for (int i = 0; i < p; i++)
			if (list[i].getBirth().equals(birth))
				position[++masivPosition] = i;
		if (masivPosition >= 0)
			return Arrays.copyOf(position, ++masivPosition);
		return null;
	}

}