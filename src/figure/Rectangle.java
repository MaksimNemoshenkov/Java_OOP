package figure;

public class Rectangle extends Figure{


	private double height, width;
	
	public Rectangle(int height, int width) {
	this.height = height;
	this.width = width;
	}
	
	@Override
	public double getArea() {
		return height*width;
	}

	
}

