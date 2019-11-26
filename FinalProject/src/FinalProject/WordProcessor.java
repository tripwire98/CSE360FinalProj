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
	   //we read the characters in the string using scanner?
	    Scanner in = new Scanner(st);
	    //creating an array holding the commands of a size 100 and if there is more commands we can double it?
	    String[] commands = new String[100];
	    //an integer holding the count of the characters
	    int numChar = 0;
	   //read the string character by character until the size of the string
	    while(numChar < st.length())
	    {
	    	String currentChar = Character.toString(in.next().charAt(0));
	    	String currentCommand="";
	    	//if the read character is dash then read until empty space? and add into command array?
	    	if(currentChar.equals("-"))
	    	{
	    		currentCommand=currentCommand+currentChar;
	    		currentChar = Character.toString(in.next().charAt(0));
	    		if ()
	    		
	    	}
	    }
	    
	 }
}
