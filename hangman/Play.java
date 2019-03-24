package hangman;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Play {

	public static String[] ord;

	public static void main(String[] args) {

		try { // fyller ord[] med orden från words.txt
			Scanner sc = new Scanner(new File("hangman/words.txt"));
			int a = 0;

			try {
				a = countLinesNew("hangman/words.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}

			ord = new String[a];

			for (int i = 0; i < a; i++) {
				ord[i] = sc.nextLine();
			}

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		}

		Random generator = new Random();

		HangGame hg = new HangGame(ord[generator.nextInt(ord.length)]);

	}

	public static int countLinesNew(String filename) throws IOException {

		// Kopierat från stack overflow för att ha ett vettigt sätt att se antal rader i
		// words.txt

		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];

			int readChars = is.read(c);
			if (readChars == -1) {
				// bail out if nothing to read
				return 0;
			}

			// make it easy for the optimizer to tune this loop
			int count = 0;
			while (readChars == 1024) {
				for (int i = 0; i < 1024;) {
					if (c[i++] == '\n') {
						++count;
					}
				}
				readChars = is.read(c);
			}

			// count remaining characters
			while (readChars != -1) {

				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
				readChars = is.read(c);
			}

			return count == 0 ? 1 : count;
		} finally {
			is.close();
		}
	}

}
