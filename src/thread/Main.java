package thread;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {

		try {
			Result result1 = new Result();
			Result result2= new Result();

			Factorial factorial1 = new Factorial(BigInteger.valueOf(100), BigInteger.valueOf(50), result1);
			Thread thread = new Thread(factorial1);

			Factorial factorial2 = new Factorial(BigInteger.valueOf(49), BigInteger.valueOf(1), result2);
			Thread thread2 = new Thread(factorial2);
			
			thread2.start();
			thread.start();

			thread.join();
			thread2.join();
			
			BigInteger calculation1 = result1.getValue();
			BigInteger calculation2 = result2.getValue();
			System.out.println(calculation1.multiply(calculation2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/*	static runThread (BigInteger start, BigInteger end, Result result){
		
	}*/
	
	
}
