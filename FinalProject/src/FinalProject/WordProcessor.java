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
	    Scanner in = new Scanner(file);
	    //we can change the name of a file that we are outputting to something else
	    PrintWriter out = new PrintWriter("filename.txt");
	    
	    //variables keeping track of commands set to defaults
	    int lineLength = 80;
	    char justified = 'l';
	    boolean wrapping = false;
	    int space = 1;
	    boolean title = false;
	    int paragraph = 0;
	    int blankLine = 0;
	    boolean twoColumns = false;
	    
	    //variable keeping track of the character count
	    int currentCharCount = 0;
	    
	    //variables holding the word and output line that we are currently reading
	    String currentOutputLine = "";
	    String currentWord = "";
	    
	    //start reading the file and keep at it until end of file/there is a next line
	    while (in.hasNextLine())
	    {
	    	//reading the line and storing it
	    	String currentLine=in.nextLine();
	    	//getting the first character of the line
	    	String currentChar = Character.toString(currentLine.charAt(0));
	    	//if it starts with dash it is a command and we need to change defaults
	    	if(currentChar.equals("-"))
	    	{
	    		currentChar = Character.toString(in.next().charAt(0));
	    		switch(currentChar)
	    		{
	    			case("n"):
	    				int temp1=in.nextInt(); //we should probably throw error if there is no number following the command n
	    				if(temp1<=100)
	    					lineLength = temp1;
	    				else //we probably need to change the response to the error to something more appropriate
	    					System.out.println("Error: Lenght selection exceeds maximum!")
	    				break;
	    			case("r"):
	    				justified = 'r';
	    				break;
	    			case("l"):
	    				justified = 'l';
	    				break;
	    			case("c"):
	    				justified = 'c';
	    				break;
	    			case("e"):
	    				justified = 'e';
	    				break;
	    			case("w"):
	    				char temp2 = in.next().charAt(0);
	    				if(temp2 == '+')
	    					wrapping = true;
	    				else if(temp2 == '-')
	    					wrapping = false;
	    				else//we probably need to change the response to the error to something more appropriate
	    					System.out.println("Error: Wrapping command must be followed by + or -.");
	    				break;
	    			case("s"):
	    				space = 1;
	    				break;
	    			case("d"):
	    				space = 2;
	    				break;
	    			case("t"):
	    				title = true;
	    				break;
	    			case("p"):
	    				int temp3=in.nextInt();
	    				//checking if the number of indents exceeds the current number of characters per line
	    				if(temp3<lineLength)
	    					paragraph = temp3;
	    				else//we probably need to change the response to the error to something more appropriate
	    					System.out.println("Error: Number of indentd exceeds the line length.");
	    				break;
	    			case("b"):
	    				blankLine =in.nextInt();
	    				break;
	    			case("a"):
	    				int temp4=in.nextInt();
	    				if(temp4 == 1)
	    					twoColumns = false;
	    				else if(temp4 == 2)
	    					twoColumns = true;
	    				else//we probably need to change the response to the error to something more appropriate
	    					System.out.println("Error: You can only choose between 1 or 2 columns.");
	    				break;	    		
	    		}
	    	}
	    	else//if it starts with letter or space start reading
	    	{
	    		for(int i = 0; i<lineLength; i++)
	    		{
	    			//if the line does not start with empty space read the line in 
	    			if(!currentChar.equals(" "))
	    			{
	    				//if it is left justified and number of characters is 0 we print the number of indents and then the current character
	    				for(int j = 0; j<paragraph; j++)
	    					currentOutputLine = currentOutputLine + " ";
	    				currentOutputline = currentOutputLine + currentChar;
	    			}
	    		}
	    		
	    	}
	    	//an integer holding the count of the characters,
		    int numChar = 0;
		    int numWords = 0;
		   
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
}
