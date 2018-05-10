// Code to check contents of array are equal.
import java.util.Scanner;
import java.util.Arrays;

class ReverseString {
	
	static void reverseWord(String word) {
		if (word == null || word.length() == 0)
			System.out.println("");
		StringBuffer sb = new StringBuffer();
		for (int i = word.length()-1; i >= 0; i--) {
			sb.append(word.charAt(i));
		}
		System.out.print(sb + " ");
	}

	static void reverseSentence(String sentence) {
		if (sentence == null || sentence.length() == 0)
			System.out.println("Sentence is null or empty");
		StringBuffer revSentence = new StringBuffer();
		int pos = sentence.length();
		StringBuffer sb = new StringBuffer();
		for (int i = sentence.length()-1; i >= 0; i--) {
			if (sentence.charAt(i) == ' ' || i == 0) {
				if ( i == 0)
					sb.append(sentence.substring(i, pos));
				else
					sb.append(sentence.substring(i+1, pos));
				pos = i;
				revSentence.append(sb + " ");
				sb = new StringBuffer();
			}

		}
		System.out.println("Reverse Sentence: " + revSentence);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input a sentence instead of a word.
		String input = sc.nextLine();
		String words[] = input.split(" ");
		System.out.println("Reverse words: ");
		for (int i= 0; i < words.length; i++)
			reverseWord(words[i]);
		reverseSentence(input);
	}
}