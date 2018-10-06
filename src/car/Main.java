package car;


public class Main {

	public static void main(String[] args) {
		Car bmw  = new Car("BMW", 1.6);
		Car ferrari = new Car ("Ferrari", 20000, 2.2);
		
		bmw.filleBack(20);
		ferrari.filleBack(50);
		
		bmw.turnOn(); //заправка 
		ferrari.turnOn();
		
		final int[] speeds = new int[] {20, 60, 120};
		
		for (int s: speeds)
			bmw.start(s, 0.5);
		
		for (int s: speeds)
			ferrari.start(s, 1);
		
		
		System.out.println(bmw.getName()+ ": " +bmw.getMileage() + ": " + bmw.getFuelTank());
		System.out.println(ferrari.getName()+ ": "+ferrari.getMileage()+ ": " + ferrari.getFuelTank());
		
	}
}
