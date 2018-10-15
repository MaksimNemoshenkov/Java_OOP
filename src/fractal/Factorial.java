package fractal;

import java.math.BigInteger;

public class Factorial implements Runnable{

	BigInteger num;
	Result result;
	BigInteger end;

	public Factorial(BigInteger num, BigInteger end, Result result) {
		super();
		this.num = num;
		this.result = result;
		this.end = end;
	}

	public void run() {
		BigInteger factorial = fact(num, end);
		result.setValue(factorial);
	}

	private BigInteger fact(BigInteger start, BigInteger end) {
		if (start.equals(end)) {
			return end;
		}else {
			return start.multiply(fact(start.subtract(BigInteger.ONE), end));
		}
	}
}