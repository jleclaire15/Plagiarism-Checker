import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PlagiarismChecker {
  
  public static void main(String[] args) throws FileNotFoundException
  {
    
    ArrayList<String> b = new ArrayList<String>();
    
    b.addAll(fileToArraylist());

    System.out.println(b);
    
    
  }
  
  public static ArrayList<String> fileToArraylist()  throws FileNotFoundException {
    
    ArrayList<String> phrase = new ArrayList<String>();  
    File text = new File("/Users/jleclaire15/Plagiarism Checker/sm_doc_set 2/catchmeifyoucan.txt");
    Scanner scan = new Scanner(text);    
    
    for(int i = 0; i < 6; i++){     
      
       String[] list = scan.nextLine().split(" ");
    ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(list));
      
      phrase.addAll(list2);     
    }
    
    return phrase;
    
  }
}