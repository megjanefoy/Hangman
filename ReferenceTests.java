import junit.framework.*;
/**
 * This class was provided by the instructor.
 */
public class ReferenceTests extends TestCase {  
  
  public void testMakeUserWord()  {
    assertEquals("Error in makeUserWord ", "****", WordGuess.makeUserWord("abcd"));
    assertEquals("Error in makeUserWord ", "*", WordGuess.makeUserWord("x"));
    assertEquals("Error in makeUserWord (try an empty string) ", "", WordGuess.makeUserWord(""));
  }
  
  public void testIsInWord()  { 
    assertEquals("Error in isInWord ", true, WordGuess.isInWord('a', "bad"));
    assertEquals("Error in isInWord ", true, WordGuess.isInWord('b', "bad"));
    assertEquals("Error in isInWord ", true, WordGuess.isInWord('d', "bad"));
    assertEquals("Error in isInWord ", false, WordGuess.isInWord('x', "bad"));
    assertEquals("Error in isInWord ", false, WordGuess.isInWord('3', "bad"));
  }
  
  public void testUpdateUserWord()  {
    assertEquals("Error in updateUserWord ", "fe***", WordGuess.updateUserWord('e', "f****", "fetch"));
    assertEquals("Error in updateUserWord ", "*e***", WordGuess.updateUserWord('e', "*****", "fetch"));
    assertEquals("Error in updateUserWord ", "s****", WordGuess.updateUserWord('s', "*****", "sugar"));
    assertEquals("Error in updateUserWord ", "****r", WordGuess.updateUserWord('r', "*****", "sugar"));
    assertEquals("Error in updateUserWord ", "*****", WordGuess.updateUserWord('s', "*****", "fetch"));
    assertEquals("Error in updateUserWord ", "fetch", WordGuess.updateUserWord('t', "fe*ch", "fetch"));
  }
  
  public void testUpdateGuesses()  {
    assertEquals("Error in updateGuesses ", "bdetf", WordGuess.updateGuesses("bdet", 'f'));
    assertEquals("Error in updateGuesses ", "f", WordGuess.updateGuesses("", 'f'));
    assertEquals("Error in updateGuesses ", "bdetz", WordGuess.updateGuesses("bdet", 'z'));
    assertEquals("Error in updateGuesses ", "bdeta", WordGuess.updateGuesses("bdet", 'a'));
    assertEquals("Error in updateGuesses ", "fa", WordGuess.updateGuesses("f", 'a'));
  }
  
  public void testDisplayUserWord()  {  
    assertEquals("Error in displayUserWord ", "f _ _ _ _", WordGuess.displayUserWord("f****"));
    assertEquals("Error in displayUserWord ", "f _ _ _ h", WordGuess.displayUserWord("f***h"));
    assertEquals("Error in displayUserWord ", "_ _ t c h", WordGuess.displayUserWord("**tch"));
  }
  
  public void testDisplayUserGuesses()  {  
    assertEquals("Error in displayUserGuesses ", "Strikes: 3\tGuesses: b c d", WordGuess.displayGuesses(3, "bcd"));
    assertEquals("Error in displayUserGuesses ", "Strikes: 0\tGuesses: ", WordGuess.displayGuesses(0, ""));
    
  }
  
} // END class WordGuess
