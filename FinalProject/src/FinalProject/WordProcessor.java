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
	    int numCommands=0;
	    int numWords = 0;
	    String currentChar = Character.toString(in.next().charAt(0));
	   //read the string character by character until the size of the string
	    while(numChar < st.length())
	    {
	    	
	    	String currentCommand="";
	    	//if the read character is dash then read until empty space? and add into command array? and we dont need to increase the numChar count because we are not putting them into output txt?
	    	//also we need to be checking if we are not in the actual txt but we are on the command line because the input is read a s one string
	    	if(currentChar.equals("-"))
	    	{
	    		currentCommand=currentCommand+currentChar;
	    		currentChar = Character.toString(in.next().charAt(0));
	    		while (!currentChar.equals(" ")) {
	    			currentCommand=currentCommand+currentChar;
	    			currentChar = Character.toString(in.next().charAt(0));
	    		}
	    		//i think we need to be checking if the command array is full and if so doubling it
	    		if (numCommands<100)
	    		{
	    			commands[numCommands]=currentCommand;
	    			numCommands++;	
	    		}
	    		else 
	    		{
	    			//double the array and copy it code missing for now
	    			String[] tempArray = new String[commands.length*2];
	    			for(int i=0; i<commands.length; i++)
	    				tempArray[i]=commands[i];
	    			commands = tempArray;
	    			commands[numCommands]=currentCommand;
		    		numCommands++;	
	    		}
	    	}
	    	//if it is not a command either start storing the characters as words somewhere or lines ?!?
	    	//or we can do this whole part once all commands are read and we know how many characters per line/if wrapping is on
	    	else 
	    	{
	    		String word = currentChar;
	    		//making an array to hold a line of words?
	    		String[] line = new String[100];
	    		//we need to count the character
	    		numChar++;
	    		word=word+currentChar;
	    		currentChar = Character.toString(in.next().charAt(0));
	    		while (!currentChar.equals(" ")) {
	    			word=word+currentChar;
	    			currentChar = Character.toString(in.next().charAt(0));	
	    			numChar++;
	    		}
	    		//checking if the array for the line is full and f number of characters is exactly divisable by 100s
	    		if ((numWords+1)%100!=0 && numChar%100!=0)
	    		{
	    			
	    			line[(numWords+1)%100]=word;
	    			numWords++;	
	    		}
	    		else if(numChar%100!=0) 
	    		{
	    			//double the array and copy it code missing for now
	    			String[] tempArray = new String[line.length*2];
	    			for(int i=0; i<line.length; i++)
	    				tempArray[i]=line[i];
	    			line = tempArray;
	    			line[(numWords+1)%100]=word;
	    			numWords++;	
	    		}
	    		else
	    			//need to start a new line
	    	}
	    }
	    
	 }
}
