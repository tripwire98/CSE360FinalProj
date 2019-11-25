package TextEditor;
import java.io.File; 
import java.util.Scanner;  
import Word;
public class TextEditor 
{ 
  public static void main(String[] args) throws Exception 
  { 
	int numChar=0;
	int numWord=0;
    // pass the path to the file as a parameter 
    File file = 
      new File("C:\\Users\\pankaj\\Desktop\\test.txt");
	  
    Scanner sc = new Scanner(file); 
  
    while (sc.hasNextLine())
	{
		while (next character is not next line)
		{
			while(next character is not space)
			{
				String word = + sc.next;
				numChar ++;
			}
			//store the word in array
			
			numWord ++;
			//store the length of this word in an array?
			sc.next;
			numChar ++;
		}
		//are we making an array for each read in line?
	}
			
  } 
} 

