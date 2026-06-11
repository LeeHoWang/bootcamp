import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Deck {
    private Card[] cards;
    private Random rand;  // ✅ 改進1：Random 做 class member

    public Deck() {
        this.rand = new Random();  // ✅ 初始化一次
        
        int idx = 0;
        this.cards = new Card[Rank.values().length * Suite.values().length];
        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suite);
                cards[idx] = card;
                idx++;
            }
        }
    }

    public Card[] getCards() {
        return this.cards;
    }

    // ✅ 改進2：刪除 getnewCards()，或者留低但叫返 getCards()
    public Card[] getnewCards() {
        return this.cards;
    }

    // cut x times（保留原本嘅切牌式洗牌）
    public void shuffle(int times) {
        for (int i = 0; i < times; i++) {  
            this.shuffle();                
        }
    }

    // 原本嘅切牌式洗牌（保留）
    public void shuffle() {
        int upIdx = this.rand.nextInt(21) + 30;
        int downIdx = this.rand.nextInt(30);

        Card[] newCards = new Card[this.cards.length];
        int idx = 0;
        
        for (int i = 0; i < downIdx; i++) {
            newCards[idx] = this.cards[i];
            idx++;
        }

        for (int i = upIdx; i < this.cards.length; i++) {
            newCards[idx] = this.cards[i];
            idx++;
        }

        for (int i = downIdx; i < upIdx; i++) {
            newCards[idx] = this.cards[i];
            idx++;
        }
        this.cards = newCards;
    }

    // ✅ 新增：Fisher-Yates 真正隨機洗牌（一 take 過）
    public void fisherYatesShuffle() {
        for (int i = this.cards.length - 1; i > 0; i--) {
            int j = this.rand.nextInt(i + 1);  // 0 到 i
            Card temp = this.cards[i];
            this.cards[i] = this.cards[j];
            this.cards[j] = temp;
        }
    }

    public static void main(String[] args) {
        Deck d1 = new Deck();
        System.out.println("原始牌序：");
        System.out.println(Arrays.toString(d1.getCards()));

        // 測試 Fisher-Yates
        d1.fisherYatesShuffle();
        System.out.println("\nFisher-Yates 洗一次：");
        System.out.println(Arrays.toString(d1.getCards()));

        // 測試原本嘅切牌式洗牌
        Deck d2 = new Deck();
        d2.shuffle(100);
        System.out.println("\n原本切牌式洗100次：");
        System.out.println(Arrays.toString(d2.getCards()));
    }
}