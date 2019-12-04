import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class AppWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	//  Launch the application 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application
	
	public AppWindow() {
		initialize();
	}

	// Initialize contents of the frame
	 
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Text Editor", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(68, 21, 303, 32);
		frame.getContentPane().add(lblNewLabel);
		
		// Temporary TODO : Replace text field with place file will be saved
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setForeground(new Color(0, 0, 255));
		textArea.setBounds(28, 162, 380, 88);
		frame.getContentPane().add(textArea);
		
		JButton btnUploadAndRun = new JButton("Open File");
		btnUploadAndRun.setBackground(Color.LIGHT_GRAY);
		btnUploadAndRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenFile of = new OpenFile();
				
				try {
					of.PickFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				textArea.setText(of.sb.toString());
			}
		});
		
		btnUploadAndRun.setBounds(68, 64, 132, 23);
		frame.getContentPane().add(btnUploadAndRun);
		
		JButton btnNewButton = new JButton("Upload and Run");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
			// If file runs successfully show pop up
			FileFormattedPopUp popUp = new FileFormattedPopUp();
			// popUp.FormattedPopUp(); // TODO : Not working
			
			
		});
		btnNewButton.setBounds(68, 113, 132, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save File");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO: Save file
			}
		});
		btnNewButton_1.setBounds(239, 64, 132, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save and Quit");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(239, 113, 132, 23);
		frame.getContentPane().add(btnNewButton_2);
		
	
		
	}
}
