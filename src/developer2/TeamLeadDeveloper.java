package developer2;

public class TeamLeadDeveloper extends Developer {
	
	public TeamLeadDeveloper(String name, double basicSalary, int experience) {
		super(name, basicSalary, experience);
	}

	@Override
	public double getSalary() {
		return (basicSalary * 5) + (experience > 0 ? basicSalary * experience * 0.1 : 0);
	}
}