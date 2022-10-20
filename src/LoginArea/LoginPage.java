package LoginArea;

import javax.swing.*;


public class LoginPage extends JFrame  {

	//Initialize buttons
	JLabel pd, un;
	JTextField username;
	JButton button;
	JPasswordField password;
	JPanel panel;
	
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
		
		un.setBounds(10, 20, 80, 25);
		panel.add(un);
		
		username.setBounds(100, 20, 165, 25);
		panel.add(username);
		
		pd.setBounds(10, 65, 80, 25);
		panel.add(pd);
		
		password.setBounds(100, 65, 165, 25);
		panel.add(password);
		
		button.setBounds(100, 115, 80, 25);
		panel.add(button);
		button.addActionListener(new creditentialsCheker());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel);
		setTitle("Login Page");
		setSize(300,200);
		setVisible(true);
		
	}	
	
	public static void main(String[] args) {
		
		new LoginPage();
		
	}
	

	
}
