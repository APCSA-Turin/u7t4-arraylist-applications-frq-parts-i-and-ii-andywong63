package com.example.project.WordScramble;
import java.util.ArrayList;
public class WordScramble {
  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
      for (int i = 0; i < word.length() - 1; i++) {
        String character = word.substring(i, i + 1);
        String nextChar = word.substring(i + 1, i + 2);
        if (character.equals("A") && !nextChar.equals("A")) {
          // Swap characters
          String tempWord = "";
          // Add all characters before
          tempWord += word.substring(0, i);
          // Add character after "A"
          tempWord += nextChar;
          // Add A
          tempWord += "A";
          // All all characters after
          tempWord += word.substring(i + 2);
          // Apply to word variable
          word = tempWord;

          // Skip next index so it doesn't get swapped again
          i++;
        }
      }
      return word;
  }

  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
    for (int i = 0; i < wordList.size(); i++) {
      String scrambed = scrambleWord(wordList.get(i));
      if (wordList.get(i).equals(scrambed)) {
        wordList.remove(i);
        i--;
      } else {
        wordList.set(i, scrambed);
      }
    }
    return wordList;
  }
}
