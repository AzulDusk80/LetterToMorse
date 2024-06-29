package random;
import java.util.Scanner;

public class LetterToMorse {

	static final String mCode[] = {"*-", "-***", "-*-*", "-**", "*", "**-*", "--*", "****", "**", "*---", "-*-", "*-**", "--", "-*", "---", "*--*", "--*-", "*-*", "***", "-", "**-", "***-", "*--", "-**-", "-*--", "--**"};

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while(true) {
			System.out.println("1.Word to Morse Code\n2.Morse Code to Word\n3.Exit");
			String user = input.nextLine();
			while(true) {
				if(user.equals("1") || user.equals("2") || user.equals("3")) {
					break;
				}
				System.out.println("Not a valid input" + user);
				user = input.nextLine();
			}

			if(user.equals("1")) {
				System.out.println("Enter word to translate (only letters):");
				user = input.nextLine();
				user.toLowerCase(); 

				System.out.println(letterToMorse(user));
			}

			else if(user.equals("2")) {
				System.out.println("Enter morse to translate (only * and -) seperated by space, unkown code will be ?:");
				user = input.nextLine();

				System.out.println(morseToLetter(user));
			}

			else {
				break;
			}

		}
		
		input.close();
	}

	public static String morseToLetter(String morse) {
		String letter = "";
		String words[] = morse.split(" ");

		for(String w : words) {
			boolean unkown = true;
			for(int i = 0; i < mCode.length; i++) {
				if(mCode[i].equals(w)) {
					unkown = false;
					char l = (char) (97 + i);
					letter += l;
				}
			}
			
			if (unkown) {
				letter += "?";
			}
		}

		return letter;
	}

	public static String letterToMorse(String word) {
		String morse = "";
		for(int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			morse += mCode[letter - 97] + " ";
		}

		return morse;
	}
}
