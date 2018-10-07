package figure;

public class Circle extends Figure implements Area{
	private double area;
	private double radius;
	
	Circle (double radius){
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		setArea();
		return area;
	}

	@Override
	public void setArea() {
		area = radius*radius*Math.PI;
	}
}
