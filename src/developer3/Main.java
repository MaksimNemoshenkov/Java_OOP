package developer3;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Developer[] list = {
				new JuniorDeveloper("Mike", 500, 0),
				new JuniorDeveloper("Dima", 500, 1),
				new JuniorDeveloper("Vova", 500, 2),
				new SeniorDeveloper("Jack", 500, 5),
				new TeamLeadDeveloper("Robby", 500, 7)
				};
				
		JuniorDeveloper[] juniorDeveloper = new JuniorDeveloper[10];
		SeniorDeveloper[] seniorDeveloper = new SeniorDeveloper[10];
		TeamLeadDeveloper[] teamLeadDeveloper = new TeamLeadDeveloper[10];
		
		int junPosition =0;
		int seniorPosition = 0;
		int teamLeadPosition = 0;
		
		for (Developer d : list) {
			if (d instanceof JuniorDeveloper) {
				juniorDeveloper[junPosition] = (JuniorDeveloper) d;
				junPosition++;
			}
			if (d instanceof SeniorDeveloper) {
				seniorDeveloper[seniorPosition] = (SeniorDeveloper) d;
				seniorPosition++;
			}
			if (d instanceof TeamLeadDeveloper) {
				teamLeadDeveloper[teamLeadPosition] = (TeamLeadDeveloper) d;
				teamLeadPosition++;
			}
		}
		outDeveloper(juniorDeveloper, junPosition);
		outDeveloper(seniorDeveloper, seniorPosition);
		outDeveloper(teamLeadDeveloper, teamLeadPosition);

				}
				
	
	private static void outDeveloper (Developer[] list, int position) {
		StringBuilder sb;
		Developer d = null;
		for (int i = 0; i<position; i++) {
			d = list[i];
		sb = new StringBuilder()
		.append(d.getName())
		.append(": ")
		.append(d.getBasicSalary())
		.append(" -> ")
		.append(d.getSalary());
		System.out.println(sb.toString());
		}
	}
}
