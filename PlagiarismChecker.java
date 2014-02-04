import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class PlagiarismChecker {
  
  public static void main(String[] args)
  {
      
    
  }
  public ArrayList<String> fileToArraylist()  throws FileNotFoundException {
    
    ArrayList<String> phrase = new ArrayList<String>();
  
    File f = new File("/Users/jleclaire15/Plagiarism Checker/sm_doc_set 2/catchmeifyoucan.txt");
  
    Scanner scan = new Scanner(f);
    
    for(int i = 0; i < 6; i++){
      
      phrase.add(scan.nextLine());
      
    }
    

    return phrase;

    
    
  }
}