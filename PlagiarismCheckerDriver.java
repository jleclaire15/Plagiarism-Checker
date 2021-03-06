//John LeClaire, Plagiarism Checker
//Checks one file with folder of files
//Must be a .txt file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class PlagiarismCheckerDriver {
  
  String userDoc = "";
  
  public PlagiarismCheckerDriver(String userFile)
  {
    userDoc = userFile;
  }
  
  /*
   * Files to check
   * ./sm_doc_set 2/catchmeifyoucan.txt
   * 
   */
  
  public void execute() throws FileNotFoundException {
    
    File sampDocFolder = new File("./sm_doc_set 2/"); //makes file of folder with sample docs
    
    File userDocu = new File("./sm_doc_set 2/" + userDoc);
    
    ArrayList<ArrayList<String>> sampWordlist = new ArrayList<ArrayList<String>>(); //array of string arrays to hold wordlists of sample docs  
    ArrayList<ArrayList<Integer>> sampHashlist = new ArrayList<ArrayList<Integer>>();
    ArrayList<PlagiarismChecker> sampClasses = new ArrayList<PlagiarismChecker>(); //array of checker classes to have a different class for each sample doc    
    
    for(File sampDoc : sampDocFolder.listFiles()){ //for every samp doc, instantiate a checker and add it to array of checkers
      sampClasses.add(new PlagiarismChecker(sampDoc.getPath()));
    }
    
    for(PlagiarismChecker sampClass : sampClasses){ //for each one of those checkers, add the sample docs string array to wordlist
      sampWordlist.add(sampClass.fileToArraylist());
      sampHashlist.add(sampClass.listToHash(sampClass.fileToArraylist())); //turn string array to hashlist
    }
    
    String userFilePath = userDoc; //filepath of user doc
    
    PlagiarismChecker userClass = new PlagiarismChecker(userFilePath); //checker for the user doc
    ArrayList<String> userWordlist = new ArrayList<String>(); //wordlist, hashlist for user doc
    ArrayList<Integer> userHashlist = new ArrayList<Integer>();
    
    userWordlist.addAll(userClass.fileToArraylist());    
    userHashlist.addAll(userClass.listToHash(userClass.fileToArraylist()));
    
    for(ArrayList<Integer> sampHash : sampHashlist){ //retain all hashes same between user doc and sample doc
      sampHash.retainAll(userHashlist);     
    }
    
    ArrayList<String> suspectedFiles = new ArrayList<String>();
    ArrayList<Integer> suspectedFilesNumber = new ArrayList<Integer>();
    
    for(int i = 0; i < sampDocFolder.listFiles().length; i++){     //sets up results to be displayed      
      if(sampHashlist.get(i).size() == 0){}
      
      else{        
        if(!sampDocFolder.listFiles()[i].getName().equalsIgnoreCase(userDocu.getName())){  //sets up results to be displayed again
          suspectedFilesNumber.add(sampHashlist.get(i).size());
        }
      }
      
      if(!sampDocFolder.listFiles()[i].getName().equalsIgnoreCase(userDocu.getName())){ //sets up results to be displayed some more        
        if(sampHashlist.get(i).size() >= 1){
          suspectedFiles.add(sampDocFolder.listFiles()[i].getName());        
        }        
      }
    }
    
    if(suspectedFiles.size() > 0){  //prints results cleanly on screen     
      System.out.print(userDocu.getName() + " : ");
      
      for(int i = 0; i < suspectedFiles.size(); i++){
        System.out.print(suspectedFiles.get(i) + "(" + suspectedFilesNumber.get(i) + ") ");
      }
      
      System.out.println("");
      
    }
  }  
}