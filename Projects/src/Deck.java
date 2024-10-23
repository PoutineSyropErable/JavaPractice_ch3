import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// Deck class holding cards and using ArrayList
public class Deck implements Iterable<Card> {
    private final ArrayList<Card> aCards;

    public Deck() {
        aCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        aCards.add(card);
    }

    public void sortBySuitFirst() {
        Collections.sort(aCards, CompareBySuitFirst.getInstance());
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

    @Override
    public Iterator<Card> iterator() {
        return aCards.iterator();
    }
}