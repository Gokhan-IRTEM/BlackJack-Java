import java.util.Scanner;

public class BetsAndTables extends Player {

	Scanner scan = new Scanner(System.in);

	double balance; // Takes balance.

	String name; // Takes name.

	double bets; // Take bets.
	// Constructor takes Name and entryBalance from Player (Parent) Class.

	public BetsAndTables(String Name, int Age, double entryBalance) {
		super(Name, Age, entryBalance);

		this.balance = entryBalance;

		this.name = Name;
	}

	// Multiplies bets by two
	public void doubleBet() {
		this.bets = this.bets * 2;
	}

	// Calculates the new balance according to conditions.
	public String newBalance(String gameover) {

		if (gameover.equalsIgnoreCase("game over dealer win")) {

			this.balance -= bets;

			System.out.println("Player Name\tNew Balance");

			System.out.println("  " + name + "\t    " + balance);

		} else if (gameover.equalsIgnoreCase("game over player win")) {

			this.balance += bets;

			System.out.println("Player Name\tNew Balance");

			System.out.println("  " + name + "\t    " + balance);

		} else if (gameover.equalsIgnoreCase("Push")) {

			System.out.println("Player Name\tNew Balance");

			System.out.println("  " + name + "\t    " + balance);

		} else if (gameover.equalsIgnoreCase("Player's Blackjack")) {

			this.balance += (bets * 1.5);
			System.out.println("Player Name\tNew Balance");

			System.out.println("  " + name + "\t    " + balance);

		} else if (gameover.equalsIgnoreCase("Dealer's Blackjack")) {

			this.balance -= (bets);
			System.out.println("Player Name\tNew Balance");

			System.out.println("  " + name + "\t    " + balance);

		} else if (gameover.equalsIgnoreCase("yes")) {
			this.balance = this.balance + (bets / 2) - bets;
		}
		return "  " + name + "\t  " + balance;
	}

	// Takes player's to the table and give information about open price limit.
	public void Table() {
		if (this.balance >= 10 && this.balance < 100) {

			System.out.println(name + ", your seat is ready on table which entry price is 10$.");

			System.out.println("Welcome to table. We wish you luck and a good game for your fun.");

		} else if (this.balance >= 100 && this.balance < 500) {

			System.out.println(name + ", your seat is ready on table which entry price is 100$.");

			System.out.println("Welcome to table. We wish you luck and a good game for your fun.");

		} else if (this.balance >= 500 && this.balance < 1000) {

			System.out.println(name + ", your seat is ready on table which entry price is 500$.");

			System.out.println("Welcome to table. We wish you luck and a good game for your fun.");

		} else if (this.balance >= 1000 && this.balance < 5000) {

			System.out.println(name + ", your seat is ready on table which entry price is 1.000$.");

			System.out.println("Welcome to table. We wish you luck and a good game for your fun.");

		} else if (this.balance >= 5000 && this.balance < 10000) {

			System.out.println(name + ", your seat is ready on table which entry price is 5.000$.");

			System.out.println("Welcome to table. We wish you luck and a good game for your fun.");

		} else if (this.balance >= 10000) {

			System.out.println(name + ", your seat is ready on table which entry price is 10.000$.");

			System.out.println("Welcome to table. We wish you luck and a good game for your fun.");

		} else
			System.out.println("Invalid money entry please enter 0.");

	}

