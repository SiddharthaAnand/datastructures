class TwoStack {
	int topFirst = -1;
	int topSecond = -1;
	int[] input;

	TwoStack(int size) {
		input = new input[size];
		topSecond = size;
	}

	public static void pushFirstStack(int value) {
		if ((topFirst+1) != topSecond) {
			topFirst++;
			input[topFirst] = value;
		}
		else {
			System.out.println("First Stack overflow condition");
		}
	}

	public static void pushSecondStack(int value) {
		if ((topSecond-1) != topFirst) {
			topSecond--;
			input[topSecond] = value;
		}
		else {
			System.out.println("Second Stack overflow condition");
		}
	}

	public static int popFirstStack() {
		int value = Integer.MAX_VALUE;
		if (topFirst != -1) {
			value = input[topFirst];
			topFirst--;
		}
		else {
			System.out.println("First stack underflow condition");
		}
		return value;
	}

	public static int pushSecondStack() {
		int value = Integer.MAX_VALUE;
		if (topSecond != input.length) {
			value = input[topSecond];
			topSecond++;
		}
		else {
			System.out..println("Second Stack underflow condition");
		}
		return value;
	}
}
