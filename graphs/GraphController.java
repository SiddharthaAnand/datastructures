import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
	int v;
	boolean[] visited;
	Map<Integer, LinkedList<Integer>> adjList;

	Graph(int v) {
		this.v = v;
		visited = new boolean[v+1];
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
		list = adjList.get(b);
		list.add(a);
		adjList.put(b, list);
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

	public void startDFS(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		Iterator<Integer> it = adjList.get(start).iterator();
		while (it.hasNext()) {
			int v = it.next();
			if (!visited[v]) {
				startDFS(v);
			}
		}
	}

	public void initializeVisited() {
		for (int i = 1; i <= v; i++) {
			visited[i] = false;
		}
	}

	public void startBFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int v = q.remove();
			Iterator<Integer> it = adjList.get(v).iterator();
			while (it.hasNext()) {
				int vert = it.next();
				if (!visited[vert]) {
					visited[vert] = true;
					System.out.print(vert +" ");
					q.add(vert);
				}
			}
		}
		System.out.println();
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

		System.out.println("Enter the start vertex to start DFS: ");
		int start = sc.nextInt();
		g.printAdjList();
		g.startDFS(start);
		g.initializeVisited();
		System.out.println();
		g.startBFS(start);
	}
}