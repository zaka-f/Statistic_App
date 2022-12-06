package countries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import error_message.ErrorMessage;
import mainUI.MainUI;
import mainUI.MainUILuncher;

public class DropDownMenuCountriesAction implements ActionListener {

	boolean fetchable;
	
	public boolean isFetchable() {
		return fetchable;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ProxyCountryFetchableChecker checker = new ProxyCountryFetchableChecker(
				String.valueOf(MainUI.getCountriesList().getSelectedItem()));
		fetchable = checker.isFetchable();

		// makes a decision depending on if the country's data is fetchable
		if (fetchable) {
			new MainUILuncher();
			MainUILuncher.main(null);
		} else {
			new ErrorMessage("This Country's data is not avaiable for processing for now");
		}

	}

}
