//John LeClaire, Plagiarism Checker
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
     * Files to check
     * ./sm_doc_set 2/catchmeifyoucan.txt
     * 
     */
    
    File docs = new File("./sm_doc_set 2/"); //makes file of folder with sample docs
    
    ArrayList<ArrayList<String>> wordlist = new ArrayList<ArrayList<String>>(); //array of string arrays to hold wordlists of sample docs  
    ArrayList<ArrayList<Integer>> hashlist = new ArrayList<ArrayList<Integer>>();
    ArrayList<PlagiarismChecker> classes = new ArrayList<PlagiarismChecker>(); //array of checker classes to have a different class for each sample doc    
    
    for(File doc : docs.listFiles()){ //for every samp doc, instantiate a checker and add it to array of checkers
      classes.add(new PlagiarismChecker(doc.getPath()));
    }
    
    for(PlagiarismChecker checker : classes){ //for each one of those checkers, add the sample docs string array to wordlist
      wordlist.add(checker.fileToArraylist());
      hashlist.add(checker.listToHash(checker.fileToArraylist())); //turn string array to hashlist
    }
    
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter file path of the document you wish to check.");
    String filePath1 = kb.nextLine(); //filepath of user doc
    
    PlagiarismChecker checker1 = new PlagiarismChecker(filePath1); //checker for the user doc
    ArrayList<String> wordlist1 = new ArrayList<String>(); //wordlist, hashlist ofr user doc
    ArrayList<Integer> hashlist1 = new ArrayList<Integer>();
    
    wordlist1.addAll(checker1.fileToArraylist());
    hashlist1.addAll(checker1.listToHash(checker1.fileToArraylist()));
    
    for(ArrayList<Integer> check : hashlist){ //retain all hashes same between user doc and sample doc
      check.retainAll(hashlist1);     
    }
    
    for(int i = 0; i < docs.listFiles().length; i++){     //prints name and length of all file hashlists  
      System.out.print("six word phrases in common with " + docs.listFiles()[i]);
      System.out.println("             " + hashlist.get(i).size());  
    }
  }  
}