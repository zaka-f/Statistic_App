package dropdown_Menu_Countries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LoginArea.LoginPage;
import LoginArea.UILauncher;
import LoginArea.credentialChecker;
import LoginArea.displayMessageLoginUI;
import mainUI.Error_Message;
import mainUI.MainUI;
import mainUI.MainUI_Luncher;

public class DropDownMenuCountriesAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ProxyCountryFetchableChecker checker = new ProxyCountryFetchableChecker(
				String.valueOf(MainUI.getCountriesList().getSelectedItem()));
		boolean fetchable = checker.isFetchable();
		System.out.print(fetchable);

		// makes a decision depending on if the country's data is fetchable
		if (fetchable) {
			new MainUI_Luncher();
			MainUI_Luncher.main(null);
		} else {
			new Error_Message("This Country's data is not avaiable for processing for now");
		}

	}

}
