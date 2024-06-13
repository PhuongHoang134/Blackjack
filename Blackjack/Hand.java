//********************************************************************
//  Hand.java       Author: Thu Phuong Hoang & Nadine Mendis
//  This class represents a hand of cards.
//********************************************************************
import java.util.*;

public class Hand {
  private List<Card> cards; // Private variable to store the cards in the hand

  public Hand() {
    cards = new ArrayList<>(); // Initialize the cards list as an empty ArrayList
  }

  public void addCard(Card card) {
    cards.add(card); // Add the specified card to the hand
  }

  public int getBlackjackValue() {
    int value = 0; // Initialize the value of the hand to 0
    int numAces = 0; // Initialize the count of Aces in the hand to 0

    for (Card card : cards) {
      value += card.getValue(); // Add the value of each card in the hand to the total value

      if (card.getFace().equals("A")) {
        numAces++; // If the card is an Ace, increment the count of Aces
      }
    }

    while (value > 10 && numAces > 1) {
      value -= 10; /// If the hand value is greater than 10 and the next Ace as 1
                   // instead of 11
      numAces--; // Decrement the count of Aces
    }

    return value; // Return the final value of the hand
  }

  public Card getCard(int index) {
    if (index >= 0 && index < cards.size()) {
      return cards.get(index); // Return the card at the specified index in the hand
    } else {
      return null; // Return null if the index is out of bounds
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder(); // Create a StringBuilder object to build the string representation of the
                                            // hand

    for (Card card : cards) {
      sb.append(card).append(" "); // Append each card to the StringBuilder with a space separator
    }

    return sb.toString(); // Return the string representation of the hand
  }
}
