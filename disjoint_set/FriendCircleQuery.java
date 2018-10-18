// URL: https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous

package disjoint_set;
import java.util.Vector;
import java.io.File;
import java.util.Scanner;

import java.io.IOException;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

class UnionFind {
	Vector<Edge> edges;
	UnionFind() {
		edges = new Vector<Edge>();
	}

	void addEdge(Vector<Edge> edgelist) {
		edges = edgelist;
	}

	void sortEdgeByWeight() {
		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge a, Edge b) {
				if (a.weight < b.weight)
					return -1;
				return 1;
			}

		});
	}

	void printEdge() {
		Iterator<Edge> it = edges.iterator();

		while (it.hasNext()) {
			Edge e = it.next();
			System.out.println(e.x + " " + e.y + " " + e.weight);
		}
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
				String split[] = sc.nextLine().split(" ");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				int wt = Integer.parseInt(split[2]);
				edgelist.add(new Edge(a, b, wt));
			}

			ufind.addEdge(edgelist);
			ufind.sortEdgeByWeight();
			ufind.printEdge();
		}
		catch(IOException e) {
			System.out.println(e);
		}



	}
}