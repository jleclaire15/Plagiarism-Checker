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
    System.out.println("Enter Folder Filepath");
    
    File userDocFolder = new File(kb.nextLine());
    
    
    
    ArrayList<PlagiarismCheckerDriver> userClasses = new ArrayList<PlagiarismCheckerDriver>(); //array of checker classes to have a different class for each sample doc    
    
    for(File userDoc : userDocFolder.listFiles()){ //for every samp doc, instantiate a checker and add it to array of checkers
      userClasses.add(new PlagiarismCheckerDriver(userDoc.getPath()));
    }
    
    for(PlagiarismCheckerDriver go : userClasses){
      go.execute();
      
      
    }
    
    
    
  }
}