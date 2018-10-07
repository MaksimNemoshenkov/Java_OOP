package phones;

public class IPhone extends Phone {
	protected String imei;

	public IPhone() {
		System.out.println("IPhone constructor");
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}

	@Override
	final public void call(String number) {
		System.out.println("IPhone class is calling " + number);
		numberCall++;
	}
	
	@Override
	public void sendSMS(String number, String message) {
		System.out.println("IPhone class is sending sms " + message + " to " + number);
		numberSMS++;
	}
	
	public int getNumberCall() {
		return numberCall;
	}
	
	public int getNumberSMS() {
		return numberSMS;
	}
}
