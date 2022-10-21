package LoginArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionButtonLogin implements ActionListener{

	public actionButtonLogin() {

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		credentialChecker checker = new credentialChecker(LoginPage.getUsername().getText(), LoginPage.getPassword().getText());
		boolean access = checker.isUser();
		if(access) {
			//lunch the app
		}
		else {
			displayMessageLoginUI.updateLoginUI();
		}
	}

}
