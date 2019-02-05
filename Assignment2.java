/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Donovan
 */
public class Assignment2 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //menu();
        
        menu();
       
    }
    
//    public static String menu() {
//        int selection;
//        String finalWord = " ";
//        String userSelection = JOptionPane.showInputDialog("** HANGMAN**\n**************\nChoose from the following options: \n1: Play game from a randomly chosen word in a list\n2: Play game from a word entered by another user\n3: Exit Game\n");
//        selection = Integer.parseInt(userSelection);
//        
//        if(selection == 1)
//        {
//           finalWord = getWord(); 
//        }    
//        
//        if(selection == 2)
//        {
//            finalWord = haveUserTwoEnterWord();
//        }
//        if(selection == 3)
//        {
//            JOptionPane.showMessageDialog(null, "Thank's for playing!");
//            System.exit(0);
//        }
//        return finalWord;
//    }
//    
    
    public static void menu() {
        int selection;
        boolean gamePlayed = false;
        String finalWord = " ";
        String userSelection = JOptionPane.showInputDialog("** HANGMAN**\n**************\nChoose from the following options: \n1: Play game from a randomly chosen word in a list\n2: Play game from a word entered by another user\n3: Exit Game\n");
        selection = Integer.parseInt(userSelection);
        
        if(selection == 1)
        {
           finalWord = getWord(); 
        }    
        
        if(selection == 2)
        {
            finalWord = haveUserTwoEnterWord();
        }
        if(selection == 3)
        {
            JOptionPane.showMessageDialog(null, "Thank's for playing!");
            System.exit(0);
        }
        System.out.println(finalWord); // tesssssssssssssssssssst
        gamePlayed = playGame(finalWord);
        if(gamePlayed == true)
        {
            JOptionPane.showMessageDialog(null, "CONGRATSSSSSSSSSSSSSSSSSSSSSSSSSSSSS! YOU WON!");    
        }
        else
        {
            JOptionPane.showMessageDialog(null, "CONGRATSSSSSSSSSSSSSSSSSSSSSSSSSSSSS! JUST KIDDING! YOU LOST.");
        }
    }
    
    
    public static String getWord() {
        String[] wordList = new String[10];
        wordList[0] = "dog";
        wordList[1] = "car";
        wordList[2] = "boat";
        wordList[3] = "speaker";
        wordList[4] = "grapgics";
        wordList[5] = "programming";
        wordList[6] = "java";
        wordList[7] = "party";
        wordList[8] = "lights";
        wordList[9] = "goofy";
       
        Random rand = new Random();
        int wordChoice = rand.nextInt(10);
        return wordList[wordChoice];
    }
    
    public static String haveUserTwoEnterWord() {
        
        String correctUserWord = " ";
        boolean isValidWord = false;
        while(isValidWord == false)
        {
            String userTwoInputWord = JOptionPane.showInputDialog("User Two. Please enter a word for user one to guess: ");
            
            for(int i = 0; i < userTwoInputWord.length(); i++)
            {
                if( (userTwoInputWord.charAt(i) >= 65 && userTwoInputWord.charAt(i) <= 90) || (userTwoInputWord.charAt(i) >= 97 && userTwoInputWord.charAt(i) <= 122) )
                {
                    correctUserWord = userTwoInputWord;
                    isValidWord = true;
                }
                else
                {
                    isValidWord = false;
                    break;
                }
            }
        }
        return correctUserWord;
    }
    
    public static boolean playGame(String word)
    {
        boolean haveWon = true;
        int turnCounter = 0;
        Scanner keyboard = new Scanner(System.in);
        int errorCounter = 0; //counts the number of missed words
        boolean isValidLetter = false; //determines whether entered word is correct
        char guessedLetter = ' ';
        int wordLength = 0; //keeps track of how big the char array is
        
        String tempWord = word;
        char[] tempWordChars = tempWord.toCharArray();
        
        for(int i = 0; i < word.length(); i++)
        {
            wordLength++;
            tempWordChars[i] = '-';
        }
        
        
        while(isValidLetter == false)
        {
            System.out.println("Please enter a guess");
            guessedLetter = keyboard.next().charAt(0);
            if( (guessedLetter >= 65 && guessedLetter <= 90) || (guessedLetter >= 97 && guessedLetter <= 122))
            {
                isValidLetter = true;
                break;
            }
            else
            {
                isValidLetter = false;
            }
        }
        
        for(int i = 0; i < wordLength - 1; i++)
        {
            if(guessedLetter == tempWord.charAt(i))
            {
                tempWordChars[i] = guessedLetter;
            } 
            else
            {
                errorCounter++;
            }
            if(errorCounter == wordLength)
            {
                turnCounter++;
            }
            if(turnCounter == 7)
            {
                haveWon = false;
            }
        }
        
        return haveWon;
    }
    
   
    
    
    
    
}
