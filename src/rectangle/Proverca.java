package rectangle;

import java.util.Scanner;

public class Proverca {
	int ch = 0;
	Scanner in;
	
	public int getProverka() {
    	while (true) {
	    	in=new Scanner(System.in);
    	if(in.hasNextInt()) {
    	ch = in.nextInt();
    	if ( ch >0) {
        	break;
    	} else { 
    		System.out.println("Enter pozitive number");
    	}
    		} else {
    			System.out.println("Enter number:");
    		}
    	}
    	return ch;
	}
	
	public void closeScaner(){
		in.close();
	}
}