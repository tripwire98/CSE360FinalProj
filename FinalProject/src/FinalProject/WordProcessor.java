package FinalProject;
import java.io.File; 
import java.io.*;
import java.util.Scanner; 
import java.util.*;

public class WordProcessor {
	public static void main(String[] args)throws Exception 
	 { 
		//change the file location to where the test.txt is on your desktop, we will implement a system that works better
		//for getting the location later on but this works for now
		String fileLocation = "C:\\Users\\brand\\Desktop\\test.txt";
	    File file = new File(fileLocation); 
	  
	    BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	    String st; 
	    while ((st = br.readLine()) != null) {
	      System.out.println(st); 
	    }
	    
	 }
}
