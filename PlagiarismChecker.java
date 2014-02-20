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
  
  String filePath = "";
  
  public PlagiarismChecker(String userFilePath){ //constructor
    filePath = userFilePath; 
  }
  
  public ArrayList<String> fileToArraylist()  throws FileNotFoundException {    //makes arraylist from a filepath
    ArrayList<String> phrase = new ArrayList<String>();  
    
    File text = new File(filePath);
    Scanner scan = new Scanner(text);  
    
    for(int i = 0; scan.hasNextLine(); i++){       //for every line, split into each word, add each word into a string array
      String[] list = scan.nextLine().split(" ");  //////this method gets an array with a single word in every index///////
      ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(list));
      phrase.addAll(list2);   
    }    
    
    ArrayList<String> sixwords = new ArrayList<String>(); //separate array for 6 word phrase array
    
    while(phrase.size() >=6){ //adds 0-5 words to make a phrase, adds to sep 6 word array, deletes index 0 from single word array
      sixwords.add(phrase.get(0) + " " + phrase.get(1) + " " + phrase.get(2) + " " + phrase.get(3) + " " + phrase.get(4) + " " + phrase.get(5));
      phrase.remove(0);
    }    
    return sixwords;      
  }
  
  public ArrayList<Integer> listToHash(ArrayList<String> words){ //turns arraylist of strings into arraylist of hashes type Integer
    
    ArrayList<Integer> hashlist = new ArrayList<Integer>();
    ArrayList<String> wordlist = words;
    
    for(String phrase : wordlist){ //for every string, add string.hashCode into Integer arraylist
      
      hashlist.add(phrase.hashCode());
      
    }
    return hashlist;      
  }
}