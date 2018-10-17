// URL: https://www.hackerrank.com/challenges/friend-circle-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous

package disjointset;
import java.util.Vector;
import java.io.File;
import java.util.Scanner;

class Edge {
	int x;
	int y;
	int weight;

	Edge(int a, int b, int wt) {
		x = a;
		y = b;
		weight = wt;
	}
}

class UnionFind {
	Vector<Edge>[] edges;
	UnionFind(Vector<Edge> edge) {
		edges = edge;
	}
}

public class FriendCircleQuery {
	public static void main(String[] args) {
		File f = new File("edgelist");
		Scanner sc = new Scanner(f);

	}
}