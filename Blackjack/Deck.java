//********************************************************************
//  Deck.java       Author: Thu Phuong Hoang & Nadine Mendis
//  This class represents a deck of cards.
//********************************************************************
import java.util.*;

public class Deck {
    private List<Card> cards; // Private variable to store the cards in the deck
    private int nextCard; // Private variable to keep track of the next card to be dealt

    public Deck() {
        cards = new ArrayList<>(); // Initialize the cards list as an empty ArrayList
        String[] suits = {"S:", "H:", "D:", "C:"}; // Array containing the suit values
        String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // Array containing the face values

        // Generate all possible card combinations by iterating over suits and faces
        for (String suit : suits) {
            for (String face : faces) {
                cards.add(new Card(suit, face)); // Create a new Card object with the current suit and face, and add it to the cards list
            }
        }

        nextCard = 0; // Set the nextCard variable to 0 initially
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = (int) (Math.random() * (cards.size() - i)); // Generate a random index from i to cards.size() - 1
            Card tmp = cards.get(i); // Get the card at index i
            cards.set(i, cards.get(i + j)); // Replace the card at index i with the card at index i + j
            cards.set(i + j, tmp); // Put the original card at index i into the index i + j
        }
    }

    public void showAllCards() {
        System.out.println("A deck of 52 cards in random order:");
        System.out.println();
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i) + " "); // Print each card in the deck
            if ((i + 1) % 13 == 0) {
                System.out.println(); // Print a newline after every 13 cards
            }
        }
    }

    public Card dealCard() {
        if (nextCard < cards.size()) {
            return cards.get(nextCard++); // Return the next card in the deck and increment nextCard
        } else {
            return null; // Return null if all cards have been dealt
        }
    }
}
