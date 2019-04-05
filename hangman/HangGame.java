package hangman;

public class HangGame {

	public static String word;
	public static String reverseWord;
	public static int lives;
	public static HangmanConsoleWindow hcw;
	public static String guessed;

	public HangGame(String initWord) {

		hcw = new HangmanConsoleWindow();
		lives = 11;
		word = initWord.toLowerCase();
		reverseWord = reverse(initWord);
		guessed = "";
		hcw.println("Välkommen till hänga gubben! \r\n" + "Du har " + lives + " liv" + "\n"
				+ "Klicka på en knapp för att gå vidare");
		hcw.nextChar();
		paint();

	}

	/**
	 * Skriver ut antal kvarvarande liv
	 * 
	 * @return
	 */
	public int lives() {
		return lives;
	}

	/**
	 * Sänker antal kvarvarande liv med 1.
	 */
	private static void loseLife() {
		lives--;
	}

	/**
	 * Skriver ut tP i konsolen, med nästa utskrift på samma rad.
	 * 
	 * @param tP
	 */
	public void print(String tP) {
		hcw.print(tP);
	}

	/**
	 * Skriver ut tP i konsolen, med nästa utskrift på nästa rad.
	 * 
	 * @param tP
	 */
	public void println(String tP) {
		hcw.println(tP);
	}

	/**
	 * Skriver ut en tom rad i konsolen.
	 */
	public void println() {
		hcw.println();
	}

	private static String reverse(String toReverse) {

		String reversed = "";

		for (int i = 0; i < toReverse.length(); i++) {
			if (toReverse.charAt(i) != ' ' && toReverse.charAt(i) != ',') {
				reversed += '-';
			} else if (toReverse.charAt(i) != ',') {
				reversed += ' ';
			} else {
				reversed += ',';
			}
		}

		return reversed;

	}

	/**
	 * Fixar allt angående gissningar.
	 */
	public static void guess() {

		// Din gissning
		String G = hcw.nextString().toLowerCase();

		// Kollar om gissningen är en bokstav eller inte
		if (G.length() == 1) {

			char g = G.charAt(0); // Skapar en char ifrån gissningen
			boolean exist = false;
			guessed += g + " "; // Lägger till gissningen i listan av dina gissningar
			for (int i = 0; i < word.length(); i++) { // Går igenom ordet som ska gissas och kollar om någon / något av
														// bokstäverna är det som gissades
				if (g == word.charAt(i)) {
					exist = true; // Gör att du inte förlorar ett liv, eftersom att bokstaven du gissade fanns

					// Följande gör om reverseWord till att ha med gissnigen

					String s = "";

					if (i > 0) { // Om g ligger efter första karaktären lägg till alla delar innan g till s
						s += reverseWord.substring(0, i);
					}

					s += g; // lägg till g till s

					if (i <= word.length() - 1) { // Om g ligger före sista karaktären lägg till alla delar efter g till
													// s
						s += reverseWord.substring(i + 1);
					}

					reverseWord = s;
				}

			}
			if (exist) {
				paint("Du gissade rätt!");
			} else {
				loseLife();
				paint("Du gissade fel!");
			}
		} else { // Om gissningen var mer än en bokstav
			if (G.equals(word)) { // Kollar om det som gissades är samma som ordet som ska gissas
				win();
			} else {
				hcw.println("Gissa bokstäver istället");
				guess();
			}
		}

	}

	/**
	 * Sätter liv till antalet som visat att man vunnit, <br>
	 * sedan utför paint()
	 */
	private static void win() {
		lives = 100;
		paint();
	}

	/**
	 * Kollar skillnaden mellan ordet man ska gissa, <br>
	 * och de delar man har gissat. <br>
	 * <br>
	 * Om man har gissat allt vinner man, om inte skrivs de delar man har gissat ut.
	 */
	public static void show() {
		if (!reverseWord.equals(word)) {
			hcw.println(reverseWord);
		} else {
			win();
		}
	}

	/**
	 * Skriver ut spelarens situation, <br>
	 * vad den har gissat på, <br>
	 * vilka delar av ordet den har gissat rätt, <br>
	 * samt en maning och ett tillfälle att gissa
	 */
	public static void paint() {
		paint("");
	}

