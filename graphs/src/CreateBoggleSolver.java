
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

class BoggleSolver {
	ArrayList<String> list = new ArrayList<String>();
	public void solveBoggle(char[][] boggleStore, boolean[][] boggleVisited, int r, int c, String result, HashMap<String, Boolean> dictionary) {
		if (boggleStore == null || boggleVisited == null) {
			return;
		}
		if (r < 0 || c < 0 || r >= boggleStore.length || c >= boggleStore[0].length) {
			return;
		}
		if (dictionary.containsKey(result)) {
			list.add(result);
		}

		if (!boggleVisited[r][c]) {
			boggleVisited[r][c] = true;
			for (int i = r; i < boggleStore.length; i++) {
				for (int j = c; j < boggleStore[0].length; j++) {
					this.solveBoggle(boggleStore, boggleVisited, i, j+1, result + boggleStore[i][j], dictionary);
					this.solveBoggle(boggleStore, boggleVisited, i+1, j+1, result + boggleStore[i][j], dictionary);
					this.solveBoggle(boggleStore, boggleVisited, i+1, j, result + boggleStore[i][j], dictionary);
					this.solveBoggle(boggleStore, boggleVisited, i-1, j-1, result + boggleStore[i][j], dictionary);
					this.solveBoggle(boggleStore, boggleVisited, i, j-1, result + boggleStore[i][j], dictionary);
					this.solveBoggle(boggleStore, boggleVisited, i-1, j-1, result + boggleStore[i][j], dictionary);
					this.solveBoggle(boggleStore, boggleVisited, i-1, j, result + boggleStore[i][j], dictionary);
					this.solveBoggle(boggleStore, boggleVisited, i-1, j+1, result + boggleStore[i][j], dictionary);
				}
			}
			boggleVisited[r][c] = false;
		}
	}

	public void printList() {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

public class CreateBoggleSolver {
	public static void main(String[] args) {
		BoggleSolver bs = new BoggleSolver();
		char[][] boggleStore = {{'G', 'I', 'Z'},
                       {'F', 'E', 'K'},
                       {'F', 'I', 'Z'},
                       {'F', 'U', 'K'},
                       {'Q', 'S', 'E'}};
		HashMap<String, Boolean> dictionary = new HashMap<String, Boolean>();
		dictionary.put("GEEK", true);
		dictionary.put("GEEKS", true);
		dictionary.put("FOR", true);
		dictionary.put("QUIZ", true);
		dictionary.put("GO", true);

		boolean[][] boggleVisited = new boolean[boggleStore.length][boggleStore[0].length];
		bs.solveBoggle(boggleStore, boggleVisited, 0, 0, "", dictionary);
		bs.printList();
	}
}