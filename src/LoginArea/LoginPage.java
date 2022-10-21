package LoginArea;

import javax.swing.*;


public class LoginPage extends JFrame  {

	//Initialize buttons
	private static JLabel pd, un;
	private static JTextField username;
	private static JButton button;
	private static JPasswordField password;
	private static JPanel panel;
	
	//getter and setter methods
	public static JLabel getPd() {
		return pd;
	}

	public void setPd(JLabel pd) {
		this.pd = pd;
	}

	public static JLabel getUn() {
		return un;
	}

	public void setUn(JLabel un) {
		this.un = un;
	}

	public static JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public static JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public static JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	//end of gettor and setter methods
	
	//constructor
	LoginPage(){
		
		//password label
		pd = new JLabel();
		pd.setText("Password");
		
		//user name label 
		un = new JLabel();
		un.setText("User Name");
		
		//login button
		button = new JButton();
		button.setText("Login");
		
		//password field
		password = new JPasswordField();
		
		//JTextField user name;
		username = new JTextField();
		
		//Creating a panel
		panel = new JPanel();
		panel.setLayout(null);
		
		//set the position of the user name label
		un.setBounds(10, 20, 80, 25);
		panel.add(un);
		
		//set the position of the user name text field
		username.setBounds(100, 20, 165, 25);
		panel.add(username);
		
		//set the position of the password label
		pd.setBounds(10, 65, 80, 25);
		panel.add(pd);
		
		//set the position of the password text field
		password.setBounds(100, 65, 165, 25);
		panel.add(password);
		
		//set the position of the button
		button.setBounds(100, 115, 80, 25);
		panel.add(button);
		button.addActionListener(new creditentialsCheker());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setting the panel in the frame
		add(panel);
		setTitle("Login Page");
		setSize(300,200);
		setVisible(true);
		
	}	
	
}
