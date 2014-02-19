import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PlagiarismCheckerDriver {
  
  public static void main(String[] args) throws FileNotFoundException
  {
    
    /*
     * ./sm_doc_set 2/catchmeifyoucan.txt
     * ./sm_doc_set 2/edo14.txt
     * 
     */
    
    File docs = new File("./sm_doc_set 2/");    
    ArrayList<ArrayList<String>> wordlist = new ArrayList<ArrayList<String>>();
    ArrayList<PlagiarismChecker> classes = new ArrayList<PlagiarismChecker>();
    
    for(File doc : docs.listFiles()){      
      classes.add(new PlagiarismChecker(doc.getPath()));
    }
    
    for(PlagiarismChecker checker : classes){    
      wordlist.add(checker.fileToArraylist());       
    }
    
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter file path of first document.");
    String filePath1 = kb.nextLine();
    
    PlagiarismChecker checker1 = new PlagiarismChecker(filePath1);
    
    ArrayList<String> wordlist1 = new ArrayList<String>();
    
    wordlist1.addAll(checker1.fileToArraylist());
    
    for(ArrayList<String> check : wordlist){
      check.retainAll(wordlist1); 
      
    }
    
    for(ArrayList<String> check : wordlist){
      
      System.out.println(check.size());
      
      
      
    }

    
  }
  
  
}