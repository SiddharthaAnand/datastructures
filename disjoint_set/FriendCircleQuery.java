// URL: https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous

package disjointset;
import java.util.Vector;
import java.io.File;
import java.util.Scanner;
import disjointset.Edge;
import java.io.IOException;

class UnionFind {
	Vector<Edge> edges;
	UnionFind() {
		edges = new Vector<Edge>();
	}

	void addEdge(Vector<Edge> edgelist) {
		edges = edgelist;
	}

	void getTotalEdge() {
		
	}
}

public class FriendCircleQuery {
	public static void main(String[] args) {
		try {
			File f = new File("edgelist");
			Vector<Edge> edgelist = new Vector<Edge>();
			UnionFind ufind = new UnionFind();
			Scanner sc = new Scanner(f);

			while (sc.hasNext()) {
				String split[] = sc.next().split(" ");
				int a = split[0].charAt(0);
				int b = split[1].charAt(0);
				int wt = split[2].charAt(0);
				edgelist.add(new Edge(a, b, wt));
			}

			ufind.addEdge(edgelist);
		}
		catch(IOException e) {
			System.out.println(e);
		}



	}
}