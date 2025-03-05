
// NAME : LOCHAN PAUDEL
// PRN  : 23070126170
// BATCH: 2023-27
// BRANCH : AIML (A3)
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\n--- Deck of Cards Menu ---");
      System.out.println("1. Create a new deck");
      System.out.println("2. Print the entire deck");
      System.out.println("3. Print a random card");
      System.out.println("4. Find cards with the same suit");
      System.out.println("5. Find cards with the same rank");
      System.out.println("6. Search for a specific card");
      System.out.println("7. Deal 5 random cards");
      System.out.println("8. Shuffle the deck");
      System.out.println("9. Exit");
      System.out.print("Enter your choice (1-9): ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          deck.createDeck();
          System.out.println("New deck created with 52 cards.");
          break;

        case 2:
          System.out.println("\nPrinting the entire deck:");
          deck.printDeck();
          break;

        case 3:
          System.out.println("\nRandom card from the deck:");
          deck.printCard();
          break;

        case 4:
          System.out.print("Enter suit (Hearts, Diamonds, Clubs, Spades): ");
          String suit = scanner.nextLine();
          ArrayList<Card> sameSuitCards = deck.sameCard(suit);
          if (sameSuitCards.isEmpty()) {
            System.out.println("No cards found with suit: " + suit);
          } else {
            System.out.println("\nCards with suit " + suit + ":");
            for (Card card : sameSuitCards) {
              System.out.println(card);
            }
          }
          break;

        case 5:
          System.out.print("Enter rank (Ace, 2-10, Jack, Queen, King): ");
          String rank = scanner.nextLine();
          ArrayList<Card> sameRankCards = deck.compareCard(rank);
          if (sameRankCards.isEmpty()) {
            System.out.println("No cards found with rank: " + rank);
          } else {
            System.out.println("\nCards with rank " + rank + ":");
            for (Card card : sameRankCards) {
              System.out.println(card);
            }
          }
          break;

        case 6:
          System.out.print("Enter suit (Hearts, Diamonds, Clubs, Spades): ");
          String searchSuit = scanner.nextLine();
          System.out.print("Enter rank (Ace, 2-10, Jack, Queen, King): ");
          String searchRank = scanner.nextLine();
          if (deck.findCard(searchSuit, searchRank)) {
            System.out.println("Card found: " + searchRank + " of " + searchSuit);
          } else {
            System.out.println("Card not found!");
          }
          break;

        case 7:
          System.out.println("\nDealing 5 random cards:");
          ArrayList<Card> dealtCards = deck.dealCard();
          for (Card card : dealtCards) {
            System.out.println(card);
          }
          System.out.println("Remaining cards in deck: " + deck.getDeck().size());
          break;

        case 8:
          deck.shuffleDeck();
          System.out.println("Deck has been shuffled.");
          break;

        case 9:
          System.out.println("Exiting program. Goodbye!");
          break;

        default:
          System.out.println("Invalid choice! Please enter a number between 1 and 9.");
      }
    } while (choice != 9);

    scanner.close();
  }
}