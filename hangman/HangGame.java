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
		hcw.println("V�lkommen till h�nga gubben! \r\n" + "Du har " + lives + " liv" + "\n"
				+ "Klicka p� en knapp f�r att g� vidare");
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
	 * S�nker antal kvarvarande liv med 1.
	 */
	private static void loseLife() {
		lives--;
	}

	/**
	 * Skriver ut tP i konsolen, med n�sta utskrift p� samma rad.
	 * 
	 * @param tP
	 */
	public void print(String tP) {
		hcw.print(tP);
	}

	/**
	 * Skriver ut tP i konsolen, med n�sta utskrift p� n�sta rad.
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
	 * Fixar allt ang�ende gissningar.
	 */
	public static void guess() {

		// Din gissning
		String G = hcw.nextString().toLowerCase();

		// Kollar om gissningen �r en bokstav eller inte
		if (G.length() == 1) {

			char g = G.charAt(0); // Skapar en char ifr�n gissningen
			boolean exist = false;
			guessed += g + " "; // L�gger till gissningen i listan av dina gissningar
			for (int i = 0; i < word.length(); i++) { // G�r igenom ordet som ska gissas och kollar om n�gon / n�got av
														// bokst�verna �r det som gissades
				if (g == word.charAt(i)) {
					exist = true; // G�r att du inte f�rlorar ett liv, eftersom att bokstaven du gissade fanns

					// F�ljande g�r om reverseWord till att ha med gissnigen

					String s = "";

					if (i > 0) { // Om g ligger efter f�rsta karakt�ren l�gg till alla delar innan g till s
						s += reverseWord.substring(0, i);
					}

					s += g; // l�gg till g till s

					if (i <= word.length() - 1) { // Om g ligger f�re sista karakt�ren l�gg till alla delar efter g till
													// s
						s += reverseWord.substring(i + 1);
					}

					reverseWord = s;
				}

			}
			if (exist) {
				paint("Du gissade r�tt!");
			} else {
				loseLife();
				paint("Du gissade fel!");
			}
		} else { // Om gissningen var mer �n en bokstav
			if (G.equals(word)) { // Kollar om det som gissades �r samma som ordet som ska gissas
				win();
			} else {
				hcw.println("Gissa bokst�ver ist�llet");
				guess();
			}
		}

	}

	/**
	 * S�tter liv till antalet som visat att man vunnit, <br>
	 * sedan utf�r paint()
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
	 * vad den har gissat p�, <br>
	 * vilka delar av ordet den har gissat r�tt, <br>
	 * samt en maning och ett tillf�lle att gissa
	 */
	public static void paint() {
		paint("");
	}

	/**
	 * Skriver ut spelarens situation, <br>
	 * vad den har gissat p�, <br>
	 * vilka delar av ordet den har gissat r�tt, <br>
	 * ett meddelande som skickas med, <br>
	 * samt en maning och ett tillf�lle att gissa
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
		
		if (lives > 0 && lives < 15) { // Om man inte har vunnit eller f�rlorat
			show(); // Visar bokst�verna du har gissat r�tt i de platser som de ska ligga

			if (guessed.length() > 0) { // Om det har gissats n�gon bokstav skrivs de bokst�ver ut
				hcw.println("Du har gissat p� " + guessed);
			} else { // Om det inte har gissats p� n�gra bokst�ver manas anv�ndaren att g�ra det
				hcw.println("Gissa p� en bokstav");
			}
			if (lives > 0 && lives < 15) {
				guess();
			}
		}

	}

	/**
	 * St�nger konsolen
	 */
	public void close() {
		hcw.exit();
	}

	/**
	 * Ger tillbaka n�sta char som skrivs in i konsolen
	 * 
	 * @return
	 */
	public char nextChar() {
		return hcw.nextChar();
	}

}
