package LoginArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class creditentialsCheker implements ActionListener{

	private String username = LoginPage.getUsername().getText(); 
	
	@SuppressWarnings("deprecation")
	private String password = LoginPage.getPassword().getText();
	
	public creditentialsCheker() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
