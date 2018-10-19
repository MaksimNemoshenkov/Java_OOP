package fractal;

import java.math.BigInteger;
import java.util.ArrayList;

public class Run {
	private static ArrayList<Thread> listThread = new ArrayList<>();
	private static ArrayList<Result> listResult = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		BigInteger finalResult = BigInteger.ONE;
		
		int factorial = 7;
		int nThread = 6;
		int factorialThread = factorial / nThread;
		int start = 0, end = 0;
		
		

		for (int runThread = 1; runThread <= nThread; runThread++) {
			if(runThread == nThread) {
				end = start;
				start = factorial;
				runThread(BigInteger.valueOf(start), BigInteger.valueOf(end));
			} else {
			start = factorialThread * runThread;
			end = start - factorialThread + 1;
			runThread(BigInteger.valueOf(start), BigInteger.valueOf(end));
			}
	//		System.out.println("start: " + start + " end: " + end);
		}

		for (Thread thread : listThread)
			thread.join();
		for (Result result : listResult) {
			finalResult = finalResult.multiply(result.getValue());
		}
		System.out.println(finalResult);
	}

	/*
	 * static BigInteger metod (BigInteger start, BigInteger end) throws
	 * InterruptedException { Result result = new Result(); Factorial factorial1 =
	 * new Factorial(start, end, result); Thread thread = new Thread(factorial1);
	 * thread.start(); thread.join(); return result.getValue(); }
	 */

	static void runThread(BigInteger start, BigInteger end) throws InterruptedException {
		Result result = new Result();
		listResult.add(result);
		Factorial factorial1 = new Factorial(start, end, result);
		Thread thread = new Thread(factorial1);
		thread.start();
		listThread.add(thread);
	}

}