package LoginArea;

import javax.swing.JLabel;

public class displayMessageLoginUI {

	// function to update the login user interface and display 'wrong credentials
	// message'
	protected displayMessageLoginUI() {

		// Creating a Label for the message
		JLabel message = new JLabel();
		message.setText("Wrong Credentials");
		message.setBounds(90, 155, 150, 25);

		// Atualising the login UI
		UILauncher.getnLoginPage();
		UILauncher.getnLoginPage().setSize(300, 245);
		LoginPage.getPanel().add(message);

	}

}
