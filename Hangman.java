import java.util.Scanner;

/**
 * This class was provided by the instructor.
 * Demonstrates the game of Hangman using WordGuess.
 *
 * @author Nancy Harris
 * @version 10/30/2015
 */
public class Hangman {

   /**
    * Builds a new game and starts play.
    *
    * @param args optional seed value to use in the game
    */
   public static void main(String[] args) {
      long seed;

      // gets a seed value to use to control words displayed
      if (args.length == 0) {
         seed = 12345678;
      } else {
         seed = Long.parseLong(args[0]);
      }

      playGame(seed);
      System.out.println("Game over.  Play again soon.");
   }

   /**
    * Runs through the game. Ends when the user chooses not to play another
    * game.
    *
    * @param seed for the random number generator
    */
   public static void playGame(long seed) {
      final int NUM_GUESSES = 6;

      Dictionary words; // a collection of words
      Scanner keyboard;
      String userWord; // the word the user is working on
      String userGuesses;
      String playAgain;
      String word; // the current word in play

      int guessCount; // tracks guesses
      char test;
      char userGuess; // letter user has guessed

      // starts the game by making a dictionary.
      words = new Dictionary(seed);
      keyboard = new Scanner(System.in);
      System.out.println("Welcome to CS 139 -- Word Guess!!\n");

      // outer loop: play the game again?
      do {
         word = words.getWord();
         guessCount = 0;
         userGuesses = "";

         // pass word to use in display
         userWord = WordGuess.makeUserWord(word);

         System.out.println("Guess a letter to see if it's in the word.");
         System.out.println("The word you are trying to guess has "
                     + word.length() + " letters.\n");

         System.out.println(WordGuess.displayUserWord(userWord));
         System.out.println(WordGuess.displayGuesses(guessCount, userGuesses));

         // inner loop: play a single game
         do {
            System.out.println();
            System.out.print("What is your guess: ");
            userGuess = keyboard.nextLine().charAt(0);

            // change the letter to lower case
            userGuess = Character.toLowerCase(userGuess);

            if (WordGuess.isInWord(userGuess, word)) {
               System.out.println(
                           "\nYES!! " + userGuess + " is in the word.\n");
               userWord = WordGuess.updateUserWord(userGuess, userWord, word);
               userGuesses = WordGuess.updateGuesses(userGuesses, userGuess);
            } else {
               if (!WordGuess.isInWord(userGuess, userGuesses)) {
                  // increment on bad, not previously guessed
                  guessCount++;
               }
               System.out.println(
                           "\nNope... " + userGuess + " is not in the word.\n");
               userGuesses = WordGuess.updateGuesses(userGuesses, userGuess);
            }

            System.out.println(WordGuess.displayUserWord(userWord));
            System.out.println(
                        WordGuess.displayGuesses(guessCount, userGuesses));

            if (word.compareToIgnoreCase(userWord) == 0) {
               System.out.println("\n\tYou Win!!!! \n");
            } else if (guessCount >= NUM_GUESSES) {
               System.out.print("\nToo many guesses...  You lose!\n");
               System.out.println("The word was " + word + ".\n");
            } else {
               System.out.println("\nKeep trying...");
            }

         } while (word.compareToIgnoreCase(userWord) != 0
                     && guessCount < NUM_GUESSES);

         System.out.println("Do you want to play again (yes/no)? ");
         playAgain = keyboard.nextLine();
         System.out.println();

      } while (!playAgain.equalsIgnoreCase("no"));

   }

}
