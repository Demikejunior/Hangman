package hangman;


public class HangGame {
	
	public static String word;
	public static String reverseWord;
	public static int lives;
	public static HangmanConsoleWindow hcw;
	
	public HangGame(String initWord) {
		
		hcw = new HangmanConsoleWindow();
		hcw.println("Välkommen till hängagubben! \r\n" + "Du har " + lives + " liv");
		word = initWord;
		reverseWord = reverse(initWord);
		lives = 9;
		
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
	
	public static void paint() {
		
		
		
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
			lives--;
			paint();
		} else {
			hcw.println("Du gissade rätt!");
			paint();
		}
		
	}
	
}
