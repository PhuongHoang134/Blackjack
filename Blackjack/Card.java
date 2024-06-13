//********************************************************************
//  Card.java       Author: Thu Phuong Hoang & Nadine Mendis
//  This class represents a single card entity.
//********************************************************************
import java.util.*;

public class Card {
    private String suit; // Private variable to store the suit of the card
    private String face; // Private variable to store the face value of the card

    //Constructor to initialize instance variables
    public Card(String suit, String face) {
        this.suit = suit;
        this.face = face;
    }

    public String getSuit() {
        return suit; // Return the suit of the card
    }

    public String getFace() {
        return face; // Return the face value of the card
    }

    public int getValue() {
        if (face.equals("A")) { // If the face value is "A" (Ace)
            return 11; // Return 11 as the value of the Ace
        }
        else if (face.equals("K") || face.equals("Q") || face.equals("J")) { // If the face value is "K", "Q", or "J" (King, Queen, Jack)
            return 10; // Return 10 as the value of the King, Queen, or Jack
        }
        else {
            return Integer.parseInt(face); // Convert the face value to an integer and return it as the card value
        }
    }

    public String toString() {
        return suit + face; // Return a string representation of the card by concatenating the suit and face value
    }
}
