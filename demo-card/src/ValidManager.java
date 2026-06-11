import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

// ! Assume no ordering
public class ValidManager {
    // Given
    private Card[] cards;

    public ValidManager(Card c1, Card c2, Card c3, Card c4, Card c5) {
        this.cards = new Card[5];
        this.cards[0] = c1;
        this.cards[1] = c2;
        this.cards[2] = c3;
        this.cards[3] = c4;
        this.cards[4] = c5;
    }

    public boolean isFullHouse() {
        int[] rankCount = new int[13];
        for (Card card : this.cards) {
            int rankPosition = card.getRank().ordinal();
            rankCount[rankPosition]++;
        }

        boolean hasThree = false;
        boolean hasPair = false;

        for (int count : rankCount) {
            if (count == 3) {
                hasThree = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }

        return hasThree && hasPair;
    }

    public boolean isFlush() {
      return this.cards[0].getSuite() == this.cards[1].getSuite()
          && this.cards[1].getSuite() == this.cards[2].getSuite()
          && this.cards[2].getSuite() == this.cards[3].getSuite()
          && this.cards[3].getSuite() == this.cards[4].getSuite();
    }

    public void printHand() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }    

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("=== SHUFFLING DECK ===");
        deck.shuffle(100);  // Shuffle 100 times
        System.out.println("Deck shuffled!\n");

        Card[] drawnCards = deck.getCards();
        Card hand1 = drawnCards[0];
        Card hand2 = drawnCards[1];
        Card hand3 = drawnCards[2];
        Card hand4 = drawnCards[3];
        Card hand5 = drawnCards[4];
        
        System.out.println("=== YOUR POKER HAND (After Shuffle) ===");
        ValidManager hand = new ValidManager(hand1, hand2, hand3, hand4, hand5);
        hand.printHand();
        
        System.out.println("\n=== RESULT ===");
        if (hand.isFullHouse()) {
            System.out.println("🎉 CONGRATULATIONS! You have a FULL HOUSE! 🎉");
        } else {
            System.out.println("❌ Not a Full House. Keep playing!");
        }

    // ValidManager[] testHands = {
    //     // Full House: Three Aces + Two Kings
    //     new ValidManager(
    //         new Card(Rank.ACE, Suite.SPADE),
    //         new Card(Rank.ACE, Suite.HEART),
    //         new Card(Rank.ACE, Suite.DIAMOND),
    //         new Card(Rank.KING, Suite.CLUB),
    //         new Card(Rank.KING, Suite.HEART)
    //     ),
        
    //     // Full House: Three Queens + Two Sevens
    //     new ValidManager(
    //         new Card(Rank.QUEEN, Suite.SPADE),
    //         new Card(Rank.QUEEN, Suite.HEART),
    //         new Card(Rank.QUEEN, Suite.DIAMOND),
    //         new Card(Rank.SEVEN, Suite.CLUB),
    //         new Card(Rank.SEVEN, Suite.HEART)
    //     ),
        
    //     // Full House: Three Twos + Two Tens
    //     new ValidManager(
    //         new Card(Rank.TWO, Suite.SPADE),
    //         new Card(Rank.TWO, Suite.HEART),
    //         new Card(Rank.TWO, Suite.DIAMOND),
    //         new Card(Rank.TEN, Suite.CLUB),
    //         new Card(Rank.TEN, Suite.HEART)
    //     ),
        
    //     // NOT a Full House (just for comparison)
    //     new ValidManager(
    //         new Card(Rank.ACE, Suite.SPADE),
    //         new Card(Rank.KING, Suite.HEART),
    //         new Card(Rank.QUEEN, Suite.DIAMOND),
    //         new Card(Rank.JACK, Suite.CLUB),
    //         new Card(Rank.TEN, Suite.HEART)
    //     )
    // };
    
    // for (int i = 0; i < testHands.length; i++) {
    //     System.out.println("\n=== Hand " + (i+1) + " ===");
    //     testHands[i].printHand();
    //     if (testHands[i].isFullHouse()) {
    //         System.out.println("✓ FULL HOUSE! 🎉");
    //     } else {
    //         System.out.println("✗ Not a Full House");
    //     }
    // }
    }
}