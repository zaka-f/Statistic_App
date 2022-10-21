package LoginArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionButtonLogin implements ActionListener{

	private String username; 
	
	private String password;
	

	public actionButtonLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print("here");
		credentialChecker checker = new credentialChecker(username, password);
		checker.isUser();
	}

}
