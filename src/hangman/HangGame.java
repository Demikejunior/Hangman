package hangman;


public class HangGame {
	
	public static String word;
	public static String reverseWord;
	public static int lives;
	public static HangmanConsoleWindow hcw;
	
	public HangGame(String initWord) {
		
		hcw = new HangmanConsoleWindow();
		hcw.println("V�lkommen till h�ngagubben! \r\n" + "Du har " + lives + " liv");
		word = initWord;
		reverseWord = reverse(initWord);
		lives = 0;
		
	}
	
	public int lives() {
		return lives;
	}
	
	public static void loseLife() {
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
			hcw.println("Du gissade r�tt!");
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
			obj += "    ______          \n";
			obj += "   |/     |          \n";
			obj += "   |      |          \n";
			obj += "   |      |          \n";
			obj += "   |      |          \n";
			obj += "  /|\\___  X  __    \n";
			obj += " |       /|\\   |   \n";
			obj += " |       / \\   |   \n";
			obj += " |   DU  DOG   |   \n";

		default:
			break;
		}

		hcw.print(obj);
	}
	
}
