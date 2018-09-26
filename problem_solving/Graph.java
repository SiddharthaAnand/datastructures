/* Find a cycle in a directed graph
 */

package problem_solving;
import java.util.LinkedList;
import java.util.ArrayList;

public class Graph {
	int nodes;
	ArrayList<Integer>adjacencyList[];

	Graph(int n) {
		nodes = n;
		adjacencyList = new ArrayList[n];
	}

	public void addEdge(int a, int b) {
		if (a < b)
			adjacencyList[a].add(b);
		else
			adjacencyList[b].add(a);
	}
}