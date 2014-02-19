//by Troy Carson
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
    
    //makes file of folder with sample docs
    
    File docs = new File("./sm_doc_set 2/");    
    
    //makes array of string arrays to hold wordlists of sample docs
    
    ArrayList<ArrayList<String>> wordlist = new ArrayList<ArrayList<String>>();
    
    //makes array of plagiarismchecker classes to have a different class for each sample doc
    
    ArrayList<PlagiarismChecker> classes = new ArrayList<PlagiarismChecker>();
    
    //for every samp doc, instantiate a checker and add it to array of checkers
    
    for(File doc : docs.listFiles()){      
      classes.add(new PlagiarismChecker(doc.getPath()));
    }
    
    //for each one of those checkers, add the sample docs string array to wordlist
    
    for(PlagiarismChecker checker : classes){    
      wordlist.add(checker.fileToArraylist());       
    }
    
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter file path of the document you wish to check.");
    String filePath1 = kb.nextLine();
    
    //checker for the user doc
    
    PlagiarismChecker checker1 = new PlagiarismChecker(filePath1);  
    ArrayList<String> wordlist1 = new ArrayList<String>();    
    wordlist1.addAll(checker1.fileToArraylist());
    
    //retain all words same between user doc and sample doc
    
    for(ArrayList<String> check : wordlist){
      check.retainAll(wordlist1);     
    }
    
    //prints length of all arrays  
    
    for(int i = 0; i < docs.listFiles().length; i++){   
      System.out.print("six word phrases in common with " + docs.listFiles()[i]);
      System.out.println("             " + wordlist.get(i).size());  
    }
  }  
}