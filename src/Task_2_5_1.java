

import java.io.*;
import java.nio.file.Files;

public class Task_2_5_1 {
	public static void main(String[] args) {
		String sourceName = "/home/maks/SaveGame/input.txt";
		File file = new File(sourceName);
		if (file.exists()) {
			String backupName = "/home/maks/SaveGame/input1.txt";
			boolean copied = false;
			try (OutputStream backup = new FileOutputStream(backupName)) {
				Files.copy(file.toPath(), backup);
				copied = true;
				System.out.println("backup - ok");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (copied) {
				file.delete();
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// створили копію і видалили оригінал

			// читаємо копію, робимо заміну, записуємо
			try (InputStream backupInput = new FileInputStream(backupName);
					OutputStream destOut = new FileOutputStream(sourceName);) {
				byte[] buffer = new byte[1024];
				int read = 0;
				do {
					read = backupInput.read(buffer, 0, 1024);
					if (read > 0) {
						destOut.write(
								new String(buffer, "UTF-8").
								replaceAll("Hello", "1234").
							//	replaceAll("1234","Hello").
								toString().
								getBytes());
					}
				} while (read > 0);
				System.out.println("write - ok");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				new File(backupName).delete();
			}
		}
	}
}
