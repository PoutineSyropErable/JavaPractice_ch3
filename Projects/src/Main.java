// Main class for testing the Deck and Card functionality
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.addCard(new Card("Hearts", "10"));
        deck.addCard(new Card("Diamonds", "2"));
        deck.addCard(new Card("Hearts", "A"));
        deck.addCard(new Card("Clubs", "5"));
        deck.addCard(new Card("Diamonds", "K"));
        deck.addCard(new Card("Clubs", "3"));

        // Sort the deck by suit and rank
        deck.sortBySuitFirst();

        // Iterate through the deck and print the cards
        for (Card card : deck) {
            System.out.println(card.getSuit() + " " + card.getRank());
        }
    }
}
