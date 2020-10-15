/* Question:
Program to find-
1.the length of longest substring which does not have any repeated characters.
2.the length of longest substring which has all characters in alphabetical order
Print answer as per user's choice
 */

import java.io.*;

class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstringInAlphabeticalOrder(String input) {
        int ans = 0;
        if (input == null && input.length() == 0) {
            return ans;
        }
        if (input.length() == 1) {
            return 1;
        }
        for (int i = 0, j = 1; i < input.length() && j < input.length();) {
            if (input.charAt(j-1) < input.charAt(j)) {
                ans = Math.max(j - i + 1, ans);
                j++;
            }
            else {
                i = j;
                j++;
            }
        }
        return ans;
    }

    /* Sliding Window where the window has only unique characters in every iteration.
     * Every character visit is done only once.
     * Time Complexity: O(n)
     * Space complexity: O(n)
     */
    public static int lengthOfLongestSubstringContainingUniqueCharacters(String input) {
        int ans = 0;
        if (input == null || input.length() == 0) {
            return ans;
        }
        int map[]=new int[26];
        for (int i = 0, j = 0; i < input.length() && j < input.length();) {
            if (map[input.charAt(j)-'a']!=0) {
                // Jump after that index since till that index you will be having a duplicate value.
                i = map[input.charAt(j)-'a'];
            }
            map[input.charAt(j)-'a']=j+1;   //we are using 1 based indexing
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
    public static void main(String[] args)throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));

        while (true)    //program will run multiple times (not stop until user exits)
        {
            System.out.println("This code prints the following: ");
            System.out.println("1. Returns the longest substring containing unique characters.");
            System.out.println("2. Returns the longest substring containing sorted alphabetically characters.");
            System.out.println("3. Exit.");
            System.out.println("Which one do you want to choose? 1/2/3");

            String ch = bu.readLine();
            switch (ch) {
                case "1":
                    System.out.println("Enter the string to be given as input: ");
                    System.out.println(lengthOfLongestSubstringContainingUniqueCharacters(bu.readLine()));
                    break;
                case "2":
                    System.out.println("Enter the string to be given as input: ");
                    System.out.println(lengthOfLongestSubstringInAlphabeticalOrder(bu.readLine()));
                    break;
                case "3":
                    return;
                default:
                    break;
            }
        }
    }
}
