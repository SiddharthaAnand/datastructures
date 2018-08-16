/* Remove a character from a string recursively/iteratively.
 * Understand the usages of StringBUilder and String Buffer,
 * and String class.
 */

package strings;

public class RemoveCharacter {
	public static void removeCharacterIter(String text, char ch) {
		String newString = "";
		for (int idx = 0; idx < text.length(); idx++) {
			if (text.charAt(idx) != ch) {
				newString += text.charAt(idx);
			}
		}
		System.out.println("Remvoed character: " + newString);
	}
	
	public static void removeCharacterRecur(String text, char ch) {

	}

	private static void testCases() {
		//removeCharacterRecur()
		removeCharacterIter("Siddhartha", 'd');
	}

	public static void main(String[] args) {
		testCases();
	}
}