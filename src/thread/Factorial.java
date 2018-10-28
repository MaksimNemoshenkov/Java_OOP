package thread;

import java.math.BigInteger;

public class Factorial implements Runnable{
	
	BigInteger num;
	BigInteger end;
	Result result = new Result();
	
	public Factorial(BigInteger num,BigInteger end, Result result) {
		super();
		this.end = end;
		this.num = num;
		this.result = result;
	}

	@Override
	public void run() {
		BigInteger factorial = fact(num, end);
		result.setValue(factorial);
	}
	
	
	private BigInteger fact(BigInteger start, BigInteger end) {
/*		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}*/
			if (start.equals (end))
			return BigInteger.ONE;
			else
			return start.multiply(fact(start.subtract(BigInteger.ONE),end));
	}
}
