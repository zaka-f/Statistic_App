package LoginArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionButtonLogin implements ActionListener{

	private String username = LoginPage.getUsername().getText(); 
	
	@SuppressWarnings("deprecation")
	private String password = LoginPage.getPassword().getText();
	

	@Override
	public void actionPerformed(ActionEvent e) {
		new credentialChecker(username, password);	
	}

}
