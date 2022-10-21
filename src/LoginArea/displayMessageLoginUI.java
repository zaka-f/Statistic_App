package LoginArea;

import javax.swing.JLabel;

public class displayMessageLoginUI{
	
	static void updateLoginUI(){
		JLabel message = new JLabel();
		message.setText("Wrong Credentials");
		message.setBounds(90, 155, 150, 25);
		UILuncher.nLoginPage.panel.add(message);
		UILuncher.nLoginPage.setSize(300,245);
	}

}
