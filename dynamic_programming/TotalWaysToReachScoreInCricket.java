// Game of cricket
// Question: Find the number of ways a score can be reached to draw the match.
// Only even scores are considered and scores of 0 and 8 means OUT. The book
// consists of only 10 pages.
// Possible scores: [2, 4, 6]

import java.util.Scanner;

class TotalWaysToReachScoreInCricket {
	private static int totalWays(int totalScore) {
		if (totalScore < 2 || ((totalScore & 1) != 0)) {
			return 0;
		}
		if (totalScore < 4) {
			return 1;
		}
		int[] scores = new int[totalScore+1];
		scores[2] = 1;
		scores[4] = 2;
		if (totalScore > 4) {
			scores[6] = 1;
			for (int i = 6; i <= totalScore; i++) {
				scores[i] = scores[i] + scores[i-6] + scores[i-4] + scores[i-2];
			}	
		}
		
		return scores[totalScore];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalScore = sc.nextInt();
		System.out.println("Total ways " + totalWays(totalScore));
	}
}