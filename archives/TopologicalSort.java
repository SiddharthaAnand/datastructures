// Printing Topological Sort using DFS
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Iterator;

class Graph {
	int nodes;
	LinkedList<Integer> adj[];
	Graph(int nodes) {
		this.nodes = nodes;
		adj = new LinkedList[nodes];

		for (int i = 0; i < nodes; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int a, int b) {
		adj[a].add(b);
	}

	void doDFSUtil(int node, boolean visited[], Stack stack) {
		visited[node] = true;

		Iterator<Integer> it = adj[node].listIterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n])
			doDFSUtil(n, visited, stack);
		}
		stack.push(node);
	}

	void doDFS() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[nodes];
		for (int i = 0; i < nodes; i++)
			visited[i] = false;

		for (int i = 0; i < nodes; i++) {
			if (visited[i] == false)  {
				doDFSUtil(i, visited, stack);
			}
		}
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}


class TopologicalSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		int id = 0;
		Graph g = new Graph(nodes);
		while (id < edges) {
			id++;
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.addEdge(a, b);
		}
		g.doDFS();
	}
}