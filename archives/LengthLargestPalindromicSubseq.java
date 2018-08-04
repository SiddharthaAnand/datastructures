import java.util.Scanner;

class LengthLargestPalindromicSubseq {
    static int max(int a, int b) {
        return a > b ? a : b;
    }
    static int lengthPalSubseq(String input) {
        int n = input.length();
        int arr[][] = new int [n][n];
        for (int i = 0; i < n;i++)
            arr[i][i] = 1;

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n-l+1; i++) {
                int k = i+l-1;
                if (input.charAt(i) == input.charAt(k) && l == 2)
                    arr[i][k] = 2;
                else if (input.charAt(i) == input.charAt(k))
                    arr[i][k] = arr[i+1][k-1] + 2;
                else
                    arr[i][k] = max(arr[i][k-1], arr[i+1][k]);
            }
        }
        return arr[0][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(lengthPalSubseq(input));
    }
}