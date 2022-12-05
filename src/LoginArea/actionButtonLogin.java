package loginArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainUI.MainUILuncher;

public class actionButtonLogin implements ActionListener {

	boolean access;
	
	public boolean isAccess() {
		return access;
	}


	// Action performed when the button is clicked.
	// It either update the Login UI or closes the login UI and lunch the main UI
	@Override
	public void actionPerformed(ActionEvent e) {

		// Calls the credentials checker proxy function
		credentialCheckerProxy checker = new credentialCheckerProxy(LoginPage.getUsername().getText(),
				LoginPage.getPassword().getText());
		access = checker.isUser();

		// makes a decision depending on if the user and password are in the data base
		if (access) {
			UILauncher.getnLoginPage().dispose();
			new MainUILuncher();
			MainUILuncher.main(null);
		} else {
			new displayMessageLoginUI();
		}
	}

}
