package phones;

public class SamsungS4 extends Phone{
	
	SamsungS4 (){
		screenSize = 5;
		hasWifi = true;
	}
	
	@Override
	public void call(String number) {
		System.out.println("SamsungS4 class is calling " + number);
		numberCall++;
	}

	@Override
	public void sendSMS(String number, String message) {
		System.out.println("SamsungS4 class is sending sms " + message + " to " + number + "Hello");
		numberSMS++;
	}
	
	@Override
	public boolean isHasWifi() {
		System.out.println("SamsungS4 class is connect to WiFi");
		return super.isHasWifi();
	}
	
	public int getNumberCall() {
		return numberCall;
	}
	
	public int getNumberSMS() {
		return numberSMS;
	}
}
