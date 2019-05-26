
package workshop1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays; 

public class HangManGame {
	 public static void main(String[] args) {
		  
			//set the word for game
		    String[] words = { "this", "that", "we", "you", "game", "Java"};
		    boolean restart = true;

		    while (restart) {
		      
		      // randomly choose the word
		      int randomIndex= (int)((Math.random() * words.length)+1);
		      String word = words[randomIndex];
		      //toCharArray() - This method converts this string to a new character array.
		      char[] chosingWordLetters = word.toCharArray();

		      System.out.println("***** This is " + word.length() + " letter(s) word. *****");

		      // print the * with same count of world
		      char[] wordChar = word.toCharArray();
		      for (int i = 0; i < word.length(); i++) {
		        wordChar[i] = '*';
		      }

		      boolean isFinished = false;
		      
		      ArrayList<Character> lettersTried = new ArrayList<Character>();
		      int misses = 0;

		      while (!isFinished) {
		    	  System.out.print("Enter a letter :");
		    	  Scanner input = new Scanner(System.in);
		          //To read a char, we use next().charAt(0). next() function returns the next token/word 
		          //in the input as a string and charAt(0) function returns the first character in that string.
		          char letter = input.next().charAt(0);

		         //isLetter() - The method determines whether the specified char value is a letter
		         // check the letter
		         while (!Character.isLetter(letter)) {
		          System.out.print("*This is *WRONG TYPE*. Enter a LETTER : ");
		          Scanner scan = new Scanner(System.in);
		          letter = scan.next().charAt(0);
		        }
		        
		        // indexOf()- This method returns the index within this string of the first occurrence 
		        // of the specified character or -1, if the character does not occur.
		        if (lettersTried.size() > 0 && lettersTried.indexOf(letter) != -1) {
		          System.out.println("You've already tried this letter, try another one");
		        } else {
		          lettersTried.add(letter);
		        }

		        boolean hasFoundMatch = false;

		        for (int i = 0; i < word.length(); i++) {
		          if (chosingWordLetters[i] == letter) {
		            wordChar[i] = letter;
		            hasFoundMatch = true;
		          }
		        }

		        if (!hasFoundMatch) {
		          misses++;
		        }

		        System.out.println(wordChar);

		        if (new String(wordChar).indexOf('*') == -1) {
		          System.out.println("Misses: " + misses);
		          isFinished = true;
		        }
		      }

		      System.out.print("Would you like to play again? Y/N: ");
		      Scanner play = new Scanner(System.in);
		      char letter = play.next().charAt(0);

		      if (letter == 'N' || letter == 'n') {
		        System.out.println("Thanks for playing! Bye!");
		        play.close();
		        restart = false;
		      }
		    }
		  }
}


