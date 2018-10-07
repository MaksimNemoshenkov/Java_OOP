package rectangle;


public class Main {

	public static void main(String[] args) {
		Proverca proverca = new Proverca();
		int height;
		int width;
		System.out.println("Enter height");
		height = proverca.getProverka();
		System.out.println("Enter width");
		width = proverca.getProverka();
		
		
		for(int h = 0; h<=height; h++) {
			if(h==0) {
				System.out.print("╔");
			} else if(h>0 && h<height) {
			System.out.print("║");
			} else if(h==height)
			System.out.print("╚");
			
			for (int w = 0; w < width; w++) {
				if(h==0 || h==height) {
				System.out.print("═");
				} else {
					System.out.print(" ");
				}
			}
			
			
			if(h==height) {
				System.out.println("╝");	
			}else if(h==0) {
				System.out.print("╗");
			}else 
			System.out.print("║");
			System.out.println();
		}
		
		proverca.closeScaner();
	}
}
