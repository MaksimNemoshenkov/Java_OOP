package car;

public class Car {

	private int fuelTank;
	Engine engine;
	
	
	public Car(Engine engine,int fuelTank) {
		this.engine = engine;
		this.fuelTank = fuelTank;
	}
	
	 public void filleBack(int fuel) {
		 if (fuel > 0)
			 fuelTank+=fuel;
	 }
	 
	 
	 public int getFuelTank() {
		 return fuelTank;
	 }
	
	 public void calculationOfFuel(int mileage) {
		 if(mileage>0) {
			 
			 if(engine.getVolume()<=1.6) {
				 int fuelBurn = mileage / 20;
				 if (fuelTank>fuelBurn)
					 fuelTank-=fuelBurn;
			 } else 
			 if (engine.getVolume()>1.6) {
				 int fuelBurn = mileage / 10;
				 if (fuelTank>fuelBurn)
					 fuelTank-=fuelBurn;
			 }
			 
		 } else return;
		 
	 }
	 
	 
}



