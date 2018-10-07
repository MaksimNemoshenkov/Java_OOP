package figure;

public class Rectangle extends Figure implements Area{

	private double height, width, area;
	
	public Rectangle(int height, int width) {
	this.height = height;
	this.width = width;
	}
	
	@Override
	public double getArea() {
		setArea();
		return area;
	}

	@Override
	public void setArea() {
		area = height*width;
	}
	
	

	
}

