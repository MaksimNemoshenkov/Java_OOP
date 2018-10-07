


public class Main {

	public static void main(String[] args) {
		
		String string  = "1234567890";
		int num = 0;
		try {
			 num = gerParseInt(string);
		} catch (IntegerException e) {
			e.printStackTrace();
		}
		System.out.println("Your number: " + num);
	}
	
	public static int gerParseInt(String str) throws IntegerException{
		char ch = ' ';
		int number = 0;
		for (int i=0; i<str.length(); i++) {
			ch = str.charAt(i);
			if (47>(int)ch&&(int)ch>58) 
				throw new IntegerException("Its not number");	
			number += (int)ch-48;
			if (i!=str.length()-1) 
				number *= 10;
		}	
		return number;
	}
}
