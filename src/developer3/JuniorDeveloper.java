package developer3;

public class JuniorDeveloper extends Developer {
	
	public JuniorDeveloper(String name, double basicSalary, int experience) {
		super(name, basicSalary, experience);
// в Developer нет к-ра без параметров
	}

	@Override
	public double getSalary() {
		return basicSalary + (experience > 0 ? basicSalary * experience * 0.1 : 0);
	}
}
