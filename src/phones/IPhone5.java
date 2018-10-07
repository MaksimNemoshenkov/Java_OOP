package phones;

public class IPhone5 extends IPhone {

	
	public IPhone5() {
		System.out.println("IPhone5 constructor");
		screenSize = 4;
		imei = "111111";
	}
	
	@Override
	public void sendSMS(String number, String message) {
		super.sendSMS(number, message);
		System.out.println("IPhone5 class is sending sms " + message + " to " + number);
	}
	
	public int getNumberCall() {
		return numberCall;
	}
	
	public int getNumberSMS() {
		return numberSMS;
	}
}