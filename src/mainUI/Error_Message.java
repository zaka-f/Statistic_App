package mainUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Error_Message extends JFrame{
	
	private JLabel message;
	private JPanel panel;


	// constructor
	public Error_Message(String text) {

		// password label
		message = new JLabel();
		message.setText(text);
//		"This Country's data is not avaiable for processing for now"

		// Creating a panel
		panel = new JPanel();
		panel.setLayout(null);

		// set the position of the user name label
		message.setBounds(45, 50, 400, 25);
		panel.add(message);


		// setting the panel in the frame
		add(panel);
		setTitle("Login Page");
		setSize(490, 170);
		setVisible(true);
	}

}
