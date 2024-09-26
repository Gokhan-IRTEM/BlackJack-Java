
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Dealer {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to AbstracTED Casino\nTonight is blackjack night");

		System.out.println("");
		System.out.println("  BLACKJACK RULES: ");
		System.out.println(
				"	-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println(
				"	-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total. Players “Double” to multiply their bet by two ");
		System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
		System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println(
				"	-If the player total equals the dealer total, it is a “push” and the hand ends without losing or winning.");
		System.out.println(
				"	-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.");
		System.out.println("");

		System.out.println("Please enter the number of player who wish to play.(max=7)");

		int groupnumber = scan.nextInt(); // takes the number of group members

		System.out.println("How many hands do you wish to play(max=6)");

		int tour = scan.nextInt(); // takes the number of tour that group wish to play

		if (groupnumber > 0 && groupnumber <= 7) {

			if (tour > 0 && tour <= 6) {
				// All the game is in this two if clauses.

				Player player[] = new Player[7];

				String answer;

				String name;

				int age;

				double entrybalance;

				System.out.println("Please enter your name,age,entry balance:");

				BetsAndTables bt[] = new BetsAndTables[7];

				for (int n = 0; n <= groupnumber - 1; n++) {

					System.out.println(n + 1 + ". Player:");

					name = scan.next(); // takes name from player

					age = scan.nextInt(); // takes age from player

					entrybalance = scan.nextDouble(); // takes entry balance from player

					player[n] = new Player(name, age, entrybalance);

					bt[n] = new BetsAndTables(name, age, entrybalance);

					if (age < 18 || age > 100) {
						System.out.println(
								"Your age is restricted for gambling.\nPlease restart with people who is not under 18 and above 100.");

						System.exit(0);
					}

				}
				// prints the general information about what player entered.
				for (int a = 0; a < groupnumber; a++) {

					System.out.println("Name\tAge\tEntry Balance");
					player[a].toString();
					System.out.println("----------------------------------");
				}

				for (int i = 0; i < tour; i++) {

					// Gives general information about table and takes bets.
					for (int t = 0; t < groupnumber; t++) {

						bt[t].Table();

						System.out.println("Bets Please:");

						double bets = scan.nextDouble();

						bt[t].Bets(bets);
						System.out.println("----------------------------------");
					}

					// We defined all cards into hash map in here.
					HashMap<String, Integer> cards = new HashMap<String, Integer>();

					cards.put("Spades Ace", 11);
					cards.put("Spades 2", 2);
					cards.put("Spades 3", 3);
					cards.put("Spades 4", 4);
					cards.put("Spades 5", 5);
					cards.put("Spades 6", 6);
					cards.put("Spades 7", 7);
					cards.put("Spades 8", 8);
					cards.put("Spades 9", 9);
					cards.put("Spades 10", 10);
					cards.put("Spades Jack", 10);
					cards.put("Spades Queen", 10);
					cards.put("Spades King", 10);
					cards.put("Hearts Ace", 11);
					cards.put("Hearts 2", 2);
					cards.put("Hearts 3", 3);
					cards.put("Hearts 4", 4);
					cards.put("Hearts 5", 5);
					cards.put("Hearts 6", 6);
					cards.put("Hearts 7", 7);
					cards.put("Hearts 8", 8);
					cards.put("Hearts 9", 9);
					cards.put("Hearts 10", 10);
					cards.put("Hearts Jack", 10);
					cards.put("Hearts Queen", 10);
					cards.put("Hearts king", 10);
					cards.put("Diamonds Ace", 11);
					cards.put("Diamonds 2", 2);
					cards.put("Diamonds 3", 3);
					cards.put("Diamonds 4", 4);
					cards.put("Diamonds 5", 5);
					cards.put("Diamonds 6", 6);
					cards.put("Diamonds 7", 7);
					cards.put("Diamonds 8", 8);
					cards.put("Diamonds 9", 9);
					cards.put("Diamonds 10", 10);
					cards.put("Diamonds Jack", 10);
					cards.put("Diamonds Queen", 10);
					cards.put("Diamonds King", 10);
					cards.put("Clubs Ace", 11);
					cards.put("Clubs 2", 2);
					cards.put("Clubs 3", 3);
					cards.put("Clubs 4", 4);
					cards.put("Clubs 5", 5);
					cards.put("Clubs 6", 6);
					cards.put("Clubs 7", 7);
					cards.put("Clubs 8", 8);
					cards.put("Clubs 9", 9);
					cards.put("Clubs 10", 10);
					cards.put("Clubs Jack", 10);
					cards.put("Clubs Queen", 10);
					cards.put("Clubs King", 10);

					int playercard1 = 0; // Player's first card
					int dealercard1; // Dealer's first card
					int playercard2 = 0; // Player's second card
					int dealercard2; // Dealer's second card
					int playerhand = 0; // the value of the player's hand
					int dealerhand = 0; // the value of the dealer's hand
					int[] hit = new int[10]; // maximum hit opportunity

					Object[] random = cards.keySet().toArray(); // Takes all cards to random object array
					Object dealerCard1 = random[new Random().nextInt(random.length)]; // Takes a random card

					dealercard1 = cards.get(dealerCard1); // takes the value of the card and equalize to new integer
															// variable.
					cards.remove(dealerCard1); // remove the card from the deck to prevent duplicated versions.

					// These four operations repeats for take card operation.
					random = cards.keySet().toArray();
					Object dealerCard2 = random[new Random().nextInt(random.length)];
					dealercard2 = cards.get(dealerCard2);
					cards.remove(dealerCard2);

					for (int k = 0; k < groupnumber; k++) {
						// We used try catch method to see which values are coming null in the making.
						try {
							System.out.println("----------------\nGame started\n----------------");
							System.out.println(player[k].name + "'s turn.\n----------------");
							System.out.println("Player's first card");
							random = cards.keySet().toArray();
							Object playerCard1 = random[new Random().nextInt(random.length)];
							System.out.println(playerCard1);
							playercard1 = cards.get(playerCard1);
							cards.remove(playerCard1);
							// System.out.println(cards.keySet()); //we use this line to make sure that the
							// card is removed from the deck in the making.
							System.out.println("----------------------------------");

							System.out.println("Dealer's first card");
							System.out.println(dealerCard1);
							// System.out.println(cards.keySet());
							System.out.println("----------------------------------");

							System.out.println("Player's second card");
							random = cards.keySet().toArray();
							Object playerCard2 = random[new Random().nextInt(random.length)];
							System.out.println(playerCard2);
							playercard2 = cards.get(playerCard2);
							cards.remove(playerCard2);
							// System.out.println(cards.keySet());
							System.out.println("----------------------------------");

							System.out.println("Dealer's second card");

							if (dealerCard2 == dealerCard2) {

								System.out.println("*******");
							}

							// System.out.println(dealerCard2);

							// System.out.println(cards.keySet());
							System.out.println("----------------------------------");

							playerhand = (playercard1 + playercard2);
							dealerhand = (dealercard1 + dealercard2);

							System.out.println("player's hand: " + playerhand);
							System.out.println("Dealer's hand: " + dealercard1);

						} catch (NullPointerException exception) {
							System.out.println(exception);
						}
						// In this part dealer have to ask player to secure his money if dealer has ace
						// for the first card
						if (dealercard1 == 11) {

							System.out.println("Do you want to secure your money?(Yes or No)");

							String sec = scan.next();

							bt[k].newBalance(sec); // adjust the balance

							if (sec.equalsIgnoreCase("yes")) {
								break;
							}
						}

						// This while loop includes player's choices
						while (playerhand < 21 || dealerhand == 21) {

							System.out.println(
									"Do you wish to take a card, double it or stay? (enter hit or stay or double)");

							answer = scan.next();
							int count = 0;
							// Player takes card in this if clause
							if (answer.equalsIgnoreCase("hit")) {

								random = cards.keySet().toArray();
								Object playerHit = random[new Random().nextInt(random.length)];
								int playerhit = cards.get(playerHit);
								cards.remove(playerHit);
								hit[count] = playerhit;
								System.out.println("card: " + playerHit);
								// System.out.println(cards.keySet());
								playerhand += hit[count];

								// Here, we adjust the value of ace according to Blackjack rules.
								if ((playercard1 == 11 || playercard2 == 11 || hit[0] == 11) || hit[1] == 11
										|| hit[2] == 11 || hit[3] == 11) {

									if (playercard1 == 11) {

										playercard1 = 1;

										playerhand += playercard1 + (-11);
									}
									if (playercard2 == 11) {

										playercard2 = 1;

										playerhand += playercard2 + (-11);
									}
									if (hit[0] == 11) {

										hit[0] = 1;

										playerhand += hit[0] + (-11);
									}
									if (hit[1] == 11) {

										hit[1] = 1;

										playerhand += hit[1] + (-11);
									}
									if (hit[2] == 11) {

										hit[2] = 1;

										playerhand += hit[2] + (-11);
									}
									if (hit[3] == 11) {

										hit[3] = 1;

										playerhand += hit[3] + (-11);
									}

								}

								System.out.println("player hand: " + playerhand);
								System.out.println("dealer hand: " + dealercard1);

							}
							// Player choose to stay on his/her value of hand
							else if (answer.equalsIgnoreCase("stay")) {

								System.out.println("player hand: " + playerhand);
								System.out.println("dealer hand: " + dealercard1);

								break;
							}
							// Player makes his/her bet double, takes only one card and goes on.
							else if (answer.equalsIgnoreCase("double") && count == 0
									&& bt[k].bets * 2 <= bt[k].entrybalance) {
								random = cards.keySet().toArray();
								Object playerDouble = random[new Random().nextInt(random.length)];
								int playerdouble = cards.get(playerDouble);
								cards.remove(playerDouble);
								System.out.println("card: " + playerDouble);
								playerhand += playerdouble;
								// System.out.println(cards.keySet());
								//oyucunun double durumunda ace i  
								if (playerhand > 21) {
									if (((playercard1 == 11 || playercard2 == 11 || playerdouble == 11))) {
										playerhand -= 10;
									}

								}

								System.out.println("player hand: " + playerhand);
								System.out.println("dealer hand: " + dealercard1);

								bt[k].doubleBet(); // makes the bet double

								break;
							}
							//double durumunda konulan bet eldekinden fazlaysa almama durumu
							else if (answer.equalsIgnoreCase("double")&&bt[k].bets*2>bt[k].entrybalance) {
								System.out.println("Not enough money");
							}
							count++;

						}

						player[k].playercardArray(groupnumber, playerhand); // Keeps the value of player's hand

					}
					System.out.println("-------------------------------------");
					System.out.println("Dealer's closed card: " + dealerCard2);
					System.out.println("Dealer's hand: " + dealerhand);
					// Dealer should take card if dealer's hand less than 17.
					while (dealerhand < 17) {

						System.out.println("Dealer takes card");
						random = cards.keySet().toArray();
						Object dealercardLast = random[new Random().nextInt(random.length)];
						int dealercardlast = cards.get(dealercardLast);
						cards.remove(dealercardLast);
						// adjust the value of ace according to Blackjack rules

						System.out.println("dealer's card:");
						System.out.println(dealercardLast);
						dealerhand += dealercardlast;
						if ((dealercard1 == 11 || dealercard2 == 11 || dealercardlast == 11)) {

							if (dealerhand > 21) {

								dealerhand -= 10;
							}

						}
					}
					String gameover;
					// Prints the winner according to conditions
					for (int gn = 0; gn < groupnumber; gn++) {
						System.out.println("----------------------------------");
						System.out.print("player hand: ");
						player[gn].ToString(); // prints the value of players' hand
						System.out.println("dealer hand: " + dealerhand);

						if (player[gn].playerscards[0] == 21 && dealerhand != 21) {

							System.out.println("Player's Blackjack");
							gameover = "Player's Blackjack";
							bt[gn].newBalance(gameover); // Prints the calculated new balance for each player

						} else if (player[gn].playerscards[0] != 21 && dealerhand == 21) {

							System.out.println("Dealer's Blackjack");
							gameover = "Dealer's Blackjack";
							bt[gn].newBalance(gameover);

						} else if (dealerhand == 21 && player[gn].playerscards[0] == 21) {

							System.out.println("Push");
							gameover = "Push";
							bt[gn].newBalance(gameover);

						}

						else if (player[gn].playerscards[0] < dealerhand && dealerhand < 21) {

							System.out.println("game over dealer win");
							gameover = "game over dealer win";
							bt[gn].newBalance(gameover);
						} else if (player[gn].playerscards[0] > dealerhand && player[gn].playerscards[0] < 21) {

							System.out.println("game over player win");
							gameover = "game over player win";
							bt[gn].newBalance(gameover);
						} else if (player[gn].playerscards[0] == dealerhand && dealerhand < 21
								&& player[gn].playerscards[0] < 21) {

							System.out.println("Push");
							gameover = "Push";
							bt[gn].newBalance(gameover);
						} else if (player[gn].playerscards[0] > 21 && dealerhand > 21) {
							System.out.println("Push");
							gameover = "Push";
							bt[gn].newBalance(gameover);
						} else if (player[gn].playerscards[0] > 21) {

							System.out.println("game over dealer win");
							gameover = "game over dealer win";
							bt[gn].newBalance(gameover);

						} else if (dealerhand > 21) {

							System.out.println("game over player win");

							gameover = "game over player win";
							bt[gn].newBalance(gameover);

						}

						System.out.println("---------------------------");

					}

				}

			} else
				System.out.println("invalid hands number: " + tour + "\nPlease start again");

		} else
			System.out.println("invalid groupnumber: " + groupnumber + "\nPlease start again");

	}
}
