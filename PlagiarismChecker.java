//John LeClaire, Plagiarism Checker
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PlagiarismChecker {
  
  String userFilePath = "";
  
  public PlagiarismChecker(String filePath){ //constructor
    userFilePath = filePath; 
  }
  
  public ArrayList<String> fileToArraylist()  throws FileNotFoundException {    //makes arraylist from a filepath
    ArrayList<String> wordlist = new ArrayList<String>();  
    
    File doc = new File(userFilePath);
    Scanner scan = new Scanner(doc);  
    
    for(int i = 0; scan.hasNextLine(); i++){       //for every line, split into each word, add each word into a string array
      String[] wordsInLineArray = scan.nextLine().split(" ");  //////this method gets an array with a single word in every index///////
      ArrayList<String> wordsInLineArrayList = new ArrayList<String>(Arrays.asList(wordsInLineArray));
      wordlist.addAll(wordsInLineArrayList);   
    }    
    
    ArrayList<String> sixWordPhrases = new ArrayList<String>(); //separate array for 6 word phrase array
    
    while(wordlist.size() >=6){ //adds 0-5 words to make a phrase, adds to sep 6 word array, deletes index 0 from single word array
      sixWordPhrases.add(wordlist.get(0) + " " + wordlist.get(1) + " " + wordlist.get(2) + " " + wordlist.get(3) + " " + wordlist.get(4) + " " + wordlist.get(5));
      wordlist.remove(0);
    }    
    return sixWordPhrases;      
  }
  
  public ArrayList<Integer> listToHash(ArrayList<String> words){ //turns arraylist of strings into arraylist of hashes type Integer
    
    ArrayList<Integer> hashlist = new ArrayList<Integer>();
    ArrayList<String> wordlist = words;
    
    for(String sixWordPhrase : wordlist){ //for every string, add string.hashCode into Integer arraylist
      
      hashlist.add(sixWordPhrase.hashCode());
      
    }
    return hashlist;      
  }
}