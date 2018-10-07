package figure;

public class Main {

	public static void main(String[] args) {
		Circle circle = new Circle(6);
		System.out.println("circle: " + circle.getArea());
		
		Rectangle rectangle = new Rectangle(5, 6);
		System.out.println("rectangle: " + rectangle.getArea());
		
		Triangle triangle = new Triangle(new int[] {3,4,5});
		System.out.println("triangle: " + triangle.getArea());
	}

}
