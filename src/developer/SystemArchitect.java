package developer;

public class SystemArchitect extends Developer{

	public SystemArchitect(String name, double basicSalary, int experience) {
		super(name, basicSalary, experience);

	}
	
	@Override
	public double getSalary() {
		return (basicSalary*10)+ (experience > 0 ? basicSalary * experience * 0.1 : 0);
	}

}