	// Adjust the bets according to conditions.
	public void Bets(double b) {

		this.bets = b;

		int balance1 = 0;

		if (balance >= 10 && balance < 100) {
			balance1 = 1;
		} else if (balance >= 100 && balance < 500) {
			balance1 = 2;
		} else if (balance >= 500 && balance < 1000) {
			balance1 = 3;
		} else if (balance >= 1000 && balance < 5000) {
			balance1 = 4;
		} else if (balance >= 5000 && balance < 10000) {
			balance1 = 5;
		} else if (balance >= 10000) {
			balance1 = 6;
		}

		switch ((int) balance1) {
		case 1:
			if (balance >= 10 && balance < 100 && b <= balance && b >= 10) {

				System.out.println("bets are taken");
			} else if (balance < 10 || balance > 100 || b > balance || b < 10) {
				System.out
						.println("invalid bet.\nPlease enter your bet again between the range of 10$-" + (int) b + "$");

				int b2 = scan.nextInt();

				if (b2 >= 10 && b2 <= balance) {

					System.out.println("bets are taken");
				}

				else if (b2 < 10 || b2 > 100 || b2 > balance) {

					System.out.println(
							"invalid bet.\nPlease enter your bet again between the range of 10$-" + (int) b + "$");

					int b1 = scan.nextInt();

					if (b1 >= 10 && b1 <= balance) {

						System.out.println("bets are taken");
					}

					else

					if (b1 < 10 || b1 > 100 || b1 > balance) {

						System.out.println("Please first learn reading then come again.");
						System.exit(0);
					}

				}
			}
			break;
		case 2:

			if (balance >= 100 && balance < 500 && b <= balance && b >= 100) {

				System.out.println("bets are taken");
			} else if (balance < 100 || balance > 500 || b > balance || b < 100) {
				System.out.println(
						"invalid bet.\nPlease enter your bet again between the range of 100$-" + (int) b + "$");

				int b2 = scan.nextInt();

				if (b2 >= 100 && b2 <= balance) {

					System.out.println("bets are taken");
				}

				else if (b2 < 100 || b2 > 500 || b2 > balance) {
					System.out.println("invalid bet.");

					System.out.println("Please enter your bet again between the range of 100$-" + (int) b + "$");

					int b1 = scan.nextInt();

					if (b1 >= 100 && b1 <= balance) {

						System.out.println("bets are taken");
					}

					else if (b1 < 100 || b1 > 500 || b1 > balance) {

						System.out.println("Please first learn reading then come again.");
						System.exit(0);
					}

				}
			}
			break;
		case 3:

			if (balance >= 500 && balance < 1000 && b <= balance && b >= 500) {

				System.out.println("bets are taken");
			} else if (balance < 500 || balance > 1000 || b > balance || b < 500) {
				System.out.println(
						"invalid bet.\nPlease enter your bet again between the range of 500$-" + (int) b + "$");

				int b2 = scan.nextInt();

				if (b2 >= 500 && b2 <= balance) {

					System.out.println("bets are taken");
				}

				else if (b2 < 500 || b2 > 1000 || b2 > balance) {
					System.out.println("invalid bet.");

					System.out.println("Please enter your bet again between the range of 500$-" + (int) b + "$");

					int b1 = scan.nextInt();

					if (b1 >= 500 && b1 <= balance) {

						System.out.println("bets are taken");
					}

					else

					if (b1 < 500 || b1 > 1000 || b1 > balance) {

						System.out.println("Please first learn reading then come again.");
						System.exit(0);
					}

				}
			}
			break;

		case 4:

			if (balance >= 1000 && balance < 5000 && b <= balance && b >= 1000) {

				System.out.println("bets are taken");
			} else if (balance < 1000 || balance > 5000 || b > balance || b < 1000) {
				System.out.println(
						"invalid bet.\nPlease enter your bet again between the range of 1.000$-" + (int) b + "$");

				int b2 = scan.nextInt();

				if (b2 >= 1000 && b2 <= balance) {

					System.out.println("bets are taken");
				}

				else

				if (b2 < 1000 || b2 > 5000 || b2 > balance) {
					System.out.println("invalid bet.");

					System.out.println("Please enter your bet again between the range of 1.000$-" + (int) b + "$");

					int b1 = scan.nextInt();

					if (b1 >= 1000 && b1 <= balance) {

						System.out.println("bets are taken");
					}

					else

					if (b1 < 1000 || b1 > 5000 || b1 > balance) {

						System.out.println("Please first learn reading then come again.");
						System.exit(0);
					}

				}
			}
			break;
		case 5:

			if (balance >= 5000 && balance < 10000 && b <= balance && b >= 5000) {

				System.out.println("bets are taken");
			} else if (balance < 5000 || balance > 10000 || b > balance || b < 5000) {
				System.out.println(
						"invalid bet.\nPlease enter your bet again between the range of 5.000$-" + (int) b + "$");

				int b2 = scan.nextInt();

				if (b2 >= 5000 && b2 <= balance) {

					System.out.println("bets are taken");
				}

				else

				if (b2 < 5000 || b2 > 10000 || b2 > balance) {
					System.out.println("invalid bet.");

					System.out.println("Please enter your bet again between the range of 5.000$-" + (int) b + "$");

					int b1 = scan.nextInt();

					if (b1 >= 5000 && b1 <= balance) {

						System.out.println("bets are taken");
					}

					else

					if (b1 < 5000 || b1 > 10000 || b1 > balance) {

						System.out.println("Please first learn reading then come again.");
						System.exit(0);
					}

				}
			}
			break;

		case 6:

			if (balance >= 10000 && b <= balance && b >= 10000) {

				System.out.println("bets are taken");
			} else if (balance < 10000 || b > balance || b < 10000) {
				System.out.println(
						"invalid bet.\nPlease enter your bet again between the range of 10.000$-" + (int) b + "$");

				int b2 = scan.nextInt();

				if (b2 >= 10000 && b2 <= balance) {

					System.out.println("bets are taken");
				}

				else

				if (b2 < 10000 || b2 > balance) {
					System.out.println("invalid bet.");

					System.out.println("Please enter your bet again between the eange of 10.000$-" + (int) b + "$");

					int b1 = scan.nextInt();

					if (b1 >= 10000 && b1 <= balance) {

						System.out.println("bets are taken");
					}

					else

					if (b1 < 10000 || b1 > balance) {

						System.out.println("Please first learn reading then come again.");
						System.exit(0);
					}

				}
			}
			break;

		}
	}

}
