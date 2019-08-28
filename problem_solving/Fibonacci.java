class Fibonacci {
	public static int constantTimeFiboFinder(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		double phi = (Math.sqrt(5) + 1) / 2;
		return (int) (Math.pow(phi, n) * Math.sqrt(5));
	}

	public static void main(String[] args) {
		System.out.println("Finding fibonacci using different methods...");
		System.out.println(constantTimeFiboFinder(3));
	}
}