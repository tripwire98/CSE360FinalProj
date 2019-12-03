package FinalProject;
import java.io.*;
import java.util.Scanner; 
import java.util.*;

//Issue on line 200 with indexes out of range, 


public class WordProcessor {
	public static void main(String[] args)throws Exception 
	 { 
		
		//change the file location to where the test.txt is on your desktop, we will implement a system that works better
		//for getting the location later on but this works for now
		
		//you need to change these files to where they are on your pc
		String fileLocation = "test1.txt";
	    File file = new File(fileLocation);
	    
	    //scanner used in case this line is text 
	    Scanner in1 = new Scanner(file);
	    //scanner used in case this line is command
	   // Scanner in2 = new Scanner(file);
	    //we can change the name of a file that we are outputting to something else
	    
	    //you need to change these files to where they are on your pc
	    File fout = new File("test1done.txt");
	    
	   	FileOutputStream fos = new FileOutputStream(fout);
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
	    
	    File errorLog = new File("errorLogtest1.txt");
	    
	    FileOutputStream errors = new FileOutputStream(errorLog);
	    BufferedWriter errLog = new BufferedWriter(new OutputStreamWriter(errors));
	    int errCount = 0;
	    int lineReadInCount = 0;
	    
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
	    int leftOverChars = 0;
	    
	    boolean startParagraph = true;
	    
	    //reading the line and storing it
    	//String currentLine=in1.nextLine();
    	
	    //start reading the file and keep at it until end of file/there is a next line
	    do
	    {
	    	String currentLine=in1.nextLine();
	    	
	    	//getting the first character of the line
	    	String currentChar = Character.toString(currentLine.charAt(0));
	    	
    		currentChar = Character.toString(currentLine.charAt(0));
    		
	    	//if it starts with dash it is a command and we need to change defaults
	    	if(currentChar.equals("-"))
	    	{
	    		startParagraph = true;
	    		
	    		currentChar = Character.toString(currentLine.charAt(1));
	    		
	    		switch(currentChar)
	    		{
	    			case("n"):
	    				//extracting a substring that should contain the number and parsing it as int
	    				String tempSub = currentLine.substring(2,currentLine.length());
	    				int temp1=Integer.parseInt(tempSub); //we should probably throw error if there is no number following the command n
	    				
	    				if(temp1<=100)
	    				{
	    					lineLength = temp1;
	    				}
	    				else //we probably need to change the response to the error to something more appropriate
	    				{
	    					errCount++;
							errLog.write("Error on line " + lineReadInCount + " : Length selection exceeds maximum!");
		    				errLog.newLine();
	    				}
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
	    				char temp2 = currentLine.charAt(2);
	    				if(temp2 == '+')
	    					wrapping = true;
	    				else if(temp2 == '-')
	    					wrapping = false;
	    				else//we probably need to change the response to the error to something more appropriate
	    				{
	    					errCount++;
	    					errLog.write("Error on line " + lineReadInCount + " : Wrapping command must be followed by + or -.");
		    				errLog.newLine();
	    				}
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
	    				String tempSub2 = currentLine.substring(2,currentLine.length());
	    				int temp3=Integer.parseInt(tempSub2); //we should probably throw error if there is no number following the command n
	    				//checking if the number of indents exceeds the current number of characters per line
	    				if(temp3<lineLength)
	    					paragraph = temp3;
	    				else//we probably need to change the response to the error to something more appropriate
	    				{
	    					errCount++;
	    					errLog.write("Error on line " + lineReadInCount + " : Number of indents exceeds the line length.");
		    				errLog.newLine();
	    				}
	    				break;
	    			case("b"):
	    				//extracting a substring that should contain the number and parsing it as int
	    				String tempSub3 = currentLine.substring(2,currentLine.length());
	    				blankLine =Integer.parseInt(tempSub3);
	    				break;
	    			case("a"):
	    				//extracting a substring that should contain the number and parsing it as int
	    				String tempSub4 = currentLine.substring(2,currentLine.length());
	    				int temp4=Integer.parseInt(tempSub4);
	    				if(temp4 == 1)
	    					twoColumns = false;
	    				else if(temp4 == 2)
	    					twoColumns = true;
	    				else//we probably need to change the response to the error to something more appropriate
	    				{
	    					errCount++;
	    					errLog.write("Error on line " + lineReadInCount + " : You can only choose between 1 or 2 columns.");
		    				errLog.newLine();
	    				}
	    				break;	    		
	    		}
	    	}
	    	//if columns are not set to 2 columns
	    	else if(!twoColumns)
	    	{
	    		System.out.println("Wrapping is " + wrapping + " at line 176");
	    		if(blankLine != 0)
	    		{
	    			for(int l = 0; l<blankLine;l++)
	    			{
	    				out.newLine();
	    			}

	    			blankLine = 0;
	    		}
		    		
		    	//looping through all the characters in the read in txt line
		    	for(int i = 0; i<currentLine.length()-1; i++)
		    	{	
		    			System.out.println("i in the beggining of for loop line 145: "+i);
		    			//reading the character of current line
		    			currentChar = Character.toString(currentLine.charAt(i));
		    			
		    			//if title is on and the line length is longer than count give an errr but still format the appropriate length of it
		    			if(title && (currentLine.length() != lineLength))
		    			{
		    				errCount++;
	    					errLog.write("Error on line " + lineReadInCount + " : Title has to fit on one line, with the length specified by user");
	    					System.out.println("line 186");
	    					System.out.println("Error on line " + lineReadInCount + " : Title has to fit on one line, with the length specified by user");
		    				errLog.newLine();
		    			}
		    			else if(title)
		    			{
		    				
		    			}
		    			//else if we are starting paragraph
		    			
	    				//if it is left justified and number of characters is 0 we print the number of indents and then the current character
		    			if(justified == 'l' && paragraph != 0 && startParagraph)
		    			{
		    				errCount++;
	    					errLog.write("Error on line " + lineReadInCount + " : Paragraph indent can only be used with left justification");
	    					errLog.newLine();
		    			}
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
		    			if(!wrapping)
		    			{
	    					//while the count of characters is less then line length
	    					while(currentCharCount < lineLength && i<currentLine.length())
		    				{
	    						//until we reach a space we construct a word
		    					if(!currentChar.equals(" ") || currentChar.equals(null))
		    					{
		    						leftoverWord = leftoverWord + currentChar;
		    						leftoverCount++;
		    						currentCharCount++;
		    					}
		    					//if we reach the end of the word or in other words space add the word to the output line and end that line as well as adding the count for the space
		    					else
		    					{
		    						currentOutputLine = currentOutputLine + leftoverWord+ " " ;
		    						currentCharCount++;
		    						leftoverWord = "";
		    						leftoverCount = 0;
		    					}
		    					//since we consume a character in the read in line we increase the i
		    					i++;
		    					//and we fetch next character of the line
		    					if(i<currentLine.length())
		    						currentChar = Character.toString(currentLine.charAt(i));	
		    					//questionable part
		    				}
		    				//if it is right justified add the number of leftover spaces in the beginning of the output line
		    				if(justified == 'r')
		    				{
		    					System.out.println("Justification is: " + justified);
		    					leftOverChars = lineLength - currentOutputLine.length();
		    					for(int k = 1; k <= leftOverChars; k++)
		    					{
		    						currentOutputLine = " " + currentOutputLine;
		    					}
		    				}
		    				//if it is center justified divide the number of leftover count in 2 and add half in the beginning
		    				if(justified == 'c')
		    				{
		    					System.out.println("Justification is: " + justified);
		    					System.out.println(leftoverCount);
		    					leftOverChars = lineLength - currentOutputLine.length();
		    					for(int k = 1; k <= leftOverChars/2; k++)
		    					{
		    						currentOutputLine = " " + currentOutputLine;
		    					}
		    				}
		    				//complete the leftover word 
		    				while(!currentChar.equals(" ") && i<currentLine.length()-1)
		    				{
		    					leftoverWord = leftoverWord + currentChar;
	    						leftoverCount++;
		    					//since we consume a character in the read in line we increase the i
		    					i++;
		    					//and we fetch next character of the line
		    					currentChar = Character.toString(currentLine.charAt(i));  
		    				}
		    				
		    				//when we reach the maximum character length set for the output we set the char count to leftover char count
		    				//and we print the line to file using println and we reset the current output line to the word we have left from before
		    				out.write(currentOutputLine);
		    				out.newLine();
		    				
		    				//if it is double spaced print another line after it
		    				if(space==2)
		    					out.newLine();
		    				
		    				if(i==currentLine.length())
		    					out.write(leftoverWord);
		    				
		    				currentCharCount = leftoverCount;
		    				currentOutputLine = "";//leftoverWord;
		    			}
	    				//if wrapping is on
	    				else
	    				{
	    					//while the count of characters is less then line length keep constructing the output line
		    				while(currentCharCount < lineLength && i<currentLine.length()-1)
		    				{
		    					currentOutputLine = currentOutputLine + currentChar;
		    					currentCharCount++;
	    						//since we consume a character in the read in line we increase the i
		    					i++;
		    					//and we fetch next character of the line
		    					currentChar = Character.toString(currentLine.charAt(i));	
		    				}
		    				//if it is right justified add the number of leftover spaces in the beginning of the output line
		    				if(justified == 'r')
		    				{
		    					System.out.println("Justification is: " + justified);
		    					leftOverChars = lineLength - currentOutputLine.length();
		    					for(int k = 1; k <= leftOverChars; k++)
		    					{
		    						currentOutputLine = " " + currentOutputLine;
		    					}
		    				}
		    				//if it is center justified divide the number of leftover count in 2 and add half in the beginning
		    				if(justified == 'c')
		    				{
		    					System.out.println("Justification is: " + justified);
		    					System.out.println(leftoverCount);
		    					leftOverChars = lineLength - currentOutputLine.length();
		    					for(int k = 1; k <= leftOverChars/2; k++)
		    					{
		    						currentOutputLine = " " + currentOutputLine;
		    					}
		    				}
		    				//when we reach the maximum character length set for the output we set the char count to leftover char count
		    				//and we print the line to file using println and we reset the current output line to the word we have left from before
		    				//if it is double spaced print another line after it
		    				out.write(currentOutputLine);
		    				out.newLine();
		    				//if it is double spaced print another line after it
		    				if(space==2)
		    					out.newLine();
		    				currentOutputLine = "";
		    				currentCharCount = 0;
	    				}
	    				i--;
	    				System.out.println("Starting the next output line with the i="+i+" and the current count of characters = "+currentCharCount);
		    	}
		    	
	    	
    		//after we are done with reading in this line we scan in the next input line
	    	}
	    	//if two columns are on
	    	else
	    	{
	    		lineLength = 35;
	    	}
	    }
	    while (in1.hasNextLine());
	    out.close();
	    in1.close();
	    errLog.close();
	    
	 // PrintWriter object for file3.txt 
        PrintWriter pw = new PrintWriter("outputTest1.txt"); 
          
        // BufferedReader object for file1.txt 
        BufferedReader br = new BufferedReader(new FileReader("test1done.txt")); 
          
        String line = br.readLine(); 
          
        // loop to copy each line of  
        // file1.txt to  file3.txt 
        while (line != null) 
        { 
            pw.println(line); 
            line = br.readLine(); 
        } 
        pw.println(); 
        pw.println("The input file had " + errCount + " errors:"); 
        pw.println();
        br = new BufferedReader(new FileReader("errorLogTest1.txt")); 
          
        line = br.readLine(); 
          
        // loop to copy each line of  
        // file2.txt to  file3.txt 
        while(line != null) 
        { 
            pw.println(line); 
            line = br.readLine(); 
        } 
          
        pw.flush(); 
          
        // closing resources 
        br.close(); 
        pw.close(); 
	    
	 
	 }

}

