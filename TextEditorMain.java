package TextEditor;
import java.io.File; 
import java.util.Scanner;  
import TextEditor.Word;

public class TextEditorMain 
{
	public static void main(String[] args) throws Exception 
  { 
	  Word current = new Word();
	  Word[] currentLine = new Word[10];
	  int numChar=0;
	  int numWord=0;
	  int numLines=0;
	  
    // pass the path to the file as a parameter 
	  File file = 
      new File("C:\\Users\\pankaj\\Desktop\\test.txt");
	  
    Scanner sc = new Scanner(file);
  
    while (sc.hasNextLine())
	{
    	 String line = sc.nextLine();
    	 numLines++;
    	 numChar = line.length();
    	 
		for (int i= 0 ; i<line.length(); i++)
		{
			if(line.charAt(i)!=' ') //if it is not the end of word keep counting the number of char and adding them to the word
			{
				current.content = current.content + Character.toString(line.charAt(i));
				current.charCount ++;
			}
			else//if it is an empty space finish the word and store it in array of words and count the empty space as a character total of line
			{
				currentLine[numWord] = current;
				numWord++;
				current.content = "";
				current.charCount = 0;
			}
			
		}
		//are we making an array for each read in line?
	}
			
  } 
}

