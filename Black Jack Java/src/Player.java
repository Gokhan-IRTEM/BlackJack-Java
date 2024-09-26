public class Player extends Dealer {

	protected String name; // Takes names.

	protected int age; // Takes ages.

	protected double entrybalance; // Takes entry balance.

	public int playerscards[]; // Keeps player's cards.

	// Constructor takes name, age and entry balance from Dealer class
	public Player(String Name, int Age, double entryBalance) {

		this.name = Name;

		this.age = Age;

		this.entrybalance = entryBalance;

	}

	// Prints name, age, entry balance
	public String toString() {

		System.out.println(name + " \t" + age + "\t " + entrybalance);

		return name + " \t" + age + "\t " + entrybalance;

	}

	// Keeps player's hand value
	public void playercardArray(int groupnum, int card) {

		playerscards = new int[groupnum * 6];

		int count = 0;

		playerscards[count] = card;

		count++;

	}

	// Prints player hand
	public void ToString() {

		System.out.println(playerscards[0]);

	}

}