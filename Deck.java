import java.util.*;

public class Deck {
  private ArrayList<Card> cards = new ArrayList<>();
  private String[] values = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
  private String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

  // Constructor also serves as createDeck()
  public Deck() {
    createDeck();
  }

  // a) createDeck() - Initializes a deck of 52 cards
  public void createDeck() {
    cards.clear();
    for (String s : suits) {
      for (String v : values) {
        cards.add(new Card(s, v));
      }
    }
  }

  // b) printDeck() - Prints the entire deck
  public void printDeck() {
    for (Card card : cards) {
      System.out.println(card);
    }
  }

  // c) printCard() - Prints a random card from the deck
  public void printCard() {
    Random rand = new Random();
    int index = rand.nextInt(cards.size());
    System.out.println(cards.get(index));
  }

  // d) sameCard() - Finds cards with the same suit
  public ArrayList<Card> sameCard(String suit) {
    ArrayList<Card> sameSuitCards = new ArrayList<>();
    for (Card card : cards) {
      if (card.getSuit().equalsIgnoreCase(suit)) {
        sameSuitCards.add(card);
      }
    }
    return sameSuitCards;
  }

  // e) compareCard() - Finds cards with the same rank
  public ArrayList<Card> compareCard(String rank) {
    ArrayList<Card> sameRankCards = new ArrayList<>();
    for (Card card : cards) {
      if (card.getRank().equalsIgnoreCase(rank)) {
        sameRankCards.add(card);
      }
    }
    return sameRankCards;
  }

  // f) findCard() - Searches for a specific card by suit and rank
  public boolean findCard(String suit, String rank) {
    for (Card card : cards) {
      if (card.getSuit().equalsIgnoreCase(suit) && card.getRank().equalsIgnoreCase(rank)) {
        return true;
      }
    }
    return false;
  }

  // g) dealCard() - Deals 5 random cards and removes them from the deck
  public ArrayList<Card> dealCard() {
    ArrayList<Card> dealtCards = new ArrayList<>();
    Random rand = new Random();
    int numCards = Math.min(5, cards.size()); // Ensure we don’t deal more cards than available
    for (int i = 0; i < numCards; i++) {
      int randomIndex = rand.nextInt(cards.size());
      dealtCards.add(cards.remove(randomIndex));
    }
    return dealtCards;
  }

  // h) shuffleDeck() - Randomizes the deck
  public void shuffleDeck() {
    Collections.shuffle(cards);
  }

  // Getter for testing purposes (optional, not required by specs)
  public ArrayList<Card> getDeck() {
    return cards;
  }
}