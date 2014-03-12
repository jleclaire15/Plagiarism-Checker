//John LeClaire, Plagiarism Checker Multiple
//Checks a folder with a folder of files
//Must be folder of .txt files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PlagiarismCheckerMultipleDriver {
  
  public static void main(String[] args) throws FileNotFoundException
  {
    
    /*
     * Files to check
     * ./sm_doc_set 2/
     * 
     */
    
    Scanner kb = new Scanner(System.in);
    System.out.println("Plagiarism Checker - Compares 6 word phrases between multiple documents");
    System.out.println("Enter folder filepath");
    
    File userDocFolder = new File(kb.nextLine()); //makes new file of user folder
    
    System.out.println("Please wait...\n");
    System.out.println("File name : Similar File(# of common phrases)");    
    
    ArrayList<PlagiarismCheckerDriver> userClasses = new ArrayList<PlagiarismCheckerDriver>(); //array of checker classes to have a different class for each sample doc    
    
    for(File userDoc : userDocFolder.listFiles()){ //for every samp doc, instantiate a checker and add it to array of checkers
      userClasses.add(new PlagiarismCheckerDriver(userDoc.getPath()));
    }
    
    for(PlagiarismCheckerDriver go : userClasses){
      go.execute();//runs the PlagiarismCheckerDriver.java x amount of times where x is # of documents
            
    }
  }
}