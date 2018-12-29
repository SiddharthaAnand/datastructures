package strings;

import java.util.*;

class Permute {

	static void permuteString(char[] input, int i) {
		if (i == input.length) {
			System.out.println(input);
		}

		else {
			for (int k = i; k < input.length; k++) {
				swap(input, i, k);
				permuteString(input, i+1);
				swap(input, i, k);
			}
		}
	}

	static void swap(char[] input, int x, int y) {
		char t = input[x];
		input[x] = input[y];
		input[y] = t;
	}

	public static void main(String[] args) {
		String input = "abc";
		char[] inp = input.toCharArray();
		permuteString(inp, 0);
	}
}