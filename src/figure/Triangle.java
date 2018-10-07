package figure;

public class Triangle extends Figure implements Area{
	private int[] side= new int[3];
	private double plaza;
	
	Triangle(int[] side){
		this.side=side;
	}
	
	@Override
	public double getArea() {
		setArea();
		return plaza;
		
	}
	@Override
	public void setArea() {
		// рахуємо площу за формулою півпериметрів
		double halfPerimetr = (side[0]+side[1]+side[2])/2;
		plaza = Math.sqrt(halfPerimetr*(halfPerimetr-side[0])*(halfPerimetr-side[1])*(halfPerimetr-side[2]));
		
	}
}
