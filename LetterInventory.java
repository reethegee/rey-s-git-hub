// Programmer: Rey O'Dell
// Date: 5/25/2023
// Class: CS &145
// Assignment: Letter Inventory
// Purpose: to create a program that keeps track of how many of each letter are in the user input and print them in alphabetical order
// References: wcc tutoring center

import java.util.*;

public class LetterInventory { // start class
   private ArrayList<Character> letters = new ArrayList<Character>();
   private int[] letterCount = new int[26]; 
   private String word; 

// this method constructs a LetterInventory fully sorted and prints it out

   public LetterInventory(String word) { // start LetterInventory
      this.word = word; 
      String cleanedWord = clean(word); 
      extractChars(cleanedWord);
      printArrayAsString(); 
            
   } // end LetterInventory
   
   // this method takes out all characters other than letters and turns capital letters into lower case
      
   public String clean(String word) { // start clean
      word = word.toLowerCase(); 
      return word.replaceAll("[^A-Za-z0-9]", "");
   } // end clean
   
   // this method turns the strings that are input into individual characters so they can be sorted in alphabetical order
   
   public void extractChars(String word) { // start extractChars
      for(int i = 0; i < word.length(); i++) { // start for 
         char letter = word.charAt(i);
         sortCharForArray(letter); 
      } // end for
    } // end extractChars
    
    // this method sorts the characters in alphabetical order
    
    public void sortCharForArray(char letter) { // start sortCharsForArray
      if(this.letters.isEmpty()) { // start if
          this.letters.add(letter);
      } else {
          int placement = 0; 
          for(int i = 0; i < this.letters.size(); i++) { // start for
            if(letter > this.letters.get(i)) { // start if
               placement++; 
               continue; 
            } // end if
            
          } // end for
          this.letters.add(placement, letter); //add(index, letter); 
      } // end if
       
    } // end sortCharsForArray
    
    // this method prints the array as a string because printing it as an array has commas and brackets
    
    public void printArrayAsString() { // start printArrayAsString
        String good = letters.toString();
        System.out.println( good.replaceAll("[^A-Za-z0-9]", ""));      
    } // end printArrayAsString
    
    // this method adds two separet strings together and prints them as one with all characters in alphabetical order

   public String add(String a, String b) { // start add
       String added = (a.concat(b));
       return added;
   } // end add
   
   // this method compares two strings, takes away all characters they share and then re prints the first one with characters in alphabetical order

   public String subtract(LetterInventory a, LetterInventory b) { // start subtract
       int aindex = 0;
       int bindex = 0;
           while(aindex < a.letters.size() && bindex < b.letters.size()) { // start while
               int value = a.letters.get(aindex).compareTo(b.letters.get(bindex));
               if(value > 0) { // start if
                   bindex++;
               } else if(value < 0) {
                   aindex++;
               } else {
                   a.letters.remove(aindex);
                   b.letters.remove(bindex);
               } // end if
           } // end while
           String c = a.letters.toString();
       return c;
   } // end subtract

} // end class