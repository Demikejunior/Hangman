package hangman;

public class HangGame {

	public static String word;
	public static String reverseWord;
	public static int lives;
	public static HangmanConsoleWindow hcw;
	public static String guessed = "";

	public HangGame(String initWord) {

		hcw = new HangmanConsoleWindow();
		lives = 11;
		word = initWord.toLowerCase();
		reverseWord = reverse(initWord);
		hcw.println("Välkommen till hänga gubben! \r\n" + "Du har " + lives + " liv" + "\n"
				+ "Klicka på en knapp för att gå vidare");
		hcw.nextChar();
		paint();

//		for (int i = lives; i > 0; i++) {
//			paint();
//			loseLife();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//
//			}
//		}

	}

	public int lives() {
		return lives;
	}

	private static void loseLife() {
		lives--;
	}

	public static void print(String tP) {
		hcw.print(tP);
	}

	public static void println(String tP) {
		hcw.println(tP);
	}

	public static void println() {
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

	public static void guess() {

		String G = hcw.nextString().toLowerCase();

		if (G.length() == 1) {
			char g = G.charAt(0);
			boolean exist = false;
			guessed += g + " ";
			for (int i = 0; i < word.length(); i++) {
				if (g == word.charAt(i)) {
					exist = true;
					String s = "";

					if (i > 0) {
						s += reverseWord.substring(0, i);
					}

					s += g;

					if (i <= word.length() - 1) {
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
		} else {
			if (G.equals(word)) {
				win();
			} else {
				hcw.println("Gissa bokstäver istället");
				guess();
			}
		}

	}

	private static void win() {
		lives = -1;
		paint();
	}

	public static void show() {
		if (!reverseWord.equals(word)) {
			hcw.println(reverseWord);
		} else {
			win();
		}
	}

	public static void paint() {
		paint("");
	}

	public static void paint(String message) {
		hcw.clear();

		String obj = "";

		switch (lives) {
		case -1:
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
			break;
		case 0:
			obj += "    ______         \n";
			obj += "   |/     |        \n";
			obj += "   |      |        \n";
			obj += "   |      |        \n";
			obj += "   |      |        \n";
			obj += "  /|\\___|\\X/|__   \n";
			obj += " |       /|\\   |  \n";
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
		

		hcw.println(obj);
		if (lives > 0) {
			hcw.println(message);
			show();
			if (guessed.length() > 0) {
				hcw.println("Du har gissat på " + guessed);
			} else {
				hcw.println("Gissa på en bokstav");
			}
			guess();
		} else {
			hcw.nextChar();
			hcw.exit();
		}

	}

}
