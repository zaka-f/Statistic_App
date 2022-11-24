package LoginArea;

import javax.swing.*;

import mainUI.MainUI;

//Singelton Design patern used here

public class LoginPage extends JFrame {

	private static LoginPage instance;
	
	public static LoginPage getInstance() {
		if (instance == null)
			instance = new LoginPage();

		return instance;
	}
	
	// Initialize buttons
	private static JTextField username;
	private static JButton button;
	private static JPasswordField password;
	private static JPanel panel;
	private static JLabel pd, un;

	// getter methods
	public static JTextField getUsername() {
		return username;
	}

	public static JPasswordField getPassword() {
		return password;
	}

	public static JPanel getPanel() {
		return panel;
	}

	// constructor
	LoginPage() {

		// password label
		pd = new JLabel();
		pd.setText("Password");

		// user name label
		un = new JLabel();
		un.setText("User Name");

		// login button
		button = new JButton();
		button.setText("Login");

		// password field
		password = new JPasswordField();

		// JTextField user name;
		username = new JTextField();

		// Creating a panel
		panel = new JPanel();
		panel.setLayout(null);

		// set the position of the user name label
		un.setBounds(10, 20, 80, 25);
		panel.add(un);

		// set the position of the user name text field
		username.setBounds(100, 20, 165, 25);
		panel.add(username);

		// set the position of the password label
		pd.setBounds(10, 65, 80, 25);
		panel.add(pd);

		// set the position of the password text field
		password.setBounds(100, 65, 165, 25);
		panel.add(password);

		// set the position of the button
		button.setBounds(100, 115, 80, 25);
		panel.add(button);
		button.addActionListener(new actionButtonLogin());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setting the panel in the frame
		add(panel);
		setTitle("Login Page");
		setSize(300, 200);
		setVisible(true);

	}

}
