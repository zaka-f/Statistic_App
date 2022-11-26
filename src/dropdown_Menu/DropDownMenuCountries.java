package dropdown_Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LoginArea.LoginPage;
import LoginArea.UILauncher;
import LoginArea.credentialChecker;
import LoginArea.displayMessageLoginUI;
import mainUI.MainUI;
import mainUI.MainUI_Luncher;

public class DropDownMenuCountries implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("action performed");
		CountryFetchableChecker checker = new CountryFetchableChecker(String.valueOf(MainUI.getCountriesList().getSelectedItem()));
		boolean fetchable = checker.isUser();
		System.out.print(fetchable);
		
		// makes a decision depending on if the country's data is fetchable
		if (fetchable) {
			new MainUI_Luncher();
			MainUI_Luncher.main(null);
		} else {
			new Message_Country_Not_Fetchable();
		}
		
	}

}
