package rectangle;


public class Main {

	public static void main(String[] args) {
		
		int height;
		int width;
		Proverca proverca = new Proverca();
		System.out.println("Enter height");
		height = proverca.getProverka();
		System.out.println("Enter width");
		width = proverca.getProverka();
		Rectangle rectangle = new Rectangle(width, height);
		rectangle.draw();
		proverca.closeScaner();
	}
}
