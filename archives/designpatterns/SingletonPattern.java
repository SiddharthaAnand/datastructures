// Singleton Class Implementation
// Double check obj instead of using synchronized keyword

class SingletonDesignPattern {

	int a;
	// volatile keyword updates directly in memory
	// and no copy is kept in cache.
	// So, without using synchronized, all threads
	// can use it since it is picked from the memory.
	static volatile SingletonDesignPattern instance = null;
	private SingletonDesignPattern(int b) {
		a = b;
	}

	static public SingletonDesignPattern getInstance() {
		if (instance == null) {
			synchronized (SingletonDesignPattern.class) {
				if (instance == null) {
					instance =  new SingletonDesignPattern(10);
				}
			}
		}
		return instance;
	}
}

class SingletonPattern {

	public static void main(String[] args) {
		SingletonDesignPattern s1 = SingletonDesignPattern.getInstance();
		SingletonDesignPattern s2 = SingletonDesignPattern.getInstance();
			
		s1.a += 10;
		System.out.println("s1.a = " + s1.a);
		System.out.println("s2.a = " + s2.a);
	}
}

