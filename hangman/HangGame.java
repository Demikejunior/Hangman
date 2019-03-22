package hangman;


public class HangGame {
	
	public static String word;
	public static String reverseWord;
	public static int lives;
	public static HangmanConsoleWindow hcw;
	
	public HangGame(String initWord) {
		
		hcw = new HangmanConsoleWindow();
		lives = 11;
		hcw.println("Välkommen till hängagubben! \r\n" + "Du har " + lives + " liv");
		word = initWord;
		reverseWord = reverse(initWord);
		
		for (int i = lives; i > 0; i++) {
			paint();
			loseLife();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
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
			if (toReverse.charAt(i) != ' ') {
				reversed += '-';
			} else {
				reversed += ' ';
			}
		}
		
		return reversed;
		
	}
	
	public static void guess(char g) {
		boolean exist = false;
		for (int i = 0; i < word.length(); i++) {
			if (g == word.charAt(i)) {
				exist = true;
				String s = "";
				if (i != 0) {
					s += reverseWord.substring(0, i - 1);
				}
				
				s += g;
				
				if (word.length() != i) {
					s += reverseWord.substring(i + 1);
				}
				
				reverseWord = s;
			}
		}
		if (!exist) {
			hcw.println("Du gissade fel!");
			loseLife();
			paint();
		} else {
			hcw.println("Du gissade rätt!");
			paint();
		}
		
	}
	
	public static void show() {
		if (!reverseWord.equals(word)) {
			hcw.println(reverseWord);
		} else {
			hcw.println("DU HAR VUNNIT!");
		}
	}
	
	public static void paint() {
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

		hcw.print(obj);
	}
	
}
