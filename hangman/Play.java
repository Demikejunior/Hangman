package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Play {

	public static String[] ord;

	public static void main(String[] args) {

		fill("hangman/words.txt"); // Fyller ord med orden från textfilen words.txt

		Random generator = new Random(); // Krävs för att man ska kunna ta ett slumpvalt ord från ord

		boolean cont = true;

		while (cont) { // Ser till att man kan fortsätta i fallet att man vill göra det
			HangGame hg = new HangGame(ord[generator.nextInt(ord.length)]); // Börjar spelet med ett slumpvalt ord från
																			// ord

			hg.println();
			hg.println("Vill du spela igen?" + "\n" + "y för ja, och n för nej");
			char c = hg.nextChar();
			if (c == 'n') { // Avslutar spelet om man skriver 'n'
				cont = false;
			}

			hg.close();
		}

	}

	/**
	 * Fyller ord med orden i filen f
	 * 
	 * @param f
	 */
	public static void fill(String f) {
		Scanner sc;
		try {
			sc = new Scanner(new File(f));
			int a = 0;

			a = countLines(f); // Kollar hur många rader som finns i filen f

			ord = new String[a]; // Initierar ord med längden a

			for (int i = 0; i < a; i++) {
				ord[i] = sc.nextLine(); // Fyller ord med alla ord i filen f
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}

	}

	/**
	 * Ger antal rader i filen filename
	 * 
	 * @param filename
	 * @return lines
	 */
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
