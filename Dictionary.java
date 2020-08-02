import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class was provided by the instructor.
 * This class provides a dictionary of words.
 *
 * @author Nancy Harris
 * @version 10/30/2015
 */
public class Dictionary {

   private ArrayList<String> words;

   private Random randi;

   /**
    * Constructs a new dictionary from a plain text file.
    *
    * @param seed starter value for the random generator
    */
   public Dictionary(long seed) {
      Scanner wordScan;

      // this code opens the Words.txt file to obtain the words
      try {
         wordScan = new Scanner(new File("Words.txt"));
      } catch (FileNotFoundException fnfe) {
         System.out.println("Words.txt is missing.");
         System.exit(99);
         wordScan = null; // make the compiler happy
      }

      // repeat until end of file
      this.words = new ArrayList<String>();
      while (wordScan.hasNext()) {
         String word;
         word = wordScan.next();
         this.words.add(word);
      }

      // to control the game order
      this.randi = new Random(seed);
   }

   /**
    * Serves up words for the game.
    *
    * @return a random word from the Dictionary
    */
   public String getWord() {
      return this.words.get(this.randi.nextInt(this.words.size()));
   }

}
