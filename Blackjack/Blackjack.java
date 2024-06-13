//********************************************************************
//  Blackjack.java       Author: Thu Phuong Hoang & Nadine Mendis
//  This is the driver class of the program
//********************************************************************
import java.util.*;

public class Blackjack {
  public static void main(String[] args) {
    Deck deck = new Deck(); // Creates a new deck of cards

    Scanner sc = new Scanner(System.in);

    //Instructions
    System.out.println("====================================BLACKJACK====================================\n" +
                       "- Compare your total hand value with the dealers hand.\n" +
                       "- The player or the dealer with 21 wins immediately.\n"+
                       "- The player or the dealer with more than 21 loses immediately.\n"+
                       "- If both have lower than 21, compare the totals and the one with high value wins\n" +
                       "=================================================================================");

    // Player name
    System.out.println();
    System.out.print("Enter players name: ");
    String playerName = sc.nextLine();
    System.out.println("Welcome " + playerName + "!");
    System.out.println();

    deck.shuffle(); // Shuffle the deck of cards by calling the shuffle method in Deck
    deck.showAllCards(); // Display all the cards in the deck by calling the showAllCards method in Deck
    System.out.println();

    String answer;
    do {
        // Place a bet
        System.out.print("Please place your bets: $");
        double betAmount = sc.nextDouble();
        double winnings = betAmount * 2; // Calculate the winnings


        Hand playerHand = new Hand(); // Create a new hand for the player
        Hand dealerHand = new Hand(); // Create a new hand for the dealer

        // Initial deal
        playerHand.addCard(deck.dealCard()); // Deal a card to the player
        dealerHand.addCard(deck.dealCard()); // Deal a card to the dealer
        playerHand.addCard(deck.dealCard()); // Deal a card to the player
        dealerHand.addCard(deck.dealCard()); // Deal a card to the dealer

        System.out.println(playerName + "'s Hand: " + playerHand); // Display the player's hand
        System.out.println("Dealer's Hand: " + dealerHand.getCard(0) + " xx\n"); // Display the dealer's hand (showing only one card)
        System.out.println(playerName + "'s Score: " + playerHand.getBlackjackValue()); // Display the player's score
        System.out.println("Dealer's Score (with card facing up): " + dealerHand.getCard(0).getValue()); // Display the dealer's score (value of the first card)
        //Checks if the player has a total score of 21
        if (playerHand.getBlackjackValue() == 21) {
          System.out.println();
          System.out.println(playerName + " has 21!");
          System.out.println("Congratulations, " + playerName + "! You win $" + winnings);
        }
        else {
          // Player's turn
          while (true) {
            System.out.print("Hit or Stand? (H/S): ");
            String input = sc.next();

            if (input.equalsIgnoreCase("H")) { // If the player chooses to Hit
              playerHand.addCard(deck.dealCard()); // Deal a card to the player
              System.out.println(playerName + "'s Hand: " + playerHand); // Display the player's hand
              System.out.println(playerName + "'s Score: " + playerHand.getBlackjackValue()); // Display the player's score
              System.out.println();

              if (playerHand.getBlackjackValue() > 21) { // If the player's score exceeds 21
                System.out.println(playerName + " busts! Dealer wins. You lose $" + betAmount); // Dealer wins immediately.
                break;
              }
              else if (playerHand.getBlackjackValue() == 21) { // If the player's score is 21
                System.out.println(playerName + " has 21!");
                System.out.println("Congratulations, " + playerName + "! You win $" + winnings); // Player wins immediately if the player's score equals 21.
                break;
              }
            }
            else if (input.equalsIgnoreCase("S")) { // If the player chooses to Stand
              // Reveal the dealer's hidden card
              System.out.println("Dealer's Hand: " + dealerHand); // Display the dealer's hand
              System.out.println("Dealer's Score: " + dealerHand.getBlackjackValue()); // Display the dealer's score
              System.out.println();

              if (dealerHand.getBlackjackValue() == 21) {
                System.out.println("Dealer has 21! Dealer wins. You lose $" + betAmount);
                break;
              }
              else {
                // Dealer's turn
                while (dealerHand.getBlackjackValue() <= 16) { // Dealer hits as long as the score is 16 or less
                  dealerHand.addCard(deck.dealCard()); // Draw a card to the dealer
                }

                System.out.println("Dealer's Hand: " + dealerHand); // Display the dealer's final hand
                System.out.println("Dealer's Score: " + dealerHand.getBlackjackValue()); // Display the dealer's final score
                System.out.println();

                if (dealerHand.getBlackjackValue() > 21) { // If the dealer's score exceeds 21
                  System.out.println("Congratulations, " + playerName + "! You win $" + winnings); // Player wins immediately.
                  break;
                }
                else if (dealerHand.getBlackjackValue() == 21) { // If the dealer's score is 21
                  System.out.println("Dealer has 21! Dealer wins. You lose $" + betAmount); // Dealer wins immediately if the dealer's score equals 21.
                  break;
                }
                else {
                  // Compare hands
                  int playerValue = playerHand.getBlackjackValue(); // Get the player's score
                  int dealerValue = dealerHand.getBlackjackValue(); // Get the dealer's score

                  System.out.println(playerName + "'s Score: " + playerValue); // Display the player's final score
                  System.out.println("Dealer's Score: " + dealerValue); // Display the dealer's final score
                  System.out.println();

                  if (playerValue > dealerValue && playerValue < 21) { // If the player's score is higher than the dealer's score and not over 21
                    System.out.println("Congratulations, " + playerName + "! You win $" + winnings);
                    break;
                  }
                  else if (playerValue < dealerValue && dealerValue < 21) { // If the dealer's score is higher than the player's score and not over 21
                    System.out.println("Dealer wins! You lose $" + betAmount);
                    break;
                  }
                  else if (playerValue == dealerValue && dealerValue < 21) { // If the dealer's score equals the player's score and not over 21
                    System.out.println("It's a tie!");
                    break;
                  }
                }
              }
            }
            else {
              // If the player enters the wrong command.
              System.out.println("Incorrect choice. Type H for hit or S for stand.");
            }
          }
        }
        System.out.println("Would you like to continue playing (Y/N)?"); // Asks if the player want to continue playing
        System.out.print("Enter your choice: ");
        answer = sc.next();
        System.out.println();
      }
    while (answer.equalsIgnoreCase("Y"));
    System.out.println("Good bye!");
  }
}