	/**
	 * Skriver ut spelarens situation, <br>
	 * vad den har gissat på, <br>
	 * vilka delar av ordet den har gissat rätt, <br>
	 * ett meddelande som skickas med, <br>
	 * samt en maning och ett tillfälle att gissa
	 * 
	 * @param message
	 */
	public static void paint(String message) {
		hcw.clear();

		String obj = "";

		switch (lives) {
		case 100:
			obj += "(Yay!) ___      \n";
			obj += "    \\ /^ ^\\   \n";
			obj += "      \\_U_/    \n";
			obj += "     \\  |  /   \n";
			obj += "      \\_|_/    \n";
			obj += "        |       \n";
			obj += "       / \\     \n";
			obj += "      /   \\    \n";
			obj += "     /     \\   \n";
			obj += "   ___________  \n";
			obj += " CONGRATULATIONS\n";
			obj += "     YOU WON      ";
			obj += "\n";
			obj += " Ordet var: " + word;
			break;
		case 0:
			obj += "    ______         \n";
			obj += "   |/     |        \n";
			obj += "   |      |        \n";
			obj += "   |      |        \n";
			obj += "   |      |        \n";
			obj += "  /|\\___  X  __   \n";
			obj += " |      |/|\\|  |  \n";
			obj += " |       / \\   |  \n";
			obj += " |   DU  DOG   |   \n";
			obj += "\n";
			obj += " Ordet var: " + word;
			break;
		case 1:
			obj += "    ______         \n";
			obj += "   |/     |        \n";
			obj += "   |      O        \n";
			obj += "   |     /|\\      \n";
			obj += "   |     /_\\      \n";
			obj += "  /|\\___|___|__   \n";
			obj += " |             |   \n";
			obj += " |             |   \n";
			obj += " |             |   \n";
			break;
		case 2:
			obj += "    ______         \n";
			obj += "   |/              \n";
			obj += "   |      O        \n";
			obj += "   |     /|\\      \n";
			obj += "   |     /_\\      \n";
			obj += "  /|\\___|___|__   \n";
			obj += " |      |___|  |   \n";
			obj += " |      |___|  |   \n";
			obj += " |      |___|  |   \n";
			break;
		case 3:
			obj += "    ______         \n";
			obj += "   |/              \n";
			obj += "   |               \n";
			obj += "   |      O        \n";
			obj += "   |     /|\\      \n";
			obj += "  /|\\___|/_\\|__  \n";
			obj += " |      |___|  |   \n";
			obj += " |      |___|  |   \n";
			obj += " |      |___|  |   \n";
			break;
		case 4:
			obj += "    ______             \n";
			obj += "   |/                  \n";
			obj += "   |                   \n";
			obj += "   |                   \n";
			obj += "   |      O            \n";
			obj += "  /|\\___|/|\\|__      \n";
			obj += " |      |/_\\|  |      \n";
			obj += " |      |___|  |       \n";
			obj += " |      |___|  |       \n";
			break;
		case 5:
			obj += "    ______              \n";
			obj += "   |/                   \n";
			obj += "   |                    \n";
			obj += "   |                    \n";
			obj += "   |     ___            \n";
			obj += "  /|\\___| O |__        \n";
			obj += " |      |/|\\|  |       \n";
			obj += " |      |/_\\|  |       \n";
			obj += " |      |___|  |        \n";
			break;
		case 6:
			obj += "    ______             \n";
			obj += "   |/                  \n";
			obj += "   |                   \n";
			obj += "   |                   \n";
			obj += "   |     ___           \n";
			obj += "  /|\\___|___|__       \n";
			obj += " |      | O |  |       \n";
			obj += " |      |/|\\|  |      \n";
			obj += " |      |/_\\|  |      \n";
			break;
		case 7:
			obj += "    ______             \n";
			obj += "   |/                  \n";
			obj += "   |                   \n";
			obj += "   |                   \n";
			obj += "   |     ___           \n";
			obj += "  /|\\___|___|__       \n";
			obj += " |      |___|  |  O    \n";
			obj += " |      |___|  | /|\\  \n";
			obj += " |      |___|  | / \\  \n";
			break;
		case 8:
			obj += "    ______         \n";
			obj += "   |/              \n";
			obj += "   |               \n";
			obj += "   |               \n";
			obj += "   |     ___       \n";
			obj += "  /|\\___|___|__   \n";
			obj += " |      |___|  |   \n";
			obj += " |      |___|  |   \n";
			obj += " |      |___|  |   \n";
			break;
		case 9:
			obj += "    ______         \n";
			obj += "   |/              \n";
			obj += "   |               \n";
			obj += "   |               \n";
			obj += "   |     ___       \n";
			obj += "  /|\\___|___|__   \n";
			obj += " |             |   \n";
			obj += " |             |   \n";
			obj += " |             |   \n";
			break;
		case 10:
			obj += "                   \n";
			obj += "                   \n";
			obj += "                   \n";
			obj += "                   \n";
			obj += "         ___       \n";
			obj += "  ______|___|__    \n";
			obj += " |             |   \n";
			obj += " |             |   \n";
			obj += " |             |   \n";
			break;
		case 11:
			obj += "\n";
			obj += "\n";
			obj += "\n";
			obj += "\n";
			obj += "\n";
			obj += "\n";
			obj += "\n";
			obj += "\n";
			obj += "\n";
			break;

		default:
			break;
		}

		hcw.println(obj); // Skriver ut visuella delen
		hcw.println(message); // Skriver ut meddelandet som skickas med
		
		if (lives > 0 && lives < 15) { // Om man inte har vunnit eller förlorat
			show(); // Visar bokstäverna du har gissat rätt i de platser som de ska ligga

			if (guessed.length() > 0) { // Om det har gissats någon bokstav skrivs de bokstäver ut
				hcw.println("Du har gissat på " + guessed);
			} else { // Om det inte har gissats på några bokstäver manas användaren att göra det
				hcw.println("Gissa på en bokstav");
			}
			if (lives > 0 && lives < 15) {
				guess();
			}
		}

	}

	/**
	 * Stänger konsolen
	 */
	public void close() {
		hcw.exit();
	}

	/**
	 * Ger tillbaka nästa char som skrivs in i konsolen
	 * 
	 * @return
	 */
	public char nextChar() {
		return hcw.nextChar();
	}

}
