package test;

import java.io.File;
import java.util.Date;

import db.HumanDAO;
import human.Human;

public class TestFind {

	public static void main(String[] args) throws Exception {
		HumanDAO humanDAO = new HumanDAO(new File("/home/maks/SaveGame/test.txt"));
		
		System.out.println("Searh by name: ");
		try {
			for (Integer l : humanDAO.searchByName("Sasha")) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Searh by name and surename: ");
		try {
			for (Integer l : humanDAO.searchByNameSurename("Jesse", "Jane")) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Searh by date after: ");
		try {
			for (Integer l : humanDAO.after(new Date(1985,01,01))) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Searh by date before: ");
		try {
			for (Integer l : humanDAO.before(new Date(1985,01,01))) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Searh by date between: ");
		try {
			for (Integer l : humanDAO.between(new Date(1982,01,01), new Date(1984,01,01))) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Searh by position: ");
		try {
			for (Integer l : humanDAO.searchByPosition("actress")) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Searh by less Salary: ");
		try {
			for (Integer l : humanDAO.lessSalary(1000.2)) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Searh by more Salary: ");
		try {
			for (Integer l : humanDAO.moreSalary(1000.2)) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Searh by between Salary: ");
		try {
			for (Integer l : humanDAO.betweenSalary(1000.25, 1000.15)) {
				Human human = humanDAO.read(l);
				System.out.print(human);
				System.err.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
