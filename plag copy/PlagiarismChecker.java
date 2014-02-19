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
  
  public ArrayList<String> fileToArraylist()  throws FileNotFoundException {    
    ArrayList<String> phrase = new ArrayList<String>();  
    File text = new File(filePath);
    Scanner scan = new Scanner(text);  
    
    for(int i = 0; scan.hasNextLine(); i++){           
      String[] list = scan.nextLine().split(" ");
      ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(list));      
      phrase.addAll(list2);     
    }    
    System.out.println(phrase);
    return phrase;    
  }
}