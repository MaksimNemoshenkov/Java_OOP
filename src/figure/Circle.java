package figure;

public class Circle extends Figure{

	private double radius;
	Circle (double radius){
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return radius*radius*Math.PI;
	}
}
