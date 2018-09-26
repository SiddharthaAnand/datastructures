package problem_solving;
import problem_solving.Graph;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class KruskalMST {

	private static void readFile(String filename) throws FileNotFoundException {
		File f = new File(filename);
		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			String edge = sc.nextLine();
			System.out.println(edge);
			int nodeOne = edge.charAt(0) - 48;
			int nodeTwo = edge.charAt(2) - 48;
			System.out.println(nodeOne + " " + nodeTwo);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String filename = sc.next();
		readFile(filename);
	}	
}