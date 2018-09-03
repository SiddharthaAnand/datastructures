/* URL: https://www.geeksforgeeks.org/boggle-set-2-using-trie/
 *
 */

package trie;
import trie.Trie;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;

public class Boggle {

	// Will be called everytime to search a word in trie
	private static boolean search(String word, Trie dictionary) {
		boolean present = false;
		if (dictionary.search(word) == true) {
			present = true;
		}
		return present;
	}

	public static void traverseBoggle(Character[][] boggle) {

	}

	public static void playBoggle(Character[][] boggle) {
		// Store the boggle words here
		Vector<String> boggleWords = new Vector<String>();

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of boggle crossword(must be a square): ");
		int size = sc.nextInt();
		int row = size;
		System.out.println("Enter the boggle crossword: ");
		Character boggle[][] = new Character[size][size];
		int idx = 0;
		while (size > 0) {
			size--;
			String input = sc.next();
			for (int idx_col = 0; idx_col < row; idx_col++) {
				boggle[idx][idx_col] = input.charAt(idx_col);
			}
			idx++;
		}

		// Read the words to put in the dictionary so that the code
		// can play boggle using those words
		File fPtr = new File("most_common_english_words.txt");
		sc = new Scanner(fPtr);
		Trie dictionary = new Trie();

		// Iterate over the file and insert in the dictionary line-by-line.
		while (sc.hasNextLine()) {
			String word = sc.nextLine();
			dictionary.insert(word);
		}

		playBoggle(boggle);
	}	
}