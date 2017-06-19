// Java program to print permutations of a given string with spaces
import java.io.*;
import java.util.Scanner;
class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n != 0) {
            String str = sc.nextLine();
            Permutation p = new Permutation();
            p.printPattern(str);
            n -= 1;
            System.out.println();
            
        }
    }
}
class Permutation
{
    // Function recursively prints the strings having space pattern
    // i and j are indices in 'String str' and 'buf[]' respectively 
    static void printPatternUtil(String str, char buf[], int i, int j, int n)
    {
        if(i == n)
        {
            buf[j] = '\0';
            System.out.print("(");
            for(int k = 0; k < j; k++)
                System.out.print(buf[k]);
            System.out.print(")");
            return;
        }
        if(buf[j-1] == ' ') {
            buf[j] = str.charAt(i);
           printPatternUtil(str, buf, i+1, j+1, n);
        }
        else {
            buf[j] = str.charAt(i);
            printPatternUtil(str, buf, i+1, j+1, n);
            buf[j] = ' ';
            printPatternUtil(str, buf, i, j+1, n);
            
        }
    }
 
    // Function creates buf[] to store individual output string and uses
    // printPatternUtil() to print all permutations
    static void printPattern(String str)
    {
        int len = str.length();
 
        // Buffer to hold the string containing spaces
        // 2n-1 characters and 1 string terminator
        char[] buf = new char[2*len];
 
        // Copy the first character as it is, since it will be always
        // at first position
        buf[0] = str.charAt(0);
        printPatternUtil(str, buf, 1, 1, len);
    }
 

}