/* Referenced from https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html.
 * Guidelines for creating an immutable class,
 * 1. Define the class as final.
 * 2. Do not use setter methods
 * 3. Create all the variables as final/constant.
 */

final class EiffelTower {
	private final int height;
	private final String owner;
	private final String architect;
	private final String address;
	private final String city;
	private final String country;
	
	public EiffelTower(int height, String own, String arch, String add, String ci, String co) {
		this.height = height;
		this.architect = arch;
		this.owner = own;
		this.address = add;
		this.city = ci;
		this.country = co;
	}

	public int getHeight() {
		return height;
	}

	public String getOwner() {
		return owner;
	}

	public String getAddress() {
		return address;
	}

	public String getArchitect() {
		return architect;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getSpecification() {
		return "EiffelTower: [height: " + height + ", country: " + country + "]";
	}
}

class ImmutableClassCreator {
	public static void main(String[] args) {
		System.out.println("Entering the specifications of the Eiffel Tower...");

		int height = 10;
		String address = "";
		String owner = "";
		String architect = "";
		String city = "";
		String country = "";
		
		System.out.println("Address: " + address);
		System.out.println("height: " + height);
		System.out.println("architect: " + architect);
		System.out.println("owner: " + owner);
		System.out.println("city: " + city);
		System.out.println("country: " + country);
		
		System.out.println("Creating an immutable class of Eiffel Tower...");
		
		EiffelTower ref = new EiffelTower(height, owner, architect, address, city, country);
		
		System.out.println("Created an immutable class of Eiffel Tower...");
		System.out.println("Reference returned");


	}
}