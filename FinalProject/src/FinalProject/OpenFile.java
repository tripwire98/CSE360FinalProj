import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;
public class OpenFile {

	// Declare Variable
	JFileChooser fileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
	
	public void PickFile() throws Exception {
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			// Get the file
			File file = fileChooser.getSelectedFile();
			
			// Create scanner
			Scanner input = new Scanner(file);
			
			// Read text from file
			while(input.hasNext()) {
				sb.append(input.nextLine());
				sb.append("\n");
				
			}
			
			input.close();
		} else {
			sb.append("Error with choosing file");
		}
	}
			
}
