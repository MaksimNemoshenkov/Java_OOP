package fractal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
public class Main {

	public static void main(String[] args) {
		String sourceName = "C:\\Users\\Andrew\\temp\\1\\input.txt";
		File file = new File(sourceName);
		if(file.exists()) {
			String backupName = "C:\\Users\\Andrew\\temp\\1\\input.txt.tmp";
			boolean copied = false;
			try (OutputStream backup = new FileOutputStream(backupName)){
				Files.copy(file.toPath(), backup);
				copied = true;
			} catch (Exception e) {
				e.printStackTrace();
			} 
			if(copied)	{
				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try(
					InputStream backupInput = new FileInputStream(backupName);
					OutputStream destOut = new FileOutputStream(sourceName);
					){
				byte[] buffer = new byte[1024];
				int read = 0;
				do {
					read = backupInput.read(buffer, 0, 1024);
					destOut.write(buffer, 0, read);
				} while (read>0);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				new File(backupName).delete();
			}
			
		}
		
	}

}
