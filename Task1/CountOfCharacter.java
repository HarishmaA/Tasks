package Tasks;

import java.util.Scanner;

public class CountOfCharacter {
	public int getTheCountOfCharacter(String sentence, char character) {
		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == character)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		CountOfCharacter obj = new CountOfCharacter();
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();
		char character = scanner.next().charAt(0);
		System.out.println(obj.getTheCountOfCharacter(sentence, character));
		scanner.close();
	}
}
