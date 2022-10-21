package LoginArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionButtonLogin implements ActionListener{

	public actionButtonLogin() {

	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		 System.out.print(LoginPage.getPassword().getText()+"\n");
//		 System.out.print(LoginPage.getUsername().getText()+"\n");
		credentialChecker checker = new credentialChecker(LoginPage.getUsername().getText(), LoginPage.getPassword().getText());
		checker.isUser();
	}

}
