package phones;

public class SamsungS4 extends Phone{
	
	SamsungS4 (){
		screenSize = 5;
	}
	
	@Override
	public void call(String number) {
		System.out.println("SamsungS4 class is calling " + number);
	}

	@Override
	public void sendSMS(String number, String message) {
		System.out.println("SamsungS4 class is sending sms " + message + " to " + number + "Hello");
	}
	
	public void WiFi() {
		System.out.println("SamsungS4 class is connect to WiFi");
	}

}
