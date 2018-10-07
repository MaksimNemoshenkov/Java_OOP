package figure;

public class Triangle extends Figure{
	private int[] side= new int[3];
	
	Triangle(int[] side){
		this.side=side;

	}
	
	
	@Override
	public double getArea() {
		// рахуємо площу за формулою півпериметрів
		double halfPerimetr = (side[0]+side[1]+side[2])/2;
		double plaza = Math.sqrt(halfPerimetr*(halfPerimetr-side[0])*(halfPerimetr-side[1])*(halfPerimetr-side[2]));
		return plaza;
	}
}
