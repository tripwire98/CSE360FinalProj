import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class FileFormattedPopUp {

	private JFrame frame;

	// Launch the application
	 
	public static void FormattedPopUp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileFormattedPopUp window = new FileFormattedPopUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application
	 
	public FileFormattedPopUp() {
		initialize();
	}

	// Initialize the contents of the frame
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 451, 107);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 11, 359, 46);
		frame.getContentPane().add(panel);
		
		JLabel lblYourFileWas = new JLabel("Your file was successfully formatted!");
		lblYourFileWas.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblYourFileWas.setForeground(Color.BLUE);
		panel.add(lblYourFileWas);
	}

}
