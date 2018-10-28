package test;


	
class Test {
	
	int[] i =new int [10000];
	@Override
	protected void finalize() throws Throwable {
		try {
			
			System.out.println("finalize");
		} finally {
			super.finalize();
		}
	}
}

public class Main {
	public static void main(String[] args) {
		System.out.println("start");
		
		int n = 10000;
		while (n-- > 0)
			new Test();
		
		
		System.out.println("end");
	}
	
}
