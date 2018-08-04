import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Class denotes Package which has its attributes. 
 * Pick items which maximize the total value of the 
 * things that can be picked.
 *
 */
class PackageBox {
	private int maxWeightLimit;
	private ArrayList<Integer> costs;
	private ArrayList<Integer> weights;
	private int numberOfItems;
	private int solution[][];

	PackageBox(int maxWeightLimit, ArrayList<Integer> costs, ArrayList<Integer> weights) {
		this.numberOfItems = costs.size();
		this.maxWeightLimit = maxWeightLimit;
		this.costs = costs;
		this.weights = weights;
		solution = new int[costs.size()+1][maxWeightLimit+1];
	}

	int max(int first, int second) {
		return first > second ? first : second;
	}

	/* Calculates the maximum possible cost that can be gained
	 * by filling the package with the things available.
	 * 
	 */
	public void pickItems() {
		for(int index = 0; index <= costs.size(); index++) {
		    for(int wIndex = 0; wIndex <= maxWeightLimit; wIndex++) {
		    	if (index == 0 || wIndex == 0)
		            solution[index][wIndex] = 0;
		        else if (weights.get(index-1) < wIndex)
		        	solution[index][wIndex] = max(costs.get(index-1) + solution[index-1][wIndex-weights.get(index-1)],  solution[index-1][wIndex]);
		        else
		        	solution[index][wIndex] = solution[index-1][wIndex];
		    }
		}
		System.out.println(this.thingsPutInPackage(costs.size(), maxWeightLimit));
	}
	/* Lists out the index of the things that can be put in the Package.
	 * @param index the index value in the solution array which represents the 
	 *        the index of the current item being considered.
	 * @param wIndex the weight which is considered as the maximum load that
	 *        can be taken by the package.
	 * @returns the index of the thing that is put in the package.
	 */
	public String thingsPutInPackage(int index, int wIndex) {
		if(index == 0)
			return "";
		if(solution[index][wIndex] > solution[index-1][wIndex]) {
			return thingsPutInPackage(index-1, wIndex - weights.get(index-1))  + index + ", " ;
		}
		return thingsPutInPackage(index-1, wIndex);
	}
}

/* A helper class to PackageBox, which handles the read of input file.
 */
class PackageProblemInputHandler {
	
	private int maxWeightLimit;
	/* @returns boolean id the filePath exists or not.
	 * @param filePath value of the path to the file.
	 */
	public boolean checkFilePath(String filePath) throws FileNotFoundException {
		Path path = Paths.get(filePath);
		boolean fileExists = Files.exists(path);
		return fileExists;
	}
	/* Reads the contents line by line (each 
	 * test case from every line), uses Pattern and Matcher Classes to 
	 * to extract weight and cost values. The weight and cost are added
	 * in ArrayList of equal sizes. After every successful read, a call
	 * to pickItems() lists out the solution. 
	 * @param filePath Path to the file. 
	 */
	public void extractContents(String filePath) throws IOException {
		ArrayList<Integer> weights, costs;
		Pattern weightPattern = Pattern.compile("[0-9]*\\.[0-9]*");
		Pattern costPattern = Pattern.compile("\\$[0-9]+");
		Pattern maxWeightPattern = Pattern.compile("^[0-9]+");
		String currentLine;
		int index = 0;

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while((currentLine = br.readLine()) != null) {
			weights = new ArrayList<Integer>();
			costs = new ArrayList<Integer>();
		
			Matcher weightMatcher = weightPattern.matcher(currentLine);
			Matcher costMatcher = costPattern.matcher(currentLine);
			Matcher maxWeightMatcher = maxWeightPattern.matcher(currentLine);
			boolean weightPresent = maxWeightMatcher.find();
			maxWeightLimit = Integer.parseInt(maxWeightMatcher.group()) * 100;
			while(weightMatcher.find() && costMatcher.find()) {
				Double d = Double.parseDouble(weightMatcher.group()) * 100;
				weights.add(d.intValue());
				costs.add(Integer.parseInt(currentLine.substring(costMatcher.start() + 1, costMatcher.end())));
			}
			new PackageBox(maxWeightLimit, costs, weights).pickItems();
		}
	}
}

public class PackageProblemController {
	static ArrayList<ArrayList<Object>> itemDetails = new ArrayList<ArrayList<Object>>();
	public static void main(String[] args) throws IOException, FileNotFoundException {
		if(args.length != 1) {
			System.out.println("\n\nInvalid length " + args.length + " arguments.\n");
			System.out.println("Usage: java PackageProblemController pathToFile\n");
			System.exit(-1);
		}

		PackageProblemInputHandler pHandle = new PackageProblemInputHandler();
		if(pHandle.checkFilePath(args[0])) {
			pHandle.extractContents(args[0]);
		}

	}
}