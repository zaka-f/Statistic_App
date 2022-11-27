package LoginArea;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class credentialCheckerProxy implements credentialCheckerDataRetriever {
	// instance variables
	private String username;
	private String password;
	private credentialChecker checker;
	private ArrayList<String> comboArrayList;

	// Constructors
	protected credentialCheckerProxy(String username, String password) {
		this.username = username;
		this.password = password;
		comboArrayList = new ArrayList<String>();
		checker = new credentialChecker(username, password);
	}

	// method checks if user exists in text file
	public ArrayList<String> getCombo() {
		comboArrayList = checker.getCombo();
		return comboArrayList;
	}

	public boolean isUser() {

		if (comboArrayList.size() == 0) {
			return false;
		} else if (!(comboArrayList.get(1)).equals(password)) {
			return false;
		}
		return true;

	}

}
