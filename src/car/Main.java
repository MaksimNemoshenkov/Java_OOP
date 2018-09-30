package car;


public class Main {

	public static void main(String[] args) {
		Engine engine = new Engine(1.2);
		Car smartCar = new Car(engine, 50);
		smartCar.calculationOfFuel(80);
		System.out.println("Balance Fuel "+smartCar.getFuelTank());
		smartCar.filleBack(5);
		System.out.println("Balance Fuel "+smartCar.getFuelTank());
	}
}
