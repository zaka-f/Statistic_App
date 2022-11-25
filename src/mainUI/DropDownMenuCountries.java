package mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LoginArea.LoginPage;
import LoginArea.credentialChecker;

public class DropDownMenuCountries implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action performed");
		CountryFetchableChecker checker = new CountryFetchableChecker(MainUI.getCountriesList().getSelectedItem().toString());
		boolean access = checker.isUser();
		System.out.print(access);
		
	}

}
