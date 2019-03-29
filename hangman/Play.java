package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Play {

	public static String[] ord;

	public static void main(String[] args) {

		fill("hangman/words.txt");

		Random generator = new Random();

		HangGame hg = new HangGame(ord[generator.nextInt(ord.length)]);

		hg.close();
	}

	public static void fill(String f) {
		Scanner sc;
		try {
			sc = new Scanner(new File(f));
			int a = 0;

			a = countLines(f);

			ord = new String[a];

			for (int i = 0; i < a; i++) {
				ord[i] = sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}

	}

	public static int countLines(String filename) {
		int l = 0;
		try {
			Scanner file_reader = new Scanner(new File(filename));
			while (file_reader.hasNextLine()) {
				file_reader.nextLine();
				l++;
			}
			file_reader.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		}
		return l;
	}

}
