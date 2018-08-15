import java.util.Scanner;

class CountSubsequencePallindrome {
    static int countPallindrome(String input) {
        int n = input.length();
        int arr[][] = new int[n][n];

        for(int i = 0; i < n; i++)
            arr[i][i] = 1;

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int k = l+i-1;
                if(k < n) {
                if (input.charAt(i) == input.charAt(k)) {
                    arr[i][k] = arr[i+1][k] + arr[i][k-1] + 1;
                }
                else
                    arr[i][k] = arr[i+1][k] + arr[i][k-1] - arr[i+1][k-1];
            }
            }
        }
        return arr[0][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(countPallindrome(input));
    }
}