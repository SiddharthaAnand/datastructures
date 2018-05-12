import java.util.Scanner;

class Rectangle {
	int x1, y1, x2, y2;
	Rectangle(int a, int b, int c, int d) {
		x1 = a; y1 = b; x2 = c; y2 = d;
	}
}

class OverlapRectangles {
	static boolean checkRectangleOverlap(Rectangle r1, Rectangle r2) {
		// sidewise rectangles
		if (r1.x2 < r2.x1 || r2.x2 < r1.x1 || r1.y1 < r2.y2 || r2.y1 < r1.y2)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		Rectangle r1 = new Rectangle(a, b, c, d);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		Rectangle r2 = new Rectangle(a, b, c, d);
		if (checkRectangleOverlap(r1, r2)) {
			System.out.println("Rectangles overlap");
		}
		else {
			System.out.println("Rectangles dont overlap");
		}
	}
}
