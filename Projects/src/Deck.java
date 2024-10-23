
import java.util.Iterator;


public class Deck implements Iterable<Card> {
    // CustomArrayList to hold cards
    private CustomArrayList<Card> aCards;

    // Constructor to initialize the deck
    public Deck() {
        aCards = new CustomArrayList<>();

        // Example cards added to the deck
        aCards.add(new Card("Hearts", "Ace"));
        aCards.add(new Card("Spades", "King"));
        aCards.add(new Card("Diamonds", "Queen"));
        aCards.add(new Card("Clubs", "Jack"));
        aCards.add(new Card("Hearts", "2"));
    }

    public void sortBySuitFirst() {
		

		// Collections.sort(aCards, Card.CompareBySuitFirst.getInstance());

		// ^^ If I used a regular array list.
		// ArrayList implements List (interface)
		// List extends Collections (Inheritence)
		// Collections extends Itterable. 
		// Itterable, Collections and List are Interface (Abstract class). ArrayList is a concrete class. 


        aCards.sort(Card.CompareBySuitFirst.getInstance());
    }

    // Implementing the iterator() method
    @Override
    public Iterator<Card> iterator() {
        return aCards.iterator();
    }

    // Main method to test the Deck class with CustomArrayList
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        System.out.println("Before Sorting:");
        for (Card card : deck) {
            System.out.println(card);
        }

        deck.sortBySuitFirst();

        System.out.println("\nAfter Sorting by Suit First:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
