// URL: https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous

package disjointset;
import java.util.Vector;
import java.io.File;
import java.util.Scanner;
import Edge.Edge;

class UnionFind {
	Vector<Edge>[] edges;
	UnionFind(int totalEdges) {
		edges = new Vector<Edge>[totalEdges];
	}

	void addEdge(int a, int b, int wt) {
		edges.add(new Edge(a, b, wt));
	}

	void getTotalEdge() {
		return edges.length;
	}
}

public class FriendCircleQuery {
	public static void main(String[] args) {
		try {
			File f = new File("edgelist");
			UnionFind ufind = new UnionFind();
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String split[] = sc.next().split();
				int a = (Integer)split[0].charAt(0);
				int b = (Integer)split[1].charAt(0);
				int wt = (Integer)split[2].charAt(0);

			}
		}
		catch(IOException e) {
			System.out.println(e.printStackTrace());
		}



	}
}