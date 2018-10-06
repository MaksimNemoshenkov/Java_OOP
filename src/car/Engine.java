package car;

public class Engine {
	private double volume;
	private boolean started;
	private double mileage;
	

	public Engine (double mileage,double volume) { 
		this.volume = volume;
		this.mileage = mileage;
	}
	
	public double getMileage () {
		return mileage;
	}
	
	public void addMileage(double mileage) {
		if(started) { 
		this.mileage += mileage;	
		}
	}
	public boolean isStsrted() {
		return started;
	}
	public void turnOn() {
		started = true;
	}
	public void turnOff() {
		started = false;
	}
	public double getVolume() {
		return volume;
	}

}
