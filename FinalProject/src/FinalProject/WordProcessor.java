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
		String fileLocation = "C:\\Users\\mojca\\Desktop\\test1.txt";
	    File file = new File(fileLocation);
	    //scanner used in case this line is text 
	    Scanner in1 = new Scanner(file);
	    //scanner used in case this line is command
	    Scanner in2 = new Scanner(file);
	    //we can change the name of a file that we are outputting to something else
	    PrintWriter out = new PrintWriter("test1Formatted.txt");
	    
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
	    
	    //variables holding the output line that we are currently reading
	    String currentOutputLine = "";
	    
	    //variables holding the word leftover from previous line and the count of characters in it
	    String leftoverWord = "";
	    int leftoverCount = 0;
	    
	    boolean startParagraph = true;
	    
	    //reading the line and storing it
    	String currentLine=in1.nextLine();
    	System.out.println(currentLine);
    	//getting the first character of the line
    	String currentChar = Character.toString(currentLine.charAt(0));
    	System.out.println(currentChar);
	    //start reading the file and keep at it until end of file/there is a next line
	    while (in1.hasNextLine())
	    {
	    	
	    	//if it starts with dash it is a command and we need to change defaults
	    	if(currentChar.equals("-"))
	    	{
	    		System.out.println("entered comand if.");
	    		startParagraph = true;
	    		
	    		currentChar = Character.toString(currentLine.charAt(1));
	    		System.out.println("this is command:"+currentChar);
	    		switch(currentChar)
	    		{
	    			case("n"):
	    				//extracting a substring that should contain the number and parsing it as int
	    				String tempSub = currentLine.substring(2,currentLine.length());
	    				System.out.println("Case n, with following:"+tempSub);
	    				int temp1=Integer.parseInt(tempSub); //we should probably throw error if there is no number following the command n
	    				System.out.println("Case n, with number argument:"+temp1);
	    				if(temp1<=100)
	    				{
	    					lineLength = temp1;
	    					System.out.println("Case n changing line length to:"+lineLength);
	    				}
	    				else //we probably need to change the response to the error to something more appropriate
	    					System.out.println("Error: Lenght selection exceeds maximum!");
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
	    				char temp2 = currentLine.charAt(1);
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
	    				//extracting a substring that should contain the number and parsing it as int
	    				String tempSub2 = currentLine.substring(2,currentLine.length()-1);
	    				int temp3=Integer.parseInt(tempSub2); //we should probably throw error if there is no number following the command n
	    				//checking if the number of indents exceeds the current number of characters per line
	    				if(temp3<lineLength)
	    					paragraph = temp3;
	    				else//we probably need to change the response to the error to something more appropriate
	    					System.out.println("Error: Number of indentd exceeds the line length.");
	    				break;
	    			case("b"):
	    				//extracting a substring that should contain the number and parsing it as int
	    				String tempSub3 = currentLine.substring(2,currentLine.length()-1);
	    				blankLine =Integer.parseInt(tempSub3);
	    				break;
	    			case("a"):
	    				//extracting a substring that should contain the number and parsing it as int
	    				String tempSub4 = currentLine.substring(2,currentLine.length()-1);
	    				int temp4=Integer.parseInt(tempSub4);
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
	    		//looping through all the characters in the read in txt line
	    		for(int i = 0; i<currentLine.length(); i++)
	    		{
	    			System.out.println(i);
	    			//reading the character of current line
	    			currentChar = Character.toString(currentLine.charAt(i));
	    			System.out.println("Character at " +i+" is" + currentChar);
    
    				//if it is left justified and number of characters is 0 we print the number of indents and then the current character
    				if(justified == 'l' && startParagraph)
    				{
    					for(int j = 0; j<paragraph; j++)
	    				{
	    					currentOutputLine = currentOutputLine + " ";
	    					currentCharCount++;
	    				}
    				startParagraph = false;
    				}
    				
    				//if wrapping is off
    				//this has to be modified for right,center etc justified
    				if(!wrapping)
	    			{
	    				//while the count of characters is less then line length
	    				while(currentCharCount < lineLength)
	    				{
	    					//until we reach a space we construct a word
	    					if(!currentChar.equals(" "))
	    					{
	    						leftoverWord = leftoverWord + currentChar;
	    						leftoverCount++;
	    						currentCharCount++;
	    					}
	    					//if we reach the end of the word or in other words space add the word to the output line and end that line as well as adding the count for the space
	    					else
	    					{
	    						currentOutputLine = currentOutputLine + leftoverWord;
	    						currentCharCount++;
	    						leftoverWord = "";
	    						leftoverCount = 0;
	    					}
	    					//since we consume a character in the read in line we increase the i
	    					i++;
	    					//and we fetch next character of the line
	    					currentChar = Character.toString(currentLine.charAt(i));	
	    				}
	    				//complete the leftover word 
	    				while(!currentChar.equals(" "))
	    				{
	    					leftoverWord = leftoverWord + currentChar;
    						leftoverCount++;
	    					//since we consume a character in the read in line we increase the i
	    					i++;
	    					//and we fetch next character of the line
	    					currentChar = Character.toString(currentLine.charAt(i));  
	    				}
	    				//if it is right justified add the number of leftover spaces in the beginning of the output line
	    				if(justified == 'r')
	    				{
	    					for(int k = 1; k <= leftoverCount; k++)
	    					{
	    						currentOutputLine = " " + currentOutputLine;
	    					}
	    				}
	    				//if it is center justified divide the number of leftover count in 2 and add half in the beginning
	    				if(justified == 'c')
	    				{
	    					for(int k = 1; k <= leftoverCount/2; k++)
	    					{
	    						currentOutputLine = " " + currentOutputLine;
	    					}
	    				}
	    				//when we reach the maximum character length set for the output we set the char count to leftover char count
	    				//and we print the line to file using println and we reset the current output line to the word we have left from before
	    				out.println(currentOutputLine);
	    				//if it is double spaced print another line after it
	    				if(space==2)
	    					out.println();
	    				currentCharCount = leftoverCount;
	    				currentOutputLine = leftoverWord;
	    			}
    				//if wrapping is on
    				else
    				{
	    				//while the count of characters is less then line length keep constructing the output line
	    				while(currentCharCount < lineLength)
	    				{
    						currentOutputLine = currentOutputLine + currentChar;
    						currentCharCount++;
    						
    						//since we consume a character in the read in line we increase the i
	    					i++;
	    					//and we fetch next character of the line
	    					currentChar = Character.toString(currentLine.charAt(i));	
	    				}
	    				//when we reach the maximum character length set for the output we set the char count to leftover char count
	    				//and we print the line to file using println and we reset the current output line to the word we have left from before
	    				out.println(currentOutputLine);
	    				//if it is double spaced print another line after it
	    				if(space==2)
	    					out.println();
	    				currentCharCount = 0;
	    				currentOutputLine = "";
    				}
    			}
	    	}
    		//after we are done with reading in this line we scan in the next input line
    		currentLine=in1.nextLine();
    		System.out.println("This is next line read in:");
    		System.out.println(currentLine);
    		currentChar = Character.toString(currentLine.charAt(0));
    		System.out.println("This is next character read in:"+currentChar);
	    }
	 }
}
