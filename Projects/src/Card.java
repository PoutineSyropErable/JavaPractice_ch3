import java.util.Comparator;

public class Card {
    private String suit;
    private String rank;

    // Constructor
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    // Nested Comparator class for comparing by suit first, Singleton design pattern
    public static class CompareBySuitFirst implements Comparator<Card> {
        // Single instance of the comparator
        private static final CompareBySuitFirst INSTANCE = new CompareBySuitFirst();

        // Private constructor to prevent external instantiation
        private CompareBySuitFirst() {}

        // Public method to access the singleton instance
        public static CompareBySuitFirst getInstance() {
            return INSTANCE;
        }

        // Comparison method to compare by suit first, then by rank
        @Override
        public int compare(Card pCard1, Card pCard2) {
            int suitComparison = pCard1.getSuit().compareTo(pCard2.getSuit());
            if (suitComparison != 0) {
                return suitComparison;  // Compare by suit first
            }
            return pCard1.getRank().compareTo(pCard2.getRank());  // Then compare by rank
        }
    }
}

