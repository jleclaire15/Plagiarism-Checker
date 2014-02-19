//by Troy Carson
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
  
  public PlagiarismChecker(String userFilePath){
    filePath = userFilePath; 
  }
  
  public ArrayList<String> fileToArraylist()  throws FileNotFoundException {    //Arraylist of 6 word phrases
    ArrayList<String> phrase = new ArrayList<String>();  
    
    File text = new File(filePath);
    Scanner scan = new Scanner(text);  
    
    for(int i = 0; scan.hasNextLine(); i++){       
      String[] list = scan.nextLine().split(" ");
      ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(list));
      phrase.addAll(list2);   
    }    
    
    ArrayList<String> sixwords = new ArrayList<String>();
    
    while(phrase.size() >=6){
      sixwords.add(phrase.get(0) + " " + phrase.get(1) + " " + phrase.get(2) + " " + phrase.get(3) + " " + phrase.get(4) + " " + phrase.get(5));
      phrase.remove(0);
      
    }    
    return sixwords;      
  }
  
  
  
  
  
  
  
  
  /*public ArrayList<Integer> listToHash(ArrayList<String> words){
    
    ArrayList<Integer> hashlist = new ArrayList<Integer>();
    ArrayList<String> wordlist = words;

    for(String phrase : wordlist){
      
      hashlist.a
      
    }

        
      
      
      
      return null;
      
    }
    
    
    
    
    
  }
  }*/
}