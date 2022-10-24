package LoginArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainUI.MainUI;

public class actionButtonLogin implements ActionListener {

	// Action performed when the button is clicked.
	// It either update the Login UI or closes the login UI and lunch the main UI
	@Override
	public void actionPerformed(ActionEvent e) {

		// Calls the credentials checker function
		credentialChecker checker = new credentialChecker(LoginPage.getUsername().getText(),
				LoginPage.getPassword().getText());
		boolean access = checker.isUser();

		// makes a decision depending on if the user and password are in the data base
		if (access) {
			UILauncher.getnLoginPage().dispose();
			new MainUI();
			MainUI.main(null);
		} else {
			new displayMessageLoginUI();
		}
	}

}
