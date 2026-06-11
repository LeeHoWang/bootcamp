import java.util.Objects;

public class Card {
  private Rank rank;
  private Suite suite;

  public Card (Rank rank, Suite suite) {
    this.rank = rank;
    this.suite =suite;
  }

  public Rank getRank() {
    return this.rank;
  }

  public Suite getSuite() {
    return this.suite;
  }

  // equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Card))
      return false;
    Card card = (Card) obj;
    return Objects.equals(this.rank, card.getRank())
        && Objects.equals(this.suite, card.getSuite());
  }

  // ! 2. hashCode
  @Override
  public int hashCode() {
    return Objects.hash(this.rank, this.suite);
  }

  // ! 3. toString (Debug:print object data)
  @Override
  public String toString() {
    return "Card(" //
      + "rank=" + this.rank.name() //
      + ", suite=" + this.suite.name() //
      + ")";
  }

  public static void main(String[] args) {
    Card card1 = new Card(Rank.ACE, Suite.HEART);
    Card card2 = new Card(Rank.ACE, Suite.HEART);
    System.out.println(card1.equals(card2)); // true
    System.out.println(card1.hashCode() == card2.hashCode()); // true
    System.out.println(card1); // Card(rank=ACE, suite=HEART)
  }  
}