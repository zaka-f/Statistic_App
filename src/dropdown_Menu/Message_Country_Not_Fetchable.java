package dropdown_Menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import LoginArea.LoginPage;
import LoginArea.actionButtonLogin;

public class Message_Country_Not_Fetchable extends JFrame{
	
	private static Message_Country_Not_Fetchable instance;
	private static JLabel message;
	private static JPanel panel;
	
	public static Message_Country_Not_Fetchable getInstance() {
		if (instance == null)
			instance = new Message_Country_Not_Fetchable();

		return instance;
	}
	

	// constructor
	Message_Country_Not_Fetchable() {

		// password label
		message = new JLabel();
		message.setText("This Country's data is not avaiable");


		// Creating a panel
		panel = new JPanel();
		panel.setLayout(null);

		// set the position of the user name label
		message.setBounds(45, 50, 200, 25);
		panel.add(message);


		// setting the panel in the frame
		add(panel);
		setTitle("Login Page");
		setSize(300, 170);
		setVisible(true);
	}

}
