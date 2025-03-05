public class Card {
  private String suit;
  private String rank;

  Card(String suit, String rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public void setSuit(String suit) {
    this.suit = suit;
  }

  public String getSuit() {
    return suit;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getRank() {
    return rank;
  }

  public String toString() {
    return rank + " of " + suit;
  }
}