// Programmer: Rey O'Dell
// Date: 6/8/23
// Class: CS &145
// Assignment: Word Search
// Purpose: To generate a word search puzzle
// References: W3 Schools, my dad(CS major)

import java.util.*;

public class WordSearch { // start class

    static String[] words;
    public static char[][] search;

    public static void main(String[] args) { // start main
    printIntro();
    } // end main
    
    // this method explains the puzzle to the user and lets them choose what they want to do

    public static void printIntro() { // start printIntro
    
    Scanner input = new Scanner(System.in);
    boolean run = true;
    char[][] solution;
    int col = 0;
    System.out.println("This is a word search generator, it will create a puzzle where there are hidden words mixed in with random letters and the user must identify the words");
        while(run == true) { // start while
            System.out.println("Please choose an action:\n\t1: Generate a word search\n\t2: Print word search\n\t3: Show solution\n\t4: Quit the program");
                int action = input.nextInt();
            switch(action) { // start switch
                case 1:
                    search = generate();
                        for (int i = 0; i < search.length; i++) { // start for
                            if (search[i].length > col) { // start if
                            col = search[i].length;
                            } // end if
                        } // end for       
                    break;
                case 2:       
                    print(search, search.length, col); 
                    break;
                case 3:
                    solution = solutions();
                    print(solution, search.length, col);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Please enter valid command");
                    break;
            } // end switch
        } // end while
    } // end printIntro
    
    // this method generates a word search with the users input words and random characters
    
    public static char[][] generate() { // start generate
    
    int numWords = fill();
    int max = 0;
        for(int i = 0; i < words.length; i++) { // start for
            if(words[i].length() > max) { // start if
                max  = words[i].length();
            } // end if
        } // end for
        char[][] search = new char[numWords][max];
        Random rand = new Random();
            for(int i = 0; i < numWords; i++) { // start for
              String word = words[i];
                for(int j = 0; j < max; j++) { // start for
                char c = (char)(rand.nextInt(26) + 'a');
                    for (int k = 0; k < word.length(); k++) { // start for
                    search[i][k] = word.charAt(k);
                    } // end for
                if(word.length() != max) { // start if
                search[i][j] = c;
                } // end if
                } // end for
            } // end for
    return search;
    } // end generate
    
    // this method prints out the generated word search
    
    public static void print(char[][] search, int max, int numWords) { // start print
        for(int i = 0; i < max; i++) { // start for
            for(int j = 0; j < numWords; j++) { // start for
                System.out.print(search[i][j]);
            } // end for
            System.out.println();
        } // end for
    } // end print
    
    // this method generates the same word search already made but with X's instead of random characters
    
    public static char[][] solutions() { // start solutions
    
     int max = 0;
        for(int i = 0; i < words.length; i++) { // start for
            if(words[i].length() > max) { // start if
                max  = words[i].length();
            } // end if
        } // end for
    char[][] search = new char[words.length][max];
            for(int i = 0; i < words.length; i++) { // start for
              String word = words[i];
                for(int j = 0; j < max; j++) { // start for
                    for (int k = 0; k < word.length(); k++) { // start for
                    search[i][k] = word.charAt(k);
                    } // end for
                if(word.length() != max) { // start if
                search[i][j] = 'X';
                } // end if
                } // end for
            } // end for
    return search;
    } // end solutions
    
    // this method fills the words array
    
    public static int fill() { // start fill
       Scanner input = new Scanner(System.in);
        System.out.println("Please enter how many words you want in your word search");
            int numWords = input.nextInt();
        words = new String[numWords];
        for(int i = 0; i < numWords; i++) { // start for
            System.out.println("Please enter your word");
            words[i] = input.next();
        } // end for
        return numWords;
    } // end fill
} // end class