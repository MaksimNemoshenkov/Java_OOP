package car;

public class Car {

	private String name;
	private double fuelTank;
	private Engine engine;
	private Climate climate = new Climate();
	
	public Car(String name, double volume) {
		this.name = name;
		engine = new Engine(0.0, volume); 
	}
	public Car(String name, double mileage, double volume) {
		this.name = name;
		engine = new Engine(mileage, volume); 
	}
	public String getName() { 
		return name;
	}
	public double getMileage() {
		return engine.getMileage();
	}
	public void turnOn() {
		engine.turnOn();
		climate.turnOn();	
		climate.setTemperature(21);
	}
	public void turnOff() {
		climate.turnOff();
		engine.turnOff();
	}
	public void start (int speed, double hours) {
		if (engine.isStsrted()) {
			double distance = hours * speed;
				 double fuelBurn = distance / 20.0 * engine.getVolume();
				 if (fuelTank>fuelBurn) {
					 fuelTank-=fuelBurn;
			engine.addMileage(distance);
				 } else {
					 System.out.println(name +"fuel over");
				 }
		}
	}
	 public void filleBack(int fuel) {
		 if (fuel > 0)
			 fuelTank+=fuel;
	 }
	 public double getFuelTank() {
		 return fuelTank;
	 }
}



