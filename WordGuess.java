
/*****************************************************************
 * I have received no outside help on this Programming Assignment
 * 
 * @author Megan Jane Thompson
 * @version March 13, 2019
 ****************************************************************/

/**
 * This class has the tools to play a game of Hangman (WordGuess)
 */
public class WordGuess {
  
  /**
   * This method takes in the word to guess and the user word
   * and returns a word of proper length set to the values
   * that indicate a letter has not been guessed yet *
   * for example, if the word were "cat", this method returns"***"
   * 
   * @param   theWord refers to the word from the dictionary
   * @return  returns the userWord filled in with the no guess symbol
   */
  public static String makeUserWord(String theWord) {
    String userWord = "";
    int i;
    
    //loop to replace each letter of theWord with "*"
    for (i = 0; i < theWord.length(); ++i) {
      userWord = userWord + "*";
    }
    return userWord;
  }
  
  
  /**
   * This method takes a guess and a word and returns true if the
   * letter guess is within the selected word, returns false if not.
   * 
   * @param   guess refers to the letter that the user guessed
   * @param   theWord refers to the selected ford to inspect
   * @return  returns true if the guessed letter is within the word
   *          returns false if the guessed letter is not within the word
   */
  public static boolean isInWord(char guess, String theWord) {
    int i;
    boolean found;
    found = false;
    
    //loop to determine if the guessed letter is in theWord
    for (i = 0; i < theWord.length(); ++i) {
      if (guess == theWord.charAt(i)) {
        found = true;
      }
    }
    return found;
  }
  
  
  /**
   * This method takes a guess, the user's progress word, and the selected word 
   * and produces a new progress word with the corresponding guess locations.
   * For example, if the guess were "e" and the word was "fetch", and the user's progress 
   * words "*****", the this method would return the new String as "*e***".
   * 
   * @param   guess refers to the letter the user guessed
   * @param   userWord refers to the progress word that shows where the user is
   * @param   theWord refers to the randomly selected dictonary word.
   * @return  returns a String representing the new progress word
   */
  public static String updateUserWord(char guess, String userWord, String theWord) {
    int i;
    char[] userWordChars = userWord.toCharArray();
    String newUserWord;
    
    //loop for changing the userWord to list the guessed letter if it found in theWord
    for (i = 0; i < theWord.length(); ++i) {
      if (guess == theWord.charAt(i)) {
        userWordChars[i] = guess;
      }
    }
    newUserWord = String.valueOf(userWordChars);   //changes array to String
    return newUserWord;
  }

  
  /**
   * This method updates the list of guesses with the current guess.
   * 
   * @param   guesses refers to the user's previous guesses
   * @param   guess refers to the user's current guess
   * @return  returns the updated list of user guesses
   */
  public static String updateGuesses(String guesses, char guess) {
    char[] newGuesses = new char[guesses.length()+1];
    int i;
    String newGuessList;
    newGuessList = "";
    
    //loop for converting guesses into newGuesses[]
    for (i = 0; i < guesses.length(); ++i) {
      newGuesses[i] = guesses.charAt(i);
    }
    
    //loop for determining if the guessed letter has already been guessed
    for (i = 0; i < guesses.length(); ++i) {
      if (guess == newGuesses[i]) {
      }
    }
    
    //loop for adding the guessed letter if it has not already been guessed
    for (i = 0; i < newGuesses.length; ++i) {
      if (guess != newGuesses[i]) {
        newGuesses[newGuesses.length-1] = guess;
      }
    }
    newGuessList = String.valueOf(newGuesses);   //changes array to String
    return newGuessList;
  }
  
  
  /**
   * This method returns a String that includes the correct user guesses
   * along with "_" for the remianing letters to be guesses.
   * 
   * @param   userWord refers to the user's word so far
   * @return  returns the updated user's word
   */
  public static String displayUserWord(String userWord) {
    char[] userWordChars = new char[userWord.length()];
    int i;
    String newUserWord;
    newUserWord = " ";
    
    //loop for converting userWord into userWordChars[]
    for (i = 0; i < userWord.length(); ++i) {
      userWordChars[i] = userWord.charAt(i);
    }
    
    //loop for switching '*' in userWord to '_'
    for (i = 0; i < userWordChars.length; ++i) {
      if(userWordChars[i] == '*') {
        userWordChars[i] = '_';
      }
    }
    
    newUserWord = String.valueOf(userWordChars);   //converts array to String
    newUserWord = newUserWord.replace("", " ").trim();   //adds spaces between chars of String
    return newUserWord;
  }
  
    /**
   * This method returns the number of strike and lists the guesses
   * 
   * @param   guesses refers to 
   * @param   strikes refers to 
   * @return  returns 
   */
  public static String displayGuesses(int strikes, String guesses) {
    char[] guessesChars = new char[guesses.length()];
    String listGuesses;
    String display;
    int i;
    
    for (i = 0; i < guesses.length(); ++i) {
      guessesChars[i] = guesses.charAt(i);
    }
    
    listGuesses = String.valueOf(guessesChars);
    listGuesses = listGuesses.replace("", " ").trim();
    
    display = "Strikes: " + strikes + '\t'+ "Guesses: " + listGuesses;
    return display;
  } 
}