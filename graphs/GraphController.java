import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

class Graph {
	int v;
	Map<Integer, LinkedList<Integer>> adjList;

	Graph(int v) {
		this.v = v;
		adjList = new HashMap<Integer, LinkedList<Integer>>(v);

		for (int i = 1; i <= v; i++) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			adjList.put(i, list);
		}
	}

	public void addEdge(int a, int b) {
		LinkedList<Integer> list = adjList.get(a);
		list.add(b);
		adjList.put(a, list);
	}

	public void printLinkedList(int v) {
		Iterator<Integer> it = adjList.get(v).iterator();
		System.out.print(v + ": ");
		while (it.hasNext()) {
			System.out.print(it.next()+ " ");
		}
		System.out.println();
	}
	public void printAdjList() {
		for (int i = 1; i <= v; i++) {
			printLinkedList(i);
		}
	}
}

public class GraphController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices ");
		int vert = sc.nextInt();
		System.out.println("Enter the number of edges ");
		int edges = sc.nextInt();
		System.out.println("Enter the edges in the form (a, b) ");
		int e = edges;
		Graph g = new Graph(vert);

		while (e > 0) {
			e -= 1;
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.addEdge(a, b);
		}

		g.printAdjList();

	}
}